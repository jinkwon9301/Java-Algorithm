-- 비트연산 & (지피티에게 비트연산 &에 대해 물어볼 것)
SELECT DISTINCT a.ID, a.EMAIL, a.FIRST_NAME, a.LAST_NAME
FROM DEVELOPERS a, SKILLCODES b
WHERE 
    (a.SKILL_CODE & b.CODE) > 0
     AND b.NAME IN ("Python", "C#")
ORDER BY a.ID;