# V2 점진적 전환

## 목적

기존 MyBatis 파일과 리팩터링 SQL을 분리해 운영 위험을 낮추면서 동일 입력·동일 결과를 비교합니다.

## 권장 순서

1. 기존 Statement ID는 유지합니다.
2. 별도 V2 매퍼에 새 Statement를 만듭니다.
3. 세션 또는 지정된 테스트 사용자 ID로 V2 호출을 선택합니다.
4. 동일 조건에서 건수, 키, 금액 합계, 상태 분포를 비교합니다.
5. 성능은 평균뿐 아니라 최댓값과 실행계획을 함께 기록합니다.
6. 검증된 사용자 범위를 점진적으로 넓힙니다.
7. 문제가 생기면 설정만으로 기존 쿼리로 되돌립니다.

## 토글 예시

```java
boolean useV2 = Boolean.TRUE.equals(session.getAttribute("USE_V2"))
		|| v2UserIds.contains(loginUser.getUserId());
```

테스트 사용자 계정명은 저장소에 넣지 않고 외부 설정으로 관리합니다.
