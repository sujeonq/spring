<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User1::list</title>
</head>
<body>
	<h3>User1 목록</h3>
	<a href="/ch05/">처음으로</a>
	<a href="/ch05/user1/register">등록</a>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>휴대폰</th>
			<th>나이</th>
			<th>관리</th>
		</tr>
		<%--
			- Spring JSP에서는 EL문법이 기본적으로 비활성 되는거 같음
			- Spring JSP에서 EL문법을 처리하기 위해 상단 page 지시자에 isELIgnored="false" 추가
		--%>
		<tr>
			<td>aaa</td>
			<td>aaa</td>
			<td>aaa</td>
			<td>aaa</td>
			<td>aaa</td>
			<td>
				<a href="/ch05/user1/modify?uid=">수정</a>
				<a href="/ch05/user1/delete?uid=">삭제</a>
			</td>
		</tr>
	</table>
</body>
</html>





