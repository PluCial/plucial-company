<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%@ page import="java.util.List" %>
<%
String mainMenuSelect = (String) request.getAttribute("mainMenuSelect");
List<ArticleCategoryModel> categoryList = (List<ArticleCategoryModel>)request.getAttribute("categoryList");
%>
					
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li class="<%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_HOME) ? "current" : "" %>" style="white-space: nowrap;"><a href="/<%=Constants.BASE_LANG %>/"><span class="icon fa-home" style="padding-right:5px;"></span>Home</a></li>
								<li class="<%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_ABOUT) ? "current" : "" %>" style="white-space: nowrap;"><a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_ABOUT %>"><span class="icon fa-hospital-o" style="padding-right:5px;"></span>会社概要</a></li>
								<li class="<%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_DEVELOPMENT) ? "current" : "" %>" style="white-space: nowrap;"><a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_DEVELOPMENT %>"><span class="icon fa-desktop" style="padding-right:5px;"></span>システム開発</a></li>
								<li class="opener <%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_BLOG) ? "current" : "" %>" style="-webkit-user-select: none; cursor: pointer; white-space: nowrap; opacity: 1;">
									<a href=""><span class="icon fa-rss" style="padding-right:5px;"></span>技術ブログ</a>
									
									<ul class="" style="-webkit-user-select: none; display: none; position: absolute;">
										<%for(ArticleCategoryModel categoryModel: categoryList) { %>
											<li style="white-space: nowrap;"><a href="/<%=Constants.BASE_LANG %>/ac-<%=categoryModel.getKey().getId() %>" style="display: block;"><%=categoryModel.getName() %></a></li>
										<%} %>
									</ul>
								</li>
								<li class="<%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_CONTACT) ? "current" : "" %>" style="white-space: nowrap;"><a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_CONTACT %>"><span class="icon fa-envelope" style="padding-right:5px;"></span>お問い合わせ</a></li>
							</ul>
						</nav>