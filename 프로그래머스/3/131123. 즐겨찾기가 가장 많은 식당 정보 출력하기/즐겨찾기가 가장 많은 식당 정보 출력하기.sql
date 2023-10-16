-- 코드를 입력하세요
SELECT F.FOOD_TYPE, F.REST_ID, F.REST_NAME, F.FAVORITES
FROM REST_INFO F,
(SELECT FOOD_TYPE, MAX(FAVORITES) M
FROM REST_INFO
GROUP BY FOOD_TYPE) O
WHERE F.FAVORITES = O.M AND F.FOOD_TYPE = O.FOOD_TYPE
ORDER BY F.FOOD_TYPE DESC;
