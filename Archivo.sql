SELECT f.title, l.name
FROM film AS f
LEFT JOIN language AS l
ON l.language_id = f.language_id

SELECT a.first_name, a.last_name, f.title
FROM actor AS a
INNER JOIN film_actor AS fa
ON fa.actor_id = a.actor_id
INNER JOIN film AS f
ON f.film_id = fa.film_id

SELECT c.first_name, c.last_name, ci.city
FROM customer AS c
LEFT JOIN address AS a
ON a.address_id = c.address_id
LEFT JOIN city AS ci
ON ci.city_id = a.city_id

SELECT f.title, c.name
FROM film AS f
LEFT JOIN film_category AS fc
ON fc.film_id = f.film_id
LEFT JOIN category AS c
ON c.category_id = fc.category_id

SELECT c.first_name, f.title, r.rental_date
FROM rental AS r
INNER JOIN customer AS c
ON c.customer_id = r.customer_id
INNER JOIN inventory AS i
ON i.inventory_id = r.inventory_id
INNER JOIN film AS f
ON f.film_id = i.film_id

SELECT c.first_name, r.rental_id
FROM customer AS c
INNER JOIN rental AS r
ON r.customer_id = c.customer_id

SELECT s.first_name, p.amount
FROM payment AS p
INNER JOIN staff AS s
ON s.staff_id = p.staff_id



