-- 코드를 입력하세요
SELECT 
    T1.CAR_ID, 
    CASE
        WHEN T2.CAR_ID IS NULL THEN '대여 가능'
        ELSE '대여중'
    END AS AVAILABILITY
FROM (
    SELECT HISTORY_ID, CAR_ID 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    GROUP BY CAR_ID) T1
LEFT JOIN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-10-16'
    AND '2022-10-16' <= END_DATE) T2
ON T1.CAR_ID = T2.CAR_ID
ORDER BY T1.CAR_ID DESC

-- 1. EXIST
# SELECT 
#     DISTINCT C.CAR_ID,
#     CASE
#         WHEN EXISTS (
#             SELECT 1
#             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY R
#             WHERE R.CAR_ID = C.CAR_ID
#               AND R.START_DATE <= DATE'2022-10-16'
#               AND DATE'2022-10-16' <= R.END_DATE
#         ) THEN '대여중'
#         ELSE '대여 가능'
#     END AS AVAILABILITY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C
# ORDER BY C.CAR_ID DESC;

-- 2. 서브쿼리를 이용한 컬럼비교
# SELECT 
#     DISTINCT C.CAR_ID,
#     CASE
#         WHEN ( 
#             SELECT COUNT(*) 
#             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY R
#             WHERE R.CAR_ID = C.CAR_ID
#               AND R.START_DATE <= DATE'2022-10-16'
#               AND DATE'2022-10-16' <= R.END_DATE
#         ) > 0
#         THEN '대여중'
#         ELSE '대여 가능'
#     END AS AVAILABILITY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C
# ORDER BY C.CAR_ID DESC;