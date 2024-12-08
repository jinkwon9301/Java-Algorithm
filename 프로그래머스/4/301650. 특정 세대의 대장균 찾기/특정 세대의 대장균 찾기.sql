-- 코드를 작성해주세요
# SELECT E3.ID
# FROM ECOLI_DATA E1
# JOIN ECOLI_DATA E2
# ON E1.ID = E2.PARENT_ID
# JOIN ECOLI_DATA E3
# ON E2.ID = E3.PARENT_ID
# WHERE E1.PARENT_ID IS NULL
# AND E3.ID IS NOT NULL
# ORDER BY ID
# ;

WITH RECURSIVE GenerationCTE AS (
    -- 1세대: PARENT_ID가 NULL인 대장균
    SELECT 
        ID,
        PARENT_ID,
        1 AS generation
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    -- N세대: 이전 세대의 자식들을 포함
    SELECT 
        e.ID,
        e.PARENT_ID,
        g.generation + 1 AS generation
    FROM ECOLI_DATA e
    INNER JOIN GenerationCTE g
    ON e.PARENT_ID = g.ID
)
-- 3세대 대장균 선택
SELECT 
    ID
FROM GenerationCTE
WHERE generation = 3
ORDER BY ID;