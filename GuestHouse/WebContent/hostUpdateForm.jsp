<%@page import="district.DTO.DistrictDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestHouse</title>
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/cosmo/bootstrap.css">
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
</head>
<body>
<a href="home.login">Home</a>

<%
	DistrictDTO dto = (DistrictDTO)request.getAttribute("dto");
%>
<form action="hostUpdate.district">	
	<table class="table table-striped table-hover">
		<tr>
			<th>제목</th>
			<td><%=dto.getHostingTitle() %></td>
		</tr>
		<tr>
			<th>호스트 이름</th>
			<td><%=dto.getHostName() %></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><%=dto.getHostPhone() %></td>
		</tr>
		<tr>
			<th>숙소 주소</th>
			<td><%=dto.getHouseAddress() %></td>
			<td><input type="hidden" name="houseAddress" value="<%=dto.getHouseAddress() %>"></td>
		</tr>
		<tr>
			<th></th>
			<td><%=dto.getVillageName() %></td>
		</tr>
		<tr>
			<th>계좌번호</th>
			<td><%=dto.getBankAccount() %></td>
		</tr>
		<tr>
			<th>숙소 소개</th>
			<td><%=dto.getIntroduction() %></td>
		</tr>
		<tr>
			<th>승인 여부</th>
			<td><input type="text" name="approve" value=<%=dto.getApprove() %>></td>
		</tr>
	</table>
	<div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>	
</form>
</body>
</html>