<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>printManuScrap</title>
</head>
<body>

<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>no</b></td>
      <td><b>compid</b></td>
      <td><b>manuid</b></td>
      <td></td>
   </tr>
   
 <c:forEach var="scrap" items="${manuScrapList}" >     
   <tr align="center">
      <td>${scrap.no}</td>
      <td>${scrap.compid}</td>
      <td>${scrap.manuid}</td>
      <td><a href="${contextPath}/scrap/deleteManuScrap.do?no=${scrap.no}">삭제</a>
    </tr>
  </c:forEach>   
</body>
</html>