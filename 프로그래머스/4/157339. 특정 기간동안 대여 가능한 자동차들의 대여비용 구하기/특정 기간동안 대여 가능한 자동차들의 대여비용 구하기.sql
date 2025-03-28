SELECT
     C.CAR_ID
    ,C.CAR_TYPE
    ,ROUND(C.DAILY_FEE * 30 * (1 - DP.DISCOUNT_RATE / 100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP
ON C.CAR_TYPE = DP.CAR_TYPE
WHERE C.CAR_TYPE IN ('세단', 'SUV')
-- 할인 정책에서 "30일 이상"을 적용해야 하므로 30 이상으로 필터링
AND TO_NUMBER(REGEXP_SUBSTR(DP.DURATION_TYPE, '[0-9]+')) = 30
-- 11월 1일부터 11월 30일까지 대여 이력이 없는 차량만 조회
AND C.CAR_ID NOT IN (
    SELECT DISTINCT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= DATE '2022-11-30'
    AND END_DATE >= DATE '2022-11-01'
)
-- 할인 적용 후 30일 대여료가 50만원 이상 200만원 미만
AND ROUND(C.DAILY_FEE * 30 * (1 - DP.DISCOUNT_RATE / 100)) BETWEEN 500000 AND 2000000
-- 정렬: 1. FEE 내림차순, 2. CAR_TYPE 오름차순, 3. CAR_ID 내림차순
ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC;
