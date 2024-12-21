-- 코드를 입력하세요
SELECT T1.CATEGORY, T1.MAX_PRICE, T2.PRODUCT_NAME
FROM (
    SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY) T1
JOIN FOOD_PRODUCT T2
ON T1.CATEGORY = T2.CATEGORY
AND T1.MAX_PRICE = T2.PRICE
WHERE T1.CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY T1.MAX_PRICE DESC
;