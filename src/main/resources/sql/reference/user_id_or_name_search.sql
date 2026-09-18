/*
 * ID가 정확히 일치할 때 이름 검색 서브쿼리가 필요하지 않도록 분기하는 참고 SQL.
 * OR 확장으로 실행계획이 불안정하면 MyBatis choose로 SQL 자체를 분리합니다.
 */
AND	(
			CER.V_REG_USERID = :REG_USER
		OR	(
				CER.V_REG_USERID <> :REG_USER
				AND CER.V_REG_USERID IN (
					SELECT	ADM.V_USERID
					FROM	CM_ADMIN_INFO ADM
					WHERE	ADM.V_USERNM = :REG_USER
				)
			)
		);
