<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"   action="${contextPath}/scrap/printExpertScrap.do">
	<h1  class="text_center">(임시)scrapExpert</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">NO</td>
	      <td width="400"><input type="text" name="no"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">COMPID</td>
	      <td width="400"><input type="text" name="compid"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">EXPID</td>
	       <td width="400"><p><input type="text" name="expid"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="등록"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
</html>