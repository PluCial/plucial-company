<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="java.util.Date" %>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%@ page import="java.util.List" %>
<%
List<ArticleCategoryModel> categoryList = (List<ArticleCategoryModel>)request.getAttribute("categoryList");
%>
								<section class="box">
									<a href="#" class="image featured"><img src="/images/plucial.png" alt=""></a>
									<header>
										<h3><a href="http://plucial.com/" target="_blank">PluCial</a></h3>
										<p><a href="http://plucial.com/" target="_blank">Google+の投稿を他のSNSに自動転送しすべて一元管理する</a></p>
									</header>
								</section>