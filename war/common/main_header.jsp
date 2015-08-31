<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
			<div id="header-wrapper">
				<div id="header">
					
					<!-- Logo -->
						<h1><a href="/<%=Constants.BASE_LANG %>/"><span style="font-size: 0.5em;margin-right:10px">株式会社</span><span style="display: none;">PluCial</span><img alt="PluCial" width="120px;" src="/images/h1-logo.png"></a></h1>
					
						<jsp:include page="/common/main_header_nav.jsp" />
				</div>
			</div>