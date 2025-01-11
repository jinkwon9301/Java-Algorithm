-- 코드를 작성해주세요
SELECT
    COUNT(*) AS FISH_COUNT,
    FISH_NAME
FROM FISH_INFO T1
JOIN FISH_NAME_INFO T2
ON T1.FISH_TYPE = T2.FISH_TYPE
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC
;