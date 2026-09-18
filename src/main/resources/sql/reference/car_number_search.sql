/*
 * 차량번호·차대번호 검색 참고.
 * REVERSE 인덱스 적용 여부는 실제 데이터 분포와 실행계획으로 결정합니다.
 */

-- 차량번호 전체 또는 뒷자리 검색 분리 예시
SELECT	V_ENTRYCD
	,	V_CARCD
	,	V_CARNO
FROM	CAU_CAR_INFO
WHERE	(
			:LENGTH_KIND = 'FULL'
			AND V_CARNO = :KEYWORD
		)
OR		(
			:LENGTH_KIND = 'LAST4'
			AND REVERSE(V_CARNO) LIKE REVERSE(:KEYWORD) || '%'
		);

-- 차대번호는 전방 일치로 인덱스 범위를 유지
SELECT	V_ENTRYCD
	,	V_CARCD
FROM	CAU_CAR_INFO
WHERE	V_CARCD LIKE :VIN_PREFIX || '%';
