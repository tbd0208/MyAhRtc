/*
 * 사용자별 최신 입찰을 먼저 고른 뒤 출품별 우선순위를 정하는 참고 골격.
 * CAU_BID의 실제 일시·금액 컬럼명은 원본 매퍼에서 확인해 채웁니다.
 */
WITH USER_LATEST AS (
	SELECT	B.*
		,	ROW_NUMBER() OVER (
				PARTITION BY B.V_ENTRYCD, B.V_REG_USERID
				ORDER BY /* 실제 입찰일시 컬럼 */ B.ROWID DESC
			) AS USER_RN
	FROM	CAU_BID B
),
ENTRY_RANK AS (
	SELECT	U.*
		,	ROW_NUMBER() OVER (
				PARTITION BY U.V_ENTRYCD
				ORDER BY /* 실제 입찰가 컬럼 */ U.ROWID DESC
			) AS ENTRY_RN
	FROM	USER_LATEST U
	WHERE	U.USER_RN = 1
)
SELECT	*
FROM	ENTRY_RANK
WHERE	ENTRY_RN = 1;
