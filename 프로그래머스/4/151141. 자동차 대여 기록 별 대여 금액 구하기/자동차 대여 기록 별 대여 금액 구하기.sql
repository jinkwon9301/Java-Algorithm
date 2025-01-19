WITH DiscountedPolicies AS (
    SELECT
        h.HISTORY_ID,
        c.DAILY_FEE,
        DATEDIFF(h.END_DATE, h.START_DATE) + 1 AS RENTAL_DAYS,
        dp.DISCOUNT_RATE,
        CAST(REGEXP_SUBSTR(dp.DURATION_TYPE, '[0-9]+') AS UNSIGNED) AS MIN_DAYS
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    JOIN
        CAR_RENTAL_COMPANY_CAR c
    ON
        h.CAR_ID = c.CAR_ID
    LEFT JOIN
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp
    ON
        c.CAR_TYPE = dp.CAR_TYPE
        AND DATEDIFF(h.END_DATE, h.START_DATE) + 1 >= CAST(REGEXP_SUBSTR(dp.DURATION_TYPE, '[0-9]+') AS UNSIGNED)
    WHERE
        c.CAR_TYPE = '트럭'
),
SelectedPolicies AS (
    SELECT
        HISTORY_ID,
        DAILY_FEE,
        RENTAL_DAYS,
        DISCOUNT_RATE
    FROM (
        SELECT
            dp.*,
            ROW_NUMBER() OVER (PARTITION BY HISTORY_ID ORDER BY MIN_DAYS DESC) AS rn
        FROM
            DiscountedPolicies dp
    ) t
    WHERE rn = 1
)
SELECT
    sp.HISTORY_ID,
    FLOOR(sp.DAILY_FEE * sp.RENTAL_DAYS * (1 - IFNULL(sp.DISCOUNT_RATE, 0) / 100)) AS FEE
FROM
    SelectedPolicies sp
ORDER BY
    FEE DESC,
    HISTORY_ID DESC;
