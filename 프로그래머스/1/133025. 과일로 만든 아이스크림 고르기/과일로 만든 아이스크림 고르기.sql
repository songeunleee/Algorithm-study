-- 코드를 입력하세요
SELECT F.FLAVOR FROM ICECREAM_INFO I JOIN FIRST_HALF F
ON I.FLAVOR = F.FLAVOR
WHERE I.INGREDIENT_TYPE = 'fruit_based' AND F.TOTAL_ORDER > 3000
ORDER BY F.TOTAL_ORDER DESC