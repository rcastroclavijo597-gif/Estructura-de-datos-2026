import javax.script.*;
import java.util.*;
import java.util.regex.*;

public class PuntoFijoAutoStop {

    static class Expr {
        private ScriptEngine engine;
        private String expr;

        Expr(String raw) throws ScriptException {
            this.engine = new ScriptEngineManager().getEngineByName("JavaScript");
            String e = raw;
            e = e.replaceAll("(?i)\\bsin\\b", "Math.sin");
            e = e.replaceAll("(?i)\\bcos\\b", "Math.cos");
            e = e.replaceAll("(?i)\\btan\\b", "Math.tan");
            e = e.replaceAll("(?i)\\bexp\\b", "Math.exp");
            e = e.replaceAll("(?i)\\be\\^", "Math.exp");
            e = e.replaceAll("(?i)\\blog\\b", "Math.log");
            e = e.replaceAll("(?i)\\bsqrt\\b", "Math.sqrt");
            e = e.replaceAll("(?i)\\babs\\b", "Math.abs");
            e = e.replaceAll("(?i)\\bpow\\b", "Math.pow");
            e = e.replaceAll("(\\b\\w+\\b)\\s*\\^\\s*(\\b\\w+\\b)", "Math.pow($1,$2)");
            this.expr = e;
            engine.put("x", 1.0);
            engine.eval(this.expr);
        }

        double eval(double x) throws ScriptException {
            engine.put("x", x);
            Object res = engine.eval(this.expr);
            if (res instanceof Number)
                return ((Number) res).doubleValue();
            throw new ScriptException("Expresión no numérica");
        }
    }

    // intento simple de despeje para casos como "exp(x)-x" -> "exp(x)"
    static String intentarDespejarG(String fx) {
        String s = fx.replaceAll("\\s+", "");
        if (s.contains("-x")) {
            String g = s.replaceFirst("-x", "");
            return g.isEmpty() ? "0" : g;
        }
        if (s.contains("+x")) {
            String g = s.replaceFirst("\\+x", "");
            return g.isEmpty() ? "0" : g;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese f(x) (ej: exp(x)-x  o  x*x-2):");
            String fx = sc.nextLine().trim();
            if (fx.isEmpty()) {
                System.out.println("Se requiere f(x).");
                return;
            }

            System.out.println("¿Deseas que intente despejar x automáticamente para obtener g(x)? (s/n):");
            String resp = sc.nextLine().trim().toLowerCase();

            String gxStr = null;
            if (resp.equals("s") || resp.equals("si")) {
                String intento = intentarDespejarG(fx);
                if (intento != null) {
                    gxStr = intento;
                    System.out.println("Se detectó g(x) automáticamente: g(x) = " + gxStr);
                } else {
                    System.out.println("No se pudo despejar automáticamente de forma segura.");
                }
            }

            if (gxStr == null) {
                System.out.println("Introduce la fórmula de g(x) (la expresión que da x en función de x):");
                System.out.println("Ejemplo: para exp(x)-x escribe: exp(x)   ; para cos(x)-x escribe: cos(x)");
                gxStr = sc.nextLine().trim();
                if (gxStr.isEmpty()) {
                    System.out.println("Se requiere g(x). Fin.");
                    return;
                }
            }

            System.out.println("Ingrese x0 (valor inicial, llamado i):");
            double x0 = Double.parseDouble(sc.nextLine().trim());

            System.out.println("Ingrese tolerancia en porcentaje (ej: 0.01 para 0.01%):");
            double tolPercent = Double.parseDouble(sc.nextLine().trim());
            if (tolPercent < 0) {
                System.out.println("Tolerancia inválida.");
                return;
            }

            Expr g = new Expr(gxStr);

            System.out.println();
            System.out.println("| iteración | i | xi | g(xi) | E (%) |");
            System.out.println("|---:|---:|---:|---:|---:|");

            double xi = x0;
            double prev;
            final int MAX_SAFE = 10000; // tope interno de seguridad
            for (int k = 1; k <= MAX_SAFE; k++) {
                prev = xi;
                double gxVal = g.eval(prev);
                xi = gxVal;
                String Estr;
                if (k == 1) {
                    Estr = "-";
                    System.out.printf("| %d | %d | %.12e | %.12e | %s |%n", k, k, xi, gxVal, Estr);
                    continue;
                } else {
                    double Epercent = (xi != 0.0) ? Math.abs((xi - prev) / xi) * 100.0 : Math.abs(xi - prev) * 100.0;
                    Estr = String.format("%.6e", Epercent);
                    System.out.printf("| %d | %d | %.12e | %.12e | %s |%n", k, k, xi, gxVal, Estr);
                    if (Epercent < tolPercent) {
                        // condición de paro cumplida
                        break;
                    }
                }
            }
            // si se alcanza MAX_SAFE sin converger, el programa termina mostrando lo
            // obtenido.
        } catch (ScriptException se) {
            System.out.println("Error al evaluar la expresión: " + se.getMessage());
        } catch (NumberFormatException ne) {
            System.out.println("Entrada numérica inválida: " + ne.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            sc.close();
        }
    }
}