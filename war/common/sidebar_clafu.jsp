<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="java.util.Date" %>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%@ page import="java.util.List" %>
<%
List<ArticleCategoryModel> categoryList = (List<ArticleCategoryModel>)request.getAttribute("categoryList");
%>
								<section class="box">
									<a href="#" class="image featured"><img src="/images/clafu.png" alt=""></a>
									<header>
										<h3><a href="http://www.clafu.com/" target="_blank">Clafu</a></h3>
										<p><a href="http://www.clafu.com/" target="_blank">不特定多数の人のSNSアカウントの配信権を集めるためのクラウドファンディング</a></p>
									</header>
								</section>