<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${commentMap[post.postId] != null}">
	<c:forEach var="comment" items="${commentMap[post.postId]}">
		<div class="display border">
		<h2 class="left">${comment.commentWriter}</h2>
		<div class="writer right">
			<p>No.${comment.commentId}&nbsp;${comment.commentDatetime}</p>
		</div>
		<div class="contents">
			${comment.commentContent}
		</div>
			<%-- 작성자가 로그인한 사람과 같으면 아이콘 출력 --%>
			<c:if test="${sessionScope.user.userNickname eq comment.commentWriter}">
				<div class="innerFooter">
					<a href="<spring:url value="/comment/delete.mo">
								<spring:param name="commentId" value="${comment.commentId}"/>
								<spring:param name="postId" value="${post.postId}"/>
								<spring:param name="commentWriter" value="${comment.commentWriter}"/>
								<spring:param name="postCategory" value="${post.postCategory}"/>
							</spring:url>">
						<img class="btn" src="<spring:url value="/icon/comment_delete.png"/>" alt="삭제" title="코멘트 삭제" />
					</a>
				</div>
			</c:if>
		</div>
	</c:forEach>
</c:if>
<%-- 로그인 했다면 --%>
<c:if test="${sessionScope.user.login eq 'true'}">
	<div id="commentForm${post.postId}" style="display:none">
		<form:form action="/mOerog-with-spring/comment/add.mo" commandName="comment" id="${post.postId}thCommentForm">
			<form:textarea path="commentContent" title="글 남겨주세요"/>
			<div class="innerFooter comment">
				<img class="btn" src="<spring:url value="/icon/script_save.png"/>" alt="코멘트 등록" title="코멘트 등록" onclick="addComment(${post.postId});"/>
			</div>
			<input type="hidden" name="postId" value="${post.postId}"/>
			<input type="hidden" name="commentWriter" value="${sessionScope.user.userNickname}"/>
			<input type="hidden" name="postCategory" value="${post.postCategory}"/>
		</form:form>
	</div>
</c:if>