-- 코드를 입력하세요
SELECT 
    FOOD_TYPE,
    REST_ID,
    REST_NAME,
    FAVORITES
FROM REST_INFO T1
WHERE FAVORITES = (
    SELECT
        MAX(FAVORITES)
    FROM REST_INFO T2
    WHERE T1.FOOD_TYPE = T2.FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC
;