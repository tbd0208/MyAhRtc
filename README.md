# MyAhRtc

대화에서 확인된 소매전산 업무를 재구성한 **Java 8 / Spring 4 / MyBatis / JSP / Oracle** 기반 초기 프로젝트입니다.

> 학습·설계 참고용 코드입니다. 회사 접속정보, 계정, 고객정보, 운영 URL 등 기밀정보는 포함하지 않습니다.

## 포함 범위

- `CmMap` 기반 공통 요청·결과 처리
- 차량, 매입, 재고, 계약, 상품화비용, 손익 도메인 문서
- 부서·사용자 데이터 조회 범위와 차량 필드 노출 정책
- 매입채널 마스킹(`AR_RTC_BUYCH_BLND`) 적용 위치 예시
- 차량별 상품화비용 조회와 손익 계산 코드
- 경매 연계 조회와 페이징 후 부가정보 조인 참고 SQL
- `RTC_CAL_TOTAL_COST`, `RTC_CAL_COST_ATTR`, `RTC_DPT.J_OPT` 참고 스크립트
- 기존/V2 매퍼의 점진적 전환 지침

## 프로젝트 구조

```
src/main/java
├── common        CmMap과 공통 계층
├── auth          데이터 범위·필드 마스킹
├── dao           MyBatis 매퍼 인터페이스
├── domain        확인된 업무 상태와 요청 유형
├── service       비용 조회와 손익 계산
└── web           Spring MVC Controller

src/main/resources
├── mybatis       MyBatis 설정과 업무 매퍼
├── spring        Spring MVC·DB 설정
└── sql/reference 운영 반영 전 검증할 Oracle 참고 SQL

docs
├── architecture.md
├── domain.md
├── query-guidelines.md
└── v2-rollout.md
```

## 실행 전 준비

1. JDK 8과 Maven을 준비합니다.
2. `jdbc.properties.example`을 복사해 외부 환경의 `jdbc.properties`를 구성합니다.
3. Oracle JDBC 드라이버가 사내 Maven 저장소에 없다면 회사 표준 방식으로 의존성을 추가합니다.
4. 실제 스키마와 비교하여 `mapper` 및 `sql/reference`의 컬럼을 검증합니다.
5. `mvn test`, `mvn clean package` 순서로 확인합니다.

현재 저장소는 운영 시스템 전체를 추측해 복제한 것이 아닙니다. 대화에서 이름과 역할이 확인된 부분만 코드화했고, 불확실한 부분은 문서 또는 참고 SQL로 분리했습니다.
