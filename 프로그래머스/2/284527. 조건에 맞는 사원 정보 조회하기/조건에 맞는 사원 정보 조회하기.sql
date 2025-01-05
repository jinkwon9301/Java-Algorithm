-- 코드를 작성해주세요
SELECT 
    SUM(T2.SCORE) AS SCORE, 
    T1.EMP_NO,
    T1.EMP_NAME,
    T1.POSITION,
    T1.EMAIL
FROM HR_EMPLOYEES T1
JOIN HR_GRADE T2
ON T1.EMP_NO = T2.EMP_NO
GROUP BY T1.EMP_NO
ORDER BY SCORE DESC
LIMIT 1
;



-- 윈도우함수 활용법
# SELECT 
#     TotalScores.SCORE, 
#     E.EMP_NO,
#     E.EMP_NAME,
#     E.POSITION,
#     E.EMAIL
# FROM (
#     SELECT 
#         G.EMP_NO,
#         SUM(G.SCORE) AS SCORE,
#         ROW_NUMBER() OVER (ORDER BY SUM(G.SCORE) DESC) AS RN
#     FROM HR_GRADE G
#     WHERE G.YEAR = 2022
#     GROUP BY G.EMP_NO
# ) TotalScores
# JOIN HR_EMPLOYEES E
#     ON TotalScores.EMP_NO = E.EMP_NO
# WHERE TotalScores.RN = 1;



-- 윈도우 함수(RANK())를 사용한 방법 (동점자 포함)
-- 만약 최고 점수를 가진 사원이 여러 명일 수 있고, 모든 최고 점수 사원을 조회하고자 한다면 RANK() 함수를 사용하는 것이 좋습니다.
# SELECT 
#     TotalScores.SCORE, 
#     E.EMP_NO,
#     E.EMP_NAME,
#     E.POSITION,
#     E.EMAIL
# FROM (
#     SELECT 
#         G.EMP_NO,
#         SUM(G.SCORE) AS SCORE,
#         RANK() OVER (ORDER BY SUM(G.SCORE) DESC) AS Rnk
#     FROM HR_GRADE G
#     WHERE G.YEAR = 2022
#     GROUP BY G.EMP_NO
# ) TotalScores
# JOIN HR_EMPLOYEES E
#     ON TotalScores.EMP_NO = E.EMP_NO
# WHERE TotalScores.Rnk = 1;



-- 윈도우 함수(DENSE_RANK())를 사용한 방법 (동점자 포함)
-- DENSE_RANK()도 RANK()와 유사하게 동점자에게 동일한 순위를 부여하지만, 순위의 간격이 없이 연속적으로 매겨집니다. 최고 점수 사원이 여러 명일 경우에도 모두 조회됩니다.
# SELECT 
#     TotalScores.SCORE, 
#     E.EMP_NO,
#     E.EMP_NAME,
#     E.POSITION,
#     E.EMAIL
# FROM (
#     SELECT 
#         G.EMP_NO,
#         SUM(G.SCORE) AS SCORE,
#         DENSE_RANK() OVER (ORDER BY SUM(G.SCORE) DESC) AS DenseRnk
#     FROM HR_GRADE G
#     WHERE G.YEAR = 2022
#     GROUP BY G.EMP_NO
# ) TotalScores
# JOIN HR_EMPLOYEES E
#     ON TotalScores.EMP_NO = E.EMP_NO
# WHERE TotalScores.DenseRnk = 1;
