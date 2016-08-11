<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestHouse</title>
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/cosmo/bootstrap.css">
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.cycle2.js"></script> -->
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
		<li class="dropdown">
          <a href="indexOpen.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">관리자 메뉴<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
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
	<!-- <div class="cycle-slideshow" cycle-slideshow data-cycle-loader="wait" data-cycle-timeout=3000 style="margin:0; padding:0;">
		<img src="슬라이드1_1024x651.jpg" style="width: 100%; height: auto; margin:0; padding:0;">
		<img src="슬라이드2.jpg" style="width: 100%; height: auto; margin:0; padding:0;">
		<img src="슬라이드3.jpg" style="width: 100%; height: auto; margin:0; padding:0;">
	</div> -->
</body>
</html>