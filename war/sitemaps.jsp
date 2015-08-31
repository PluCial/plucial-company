<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.TimeZone" %>
<%@page import="com.plucial.company.Constants" %>
<%@ page import="com.plucial.company.model.*" %>
<%@ page import="com.plucial.company.utils.*" %>
<%@ page import="com.plucial.company.service.*" %>
<?xml version="1.0" encoding="UTF-8"?>
<%
List<ArticleCategoryModel> caetgoryList = (List<ArticleCategoryModel>) request.getAttribute("caetgoryList");
%>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
	<url>
		<loc>http://inc.plucial.com/</loc>
		<changefreq>daily</changefreq>
		<priority>1.0</priority>
	</url>
	<url>
		<loc>http://inc.plucial.com/ja/info/<%=Constants.MAIN_MENU_SELECT_ABOUT %></loc>
		<changefreq>monthly</changefreq>
		<priority>1.0</priority>
	</url>
	<url>
		<loc>http://inc.plucial.com/ja/info/<%=Constants.MAIN_MENU_SELECT_DEVELOPMENT %></loc>
		<changefreq>monthly</changefreq>
		<priority>1.0</priority>
	</url>
	<url>
		<loc>http://inc.plucial.com/ja/info/<%=Constants.MAIN_MENU_SELECT_CONTACT %></loc>
		<changefreq>monthly</changefreq>
		<priority>1.0</priority>
	</url>
	<%for(ArticleCategoryModel categoryModel: caetgoryList) { %>
	<url>
		<loc>http://inc.plucial.com/ja/ac-<%=categoryModel.getKey().getId() %></loc>
		<changefreq>daily</changefreq>
		<priority>0.5</priority>
	</url>
		<%
		List<ArticleModel> articleList = ArticleService.getArticleListByCategory(categoryModel);
		if(articleList != null) {
			for(ArticleModel articleModel: articleList) {
		%>
		<url>
			<loc>http://inc.plucial.com/ja/article/<%=articleModel.getKey().getId() %></loc>
			<changefreq>daily</changefreq>
			<priority>0.5</priority>
		</url>
		<%	} %>
		<%} %>
	<%} %>
</urlset>
