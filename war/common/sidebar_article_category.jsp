<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="java.util.Date" %>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%@ page import="java.util.List" %>
<%
List<ArticleCategoryModel> categoryList = (List<ArticleCategoryModel>)request.getAttribute("categoryList");
%>
								<section class="box">
									<header>
										<h3>Blog Category</h3>
									</header>
									<ul class="divided">
										<%for(ArticleCategoryModel categoryModel: categoryList) { %>
											<li>
												<span class="icon fa-folder-open" style="padding-right:5px;"></span>
												<a href="/<%=Constants.BASE_LANG %>/ac-<%=categoryModel.getKey().getId() %>"><%=categoryModel.getName() %></a>
											</li>
										<%} %>
									</ul>
								</section>