<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="innerFooter">
	<c:choose>
		<c:when test="${sessionScope.user.admin eq 'true'}">
			<a href="<spring:url value="/post/modifyForm.mo">
						<spring:param name="postId" value="${post.postId}"/>
						<spring:param name="postCategory" value="${post.postCategory}"/>
						<spring:param name="adminNickname" value="${post.adminNickname}"/>
					</spring:url>">
				<img class="btn" src="<spring:url value="/icon/script_edit.png"/>" alt="포스트 수정" title="수정하기" />
			</a>
			<a href="<spring:url value="/post/delete.mo">
						<spring:param name="postId" value="${post.postId}"/>
						<spring:param name="postCategory" value="${post.postCategory}"/>
						<spring:param name="adminNickname" value="${post.adminNickname}"/>
					</spring:url>">
				<img class="btn" src="<spring:url value="/icon/script_delete.png"/>" alt="포스트 삭제" title="삭제하기"/>
			</a>
			<img class="btn" src="<spring:url value="/icon/comment_add.png"/>" alt="코멘트 폼" title="코멘트 폼" onclick="showCommentForm(true, ${post.postId})" />
		</c:when>
		<c:when test="${sessionScope.user.login eq 'true'}">
			<img class="btn" src="<spring:url value="/icon/comment_add.png"/>" alt="코멘트 폼" title="코멘트 폼" onclick="showCommentForm(true, ${post.postId})" />
		</c:when>
	</c:choose>
</div>