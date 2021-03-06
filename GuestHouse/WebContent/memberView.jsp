<%@page import="district.DTO.DistrictDTO"%>
<%@page import="java.util.List"%>
<%@page import="login.DTO.LoginDTO"%>
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
<%
	LoginDTO dto = (LoginDTO)request.getAttribute("dto");
	List<DistrictDTO> hostList = (List<DistrictDTO>)request.getAttribute("hostList");
%>
<table class="table table-striped table-hover ">
	<tr>
		<th>id</th>
		<td><%=dto.getId()%></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=dto.getMemberName()%></td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td><%=dto.getBirthDate()%></td>
	</tr>
	<tr>
		<th>성별</th>
		<td><%=dto.getGender()%></td>
	</tr>
	<tr>
		<th>연락처</th>
		<td><%=dto.getPhoneNumber()%></td>
	</tr>
	<tr>
		<th>E-mail</th>
		<td><%=dto.getEmail()%></td>
	</tr>
	<tr>
		<th>주소</th>
		<td><%=dto.getAddr()%></td>
	</tr>
	<tr>
		<th>가입일</th>
		<td><%=dto.getRegisterDate()%></td>
	</tr>
	<tr>
		<th>권한</th>
		<td><%=dto.getCompetence()%></td>
	</tr>
	<tr>
		<th>승인여부</th>
		<td><%=dto.getApprove()%></td>
	</tr>
</table>
<%
	if(dto.getCompetence().equals("호스트")){
		if(dto.getApprove().equals("승인")){
			if(hostList == null){
%>
				<a href="addHostForm.district">호스트 등록하기</a>
<%			
			}else{
%>
				<table>
<%
				for(int i=0; i<hostList.size(); i++){
					DistrictDTO hostDto = hostList.get(i);
%>
					<tr>
						<th>호스팅 제목</th>
						<td><a href="hostView.district?houseAddress=<%=hostDto.getHouseAddress() %>"><%=hostDto.getHostingTitle() %></a> </td>
					</tr>
<%
				}
%>
				</table>
<%
			}
		}
	}
%>
<a href="memberUpdateForm.login?id=<%=dto.getId()%>">회원정보수정</a><br>
</body>
</html>