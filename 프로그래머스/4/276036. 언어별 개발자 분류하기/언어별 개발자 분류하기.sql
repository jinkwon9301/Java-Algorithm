WITH 
FE_MASK AS (
    SELECT SUM(CODE) AS mask 
    FROM SKILLCODES 
    WHERE CATEGORY = 'Front End'
),
PYTHON_MASK AS (
    SELECT CODE AS mask 
    FROM SKILLCODES 
    WHERE NAME = 'Python'
),
C_SHARP_MASK AS (
    SELECT CODE AS mask 
    FROM SKILLCODES 
    WHERE NAME = 'C#'
)
SELECT
    CASE
        WHEN (DEVELOPERS.SKILL_CODE & FE_MASK.mask) != 0 
             AND (DEVELOPERS.SKILL_CODE & PYTHON_MASK.mask) != 0 THEN 'A'
        WHEN (DEVELOPERS.SKILL_CODE & C_SHARP_MASK.mask) != 0 THEN 'B'
        WHEN (DEVELOPERS.SKILL_CODE & FE_MASK.mask) != 0 THEN 'C'
        ELSE NULL
    END AS GRADE,
    DEVELOPERS.ID,
    DEVELOPERS.EMAIL
FROM 
    DEVELOPERS
    CROSS JOIN FE_MASK
    CROSS JOIN PYTHON_MASK
    CROSS JOIN C_SHARP_MASK
WHERE
    (
        (DEVELOPERS.SKILL_CODE & FE_MASK.mask) != 0 
        AND 
        (DEVELOPERS.SKILL_CODE & PYTHON_MASK.mask) != 0
    )
    OR 
    (DEVELOPERS.SKILL_CODE & C_SHARP_MASK.mask) != 0
    OR 
    (DEVELOPERS.SKILL_CODE & FE_MASK.mask) != 0
ORDER BY
    GRADE ASC,
    DEVELOPERS.ID ASC;
