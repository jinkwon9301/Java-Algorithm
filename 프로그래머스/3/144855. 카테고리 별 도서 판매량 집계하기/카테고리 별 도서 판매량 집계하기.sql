-- 코드를 입력하세요
SELECT 
    B.CATEGORY,
    SUM(S.SALES) AS TOTAL_SALES
FROM BOOK B
JOIN BOOK_SALES S
ON B.BOOK_ID = S.BOOK_ID
WHERE YEAR(sales_date) = 2022
AND MONTH(sales_date) = 1
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY
;