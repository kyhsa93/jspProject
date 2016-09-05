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

<form action="addHost.district" class="form-horizontal" method="post"enctype="multipart/form-data">	
	<fieldset>
	    <legend>호스팅 정보 입력</legend>
	    <div class="form-group">
      		<label class="col-lg-2 control-label">호스팅 제목</label>
      		<div class="col-lg-10">
        		<input type="text" class="form-control" style = "width:400px" name="hostingTitle" placeholder="hosting title">
      		</div>
    	</div>
	    <div class="form-group">
      		<label class="col-lg-2 control-label">호스트 이름</label>
      		<div class="col-lg-10">
        		<input type="text" class="form-control" style = "width:400px" name="hostName" placeholder="host name">
      		</div>
    	</div>
	    <div class="form-group">
      		<label class="col-lg-2 control-label">호스트 연락처</label>
      		<div class="col-lg-10">
        		<input type="text" class="form-control" style = "width:400px" name="hostPhone" placeholder="예약 등 문의 가능한 연락처">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="col-lg-2 control-label">숙소 주소</label>
      		<div class="col-lg-10">
        		<input type="text" class="form-control" style = "width:400px" name="villageName" placeholder="~동 입력 (예:등촌3동)">
        		<input type="text" class="form-control" style = "width:400px" name="houseAddress" placeholder="전체 주소입력">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="col-lg-2 control-label">은행 및 계좌번호</label>
      		<div class="col-lg-10">
        		<input type="text" class="form-control" style = "width:400px" name="bankAccount" placeholder="예 : 국민(000000-00-000000)">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="col-lg-2 control-label">숙소 소개</label>
      		<div class="col-lg-10">
        		<textarea class="form-control" id="textArea" style="height:400px;width:400px;" name="introduction">특별한 행사를 진행한다거나 식사제공 여부, 시설, 규칙 등 숙소에 대한 상세한 설명과 소개를 작성해 주세요</textarea>
        		<span class="help-block">허위 정보를 기재할 시 게시물이 승인되지 않을 수 있습니다.</span>
	      	</div>
	    </div>
	    <div class="form-group">
	    	<label class="col-lg-2 control-label">숙소사진</label>
	    	<div class="col-lg-10">
	    		<input type="file" name="file">
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