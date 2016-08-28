<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout">

<head>
<title>Znajdzpsy</title>
</head>

<body>
	<div align="center">
		<h1>Wyszukiwarka psów <span id="the-title" layout:fragment="pageTitle" /></h1>
		<form action="FindByCity" method="post">
			Wpisz nazwę miejscowości: <input type="text" name="city" value="" /><br />
			<br /> <input type="submit" value="Szukaj" />
		</form>
	</div>
</body>
</html>