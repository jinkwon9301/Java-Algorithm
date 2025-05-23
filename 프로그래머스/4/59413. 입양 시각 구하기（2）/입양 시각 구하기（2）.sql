-- 코드를 입력하세요
WITH RECURSIVE HOURS AS (
    -- 시작: 0시
    SELECT 0 AS HOUR
    UNION ALL
    -- 23시까지 1증가
    SELECT HOUR + 1
    FROM HOURS
    WHERE HOUR < 23
)

SELECT
    HOURS.HOUR,
     IFNULL(COUNT, 0) AS COUNT
FROM HOURS
LEFT JOIN (
    SELECT
        HOUR(DATETIME) AS HOUR,
        COUNT(*) AS COUNT
    FROM ANIMAL_OUTS
    GROUP BY HOUR(DATETIME)
    ORDER BY HOUR
) T1
ON HOURS.HOUR = T1.HOUR
;
