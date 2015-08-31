<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%
String pageTitle = (String) request.getAttribute("pageTitle");
String pageDescription = (String) request.getAttribute("pageDescription");
String baseURI = (String) request.getAttribute("baseURI");
String lang = (String) request.getAttribute("lang");
%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><%=pageTitle %> | 株式会社PluCial</title>
	<link rel="icon" type="image/png" href="/favicon.png" >

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="<%=pageDescription == null ? "" : pageDescription %>" />
	<meta name="keywords" content="" />
	<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
	<script src="/js/jquery.min.js"></script>
	<script src="/js/jquery.dropotron.min.js"></script>
	<script src="/js/skel.min.js"></script>
	<script src="/js/skel-layers.min.js"></script>
	<script src="/js/init.js"></script>
	<noscript>
		<link rel="stylesheet" href="/css/skel.css" />
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="/css/style-desktop.css" />
	</noscript>
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->

	<!-- SP -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum=1, minimal-ui">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!-- /SP -->

	<!-- OGP -->
	<meta property="og:title" content="PluCial - <%=pageTitle %>" />
	<meta property="og:type" content="article" />
	<meta property="og:site_name" content="Clafu">
	<meta property="og:email" content="info@clafu.com">
	<%if(pageDescription != null) { %>
	<meta property="og:description" content="<%=pageDescription == null ? "" : pageDescription %>">
	<%} %>
	<!-- /OGP -->
	
	<!-- alternate -->
	<%if(baseURI != null) { %>
		<%for(LangModel model: Constants.LANG_LIST) {%>
		<link rel="alternate" hreflang="<%=model.getKey() %>" href="http://inc.plucial.com/<%=model.getKey() %><%=baseURI %>" />
		<%} %>
	<%} %>
	
	<!-- /alternate -->