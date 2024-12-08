-- 코드를 작성해주세요
# WITH RankedData AS (
#     SELECT
#         ID,
#         SIZE_OF_COLONY,
#         NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS quartile
#     FROM ECOLI_DATA
# ),
# ClassifiedData AS (
#     SELECT
#         ID,
#         CASE quartile
#             WHEN 1 THEN 'CRITICAL'
#             WHEN 2 THEN 'HIGH'
#             WHEN 3 THEN 'MEDIUM'
#             WHEN 4 THEN 'LOW'
#         END AS COLONY_NAME
#     FROM RankedData
# )
# SELECT
#     ID,
#     COLONY_NAME
# FROM ClassifiedData
# ORDER BY ID;


WITH RankedData AS (
    SELECT 
        ID, 
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS quartile
    FROM ECOLI_DATA
)
SELECT 
    ID,
    CASE quartile
        WHEN 1 THEN 'CRITICAL'
        WHEN 2 THEN 'HIGH'
        WHEN 3 THEN 'MEDIUM'
        ELSE        'LOW'
    END AS COLONY_NAME
FROM RankedData
ORDER BY ID;
