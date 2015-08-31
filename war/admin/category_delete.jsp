<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%@ page import="java.util.List" %>
<%
ArticleCategoryModel categoryModel = (ArticleCategoryModel)request.getAttribute("categoryModel");
%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/common/html_head.jsp" />
		<style type="text/css"><!--
			form span.err {
				color: red;
			}
		//--></style>
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<jsp:include page="/common/main_header.jsp" />
		
		<!-- Main -->
			<div id="main-wrapper">
				<div class="container">
					<div class="row">
						<div class="4u">
						
							<!-- Sidebar -->
								<jsp:include page="/common/sidebar_admin.jsp" />

						</div>
						
						<div class="8u important(collapse)">
							
							<!-- Content -->
								<article class="box post">
									<header>
										<h2>カテゴリ「<%=categoryModel.getName() %>」を削除して本当によろしいですか？</h2>
										<p>このカテゴリを削除すると、カテゴリ内の記事が「その他」に移動されます。</p>
									</header>
									
									<footer>
										<ul class="actions" style="text-align: center;">
											<li>	
												<a class="button" href="/admin/categoryDeleteEntry?id=<%=categoryModel.getKey().getId() %>" >削除</a>
											</li>
										</ul>
									</footer>
									
								</article>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/common/main_footer.jsp" />

	</body>
</html>
