<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="cdc" tagdir="/WEB-INF/tags"%>

<cdc:page title="Login">
	<form:form servletRelativeAction="/login">
		<div>
			<c:if test="${param.error != null }">
				<spring:message code="message.badCredential"></spring:message>
			</c:if>
		</div>
		<div>
			<label>Usuário</label> <input type="text" name="username" />
		</div>
		<div>
			<label>Senha</label> <input type="password" name="password" />
		</div>
		<div>
			<input type="submit" value="Entrar" />
		</div>
	</form:form>
</cdc:page>
