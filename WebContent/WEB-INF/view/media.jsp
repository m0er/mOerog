<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>anOther World: for Hardcore Gamers</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/style/base.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/style/style.css"/>"/>
<script type="text/javascript" src="<c:url value="/js/header.js"/>"></script>
</head>
<body id="media">
<jsp:include page="include/header.jsp"/>
<div id="banner1">
	<a href="http://www.gametrailers.com" title="GameTrailers"><img width="760" height="100" src="<spring:url value="/image/gt_banner.jpg"/>" alt="GT Banner" /></a>
</div>
<div id="content">
	<%-- Tab 부분  --%>
	<c:choose>
		<c:when test="${totalCount eq 0 or postList eq null}">
			<div class="empty">
				<p>등록된 포스트가 없습니다.</p>
			</div>
		</c:when>
		<c:otherwise>
			<c:forEach var="post" items="${postList}">
			<div class="display border">
				<h2 class="left">${post.postTitle}</h2>
				<div class="writer right">
					<p>${post.postDatetime}</p>
					<p>No.${post.postId} &nbsp; ${post.adminNickname}</p>
				</div>
				<div class="contents">
					${post.postContent}
				</div>
				<%-- 커멘트 부분 --%>
				<%@ include file="include/comment.jsp" %>
				<%-- 아이콘 부분 --%>
				<%@ include file="include/icon_post.jsp" %>
			</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<jsp:include page="include/sidebar.jsp"/>
<!--[if IE]>
<style type="text/css" media="screen">
#content #wrap_tab {position: relative; top: 10px; left: -30px; margin-top: -20px;}
#league_esl #content .display .left, #league_clanbase #content .display .left {margin-top: 9px;}
#sidebar ul li {float: left; width: 100%;}
#sidebar ul li a {height: 1%;}
#menu a, #menu h2 {font: bold 0.7em/1.4em arial, helvetica, sans-serif;}
</style>
<![endif]-->
</body>
</html>