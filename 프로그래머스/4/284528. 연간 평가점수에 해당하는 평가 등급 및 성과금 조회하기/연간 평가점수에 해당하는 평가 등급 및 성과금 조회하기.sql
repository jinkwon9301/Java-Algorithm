-- 코드를 작성해주세요
SELECT 
    T1.EMP_NO,
    T1.EMP_NAME,
    CASE
        WHEN SUM(T2.SCORE) / 2 >= 96 THEN 'S'
        WHEN SUM(T2.SCORE) / 2 >= 90 THEN 'A'
        WHEN SUM(T2.SCORE) / 2 >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN SUM(T2.SCORE) / 2 >= 96 THEN T1.SAL * 0.2
        WHEN SUM(T2.SCORE) / 2 >= 90 THEN T1.SAL * 0.15
        WHEN SUM(T2.SCORE) / 2 >= 80 THEN T1.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES T1
JOIN HR_GRADE T2
ON T1.EMP_NO = T2.EMP_NO
GROUP BY T1.EMP_NO
ORDER BY T1.EMP_NO
;