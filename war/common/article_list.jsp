<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.TimeZone" %>
<%@page import="com.plucial.company.Constants" %>
<%@ page import="com.plucial.company.model.*" %>
<%@ page import="com.plucial.company.utils.*" %>
<%
List<ArticleModel> articletList = (List<ArticleModel>) request.getAttribute("articletList");
%>
										<%for(ArticleModel articleModel: articletList) { %>
										<div class="4u">
											<section class="box" style="position: relative;">
												<a href="#" class="image featured">
													<img src="http://storage.googleapis.com/plucial-inc.appspot.com/eye-catch/<%=articleModel.getKey().getId() %>" style="overflow: hidden;max-height: 200px;" />
												</a>
												<%
												ArticleCategoryModel categoryModel = articleModel.getArticleCategoryModel();
												if(categoryModel != null) {
												%>
												<div style="position: absolute;top: 5px;left: 0px;padding: 2px 10px;background-color: #e9575f;font-size: 12px;">
													<a class="icon fa-folder-open" href="/<%=Constants.BASE_LANG %>/ac-<%=categoryModel.getKey().getId() %>" style="color:#fff"><%=categoryModel.getName() %></a>
												</div>
												<%} %>
												<header>
													<p style="font-size: 0.8em;color: #555;"><span class="icon fa-calendar" style="padding-right:5px"></span><%=DateUtils.dateToString(articleModel.getCreateDate(), "yyyy.MM.dd") %></p>
													<h3><a href="/<%=Constants.BASE_LANG %>/article/<%=articleModel.getKey().getId() %>"><%=articleModel.getTitle() %></a></h3>
												</header>
											</section>
										</div>
										<%} %>