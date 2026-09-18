<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>차량 상품화비용</title>
</head>
<body>
	<h1>차량 상품화비용</h1>
	<table>
		<thead>
			<tr>
				<th>비용유형</th>
				<th>세부유형</th>
				<th>금액</th>
				<th>부호적용금액</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${list}">
				<tr>
					<td><c:out value="${row.V_COST_TYPE_CD}"/></td>
					<td><c:out value="${row.V_COST_TYPE_SUB_CD}"/></td>
					<td><c:out value="${row.N_COST_PRICE}"/></td>
					<td><c:out value="${row.N_SIGNED_COST_PRICE}"/></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="3">합계</th>
				<td><c:out value="${totalCost}"/></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
