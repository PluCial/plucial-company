<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%@ page import="java.util.List" %>
<%
List<TranslateTargetModel> targetList = (List<TranslateTargetModel>)request.getAttribute("targetList");
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
								
								<article class="box post">
									<header>
										<h2>すべての翻訳ページをリセット</h2>
									</header>
									<p>デザイン・カテゴリ・固定ページを更新した時に、翻訳ページをリセットします。リセットするとすべてのページが再翻訳されます。ページ数によっては翻訳コストが変わります。</p>
									<footer>
											<ul class="actions" style="text-align: center;">
												<li>
													<a href="/admin/translateResetAll" class="button" >リセット</a>
												</li>
											</ul>
										</footer>
									
								</article>
								
								<article class="box post">
									<header>
										<h2>個別の翻訳ページをリセット</h2>
										<p>対象のURLを探してリセットを行ってください。</p>
									</header>
									
									<hr />
									
									<%for(TranslateTargetModel targetModel: targetList) { %>
										<form action="/admin/translateResetEntry" method="post" class="row">
											<div class="10u">
												<p><%=targetModel.getKey().getName() %></p>
											</div>
											<div class="2u">
												<input type="submit" class="button" value="リセット" />
											</div>
											<input type="hidden" name="url" value="<%=targetModel.getKey().getName() %>">
										</form>
										<hr />
									<%} %>
								</article>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/common/main_footer.jsp" />

	</body>
</html>
