<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestHouse</title>
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/cosmo/bootstrap.css">
<style>
body{
	background-image:url('슬라이드1_1750x900.jpg');
}
</style>
</head>
<body>
<%
	String loginId = (String)session.getAttribute("id");
%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home.login">Home</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form class="navbar-form navbar-left" role="search" action="hostList.district">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="어디로 가시나요?" name="villageName">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
       
      <ul class="nav navbar-nav navbar-right">
      <%
      	if(loginId == null){
      %>
        <li><a href="loginForm.login">로그인</a></li>
        <li><a href="registerForm.login">회원가입</a></li>
      <%
		}else if(loginId.equals("admin")){
	%>
		<li class="dropdown open">
          <a href="index.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="true">관리자 메뉴 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="memberList.login">계정목록</a></li>
            <li class="divider"></li>
            <li><a href="hostList.district?villageName=all">호스팅 목록</a></li>
            <li class="divider"></li>
            <li><a href="noApproveHostList.district">미승인 호스팅 목록</a></li>
          </ul>
        </li>

		<li><a href="memberView.login?id=<%=loginId%>">회원정보</a></li>
		<li><a href="logout.login">로그아웃</a></li>
	<%
		}else{
	  %>
	  	<li><a href="memberView.login?id=<%=loginId%>">회원정보</a></li>
		<li><a href="logout.login">로그아웃</a></li>
	<%
		}
	%>
      </ul>
    </div>
  </div>
</nav>
<div style="margin:auto; text-align:center; width:300; height:100; position: relative; top: 200px">
	<h1><strong><font color="#FFFFFF">여행, 어디까지 가봤니?</font></strong></h1>
	<h5><strong><font color="#FFFFFF">지금 바로 게스트하우스를 예약하고</font></strong></h5>
	<h5><strong><font color="#FFFFFF">다른 여행자들과 즐거운 추억을 만들어 보세요</font></strong></h5>
</div>
</body>
</html>