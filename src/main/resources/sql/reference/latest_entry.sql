/*
 * 원출품/재출품 관계에서 최신 출품 한 건을 찾는 참고 패턴.
 * 실제 업무에서는 V_ORI_ENTRYCD, N_REENTRY_CNT의 값 규칙을 먼저 검증합니다.
 */
SELECT	*
FROM	(
		SELECT	CER.*
			,	ROW_NUMBER() OVER (
					PARTITION BY NVL(CER.V_ORI_ENTRYCD, CER.V_ENTRYCD)
					ORDER BY CER.N_REENTRY_CNT DESC, CER.V_ENTRYCD DESC
				) AS RN
		FROM	CAU_ENTRY CER
	)
WHERE	RN = 1;
