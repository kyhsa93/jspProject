<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestHouse</title>
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/cosmo/bootstrap.css">
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

<form class="form-horizontal" action="register.login">
  <fieldset>
    <legend>회원가입</legend>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">ID</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" style = "width:200px" size = "10" name="id" placeholder="ID">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword" class="col-lg-2 control-label">Password</label>
      <div class="col-lg-10">
        <input type="password" class="form-control" style = "width:200px" name="pwd" placeholder="Password">
      </div>
    </div>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">이름</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" style = "width:200px" name="name" placeholder="name">
      </div>
    </div>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">연락처</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" style = "width:200px" name="phone" placeholder="Phone">
      </div>
    </div>  
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" style = "width:200px" name="e-mail" placeholder="e-mail">
      </div>
    </div>      
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">생년월일</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" style = "width:200px" name="birthDate" placeholder="YYYY.MM.DD">
      </div>
    </div>    
	<div class="form-group">
      <label class="col-lg-2 control-label">성별</label>
      <div class="col-lg-10">
        <div class="radio">
          <label>
            <input type="radio" name="gender" value="남자">
            	남자
          </label>
          <label>
            <input type="radio" name="gender" value="여자">
           		여자
          </label>
        </div>
      </div>
    </div>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">주소</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" style = "width:400px"placeholder="Address" name="address">
      </div>
    </div>  
	<div class="form-group">
	  <label class="col-lg-2 control-label"></label>
      <div class="col-lg-10">
        <div class="radio">
          <label>
            <input type="radio" value="호스트" name="competence">
            	호스트
          </label>
          <label>
            <input type="radio" value="게스트" name="competence">
           		게스트
          </label>
        </div>
      </div>
    </div>      
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button type="reset" class="btn btn-default">Cancel</button>
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </fieldset>
</form>
</body>
</html>