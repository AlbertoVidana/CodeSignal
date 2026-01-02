-- TODO: Write a query to categorize phases based on their average IMDb ratings and calculate additional statistics for each phase.
SELECT
    movies.phase,
    CASE
        WHEN ROUND(AVG(movie_details.imdb_rating), 1) < 7 THEN 'Okay'
        WHEN ROUND(AVG(movie_details.imdb_rating), 1) BETWEEN 7 AND 7.5 THEN 'Good'
        ELSE 'Great'
    END AS "Phase Rating",
    COUNT(characters.character_id) AS "Phase Character Count",
    ROUND(SUM(movie_details.box_office_million_usd) - SUM(movie_details.budget_million_usd), 2) AS "Phase Profit in Millions"
FROM
    movies
INNER JOIN movie_details ON movie_details.movie_id = movies.movie_id
INNER JOIN characters ON movies.movie_id = characters.movie_id
WHERE movie_details.runtime_minutes > 120
GROUP BY movies.phase;
/* Database Reference
movies: movie_id, movie_name, release_date, phase
movie_details: movie_id, budget_million_usd, box_office_million_usd, imdb_rating, runtime_minutes
characters: character_id, movie_id, character_name, actor, screen_time_minutes
*/