<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%
String baseURI = (String) request.getAttribute("baseURI");
String lang = (String) request.getAttribute("lang");
%>		
	<div class="lang-box">
<!-- 	<span>他の言語：</span> -->
	<form id="change-lang-form" method="post" action="/changeLang">
		<select name="lang" id="lang">
		<option value="">- 他の言語 -</option>
		<%
			for(LangModel model: Constants.LANG_LIST) {
		%>
			<option value="<%=model.getKey() %>" <%=lang != null && lang.equals(model.getKey()) ? "selected" : "" %>><%=model.getValue() %></option>
		<%} %>
		</select>
		<input type="hidden" name="baseURI" value="<%=baseURI %>" />
	</form>
	</div>