<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/common/html_head.jsp" />
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<jsp:include page="/common/main_header.jsp" />
		
		<!-- Main -->
			<div id="main-wrapper">
			
				<jsp:include page="/common/change_lang_form.jsp" />
				
				<div class="container">
					<div class="row">
						<div class="4u">
						
							<jsp:include page="/common/sidebar_company.jsp" />
							
							<jsp:include page="/common/sidebar_plucial.jsp" />
							
							<jsp:include page="/common/sidebar_clafu.jsp" />

						</div>
						
						<div class="8u important(collapse)">
							
							<!-- Content -->
								<article class="box post">
									<a href="#" class="image featured"><img src="/images/development.jpg" alt="" /></a>
									<header>
										<h2>システム受託開発</h2>
										<p>株式会社PluCialは自社サービスで得たノウハウを生かし、高品質のシステムの提案と受託開発を行っております。お気軽にお問い合わせください。</p>
									</header>
									
									<section>
										<header>
											<h4>新しい技術を使ってシステム提案や構築を行っております。</h4>
											<p>ここに載っていない技術を使った開発や環境構築に関してもお気軽にお問い合わせください。</p>
										</header>
									</section>
									
									<hr />
									
									<div class="row">
										<div class="3u" style="text-align: center;">
											<img alt="Takahara Kou" src="/images/g-platform-icon.png" style="width:100%;max-width:240px;border-radius: 50%;vertical-align: middle;">
										</div>
										<div class="9u">
											<h4>Google Platform</h4>
											<section>
												<p>Google Platform上でのシステム構築。Google App EngineやGoogle APIを使ったシステムを構築致します。
												</p>
												<p><a href="#" class="image"><img src="/images/g-platform.png" alt="" /></a></p>
											</section>
										</div>
									</div>
									
									<hr />
									
									<div class="row">
										<div class="3u" style="text-align: center;">
											<img alt="Takahara Kou" src="/images/javafx-icon.png" style="width:100%;max-width:240px;vertical-align: middle;">
										</div>
										<div class="9u">
											<h4>JavaFX</h4>
											<section>
												<p>JavaFXを使った操作性の高い業務アプリを構築致します。MacでもWindowsでも動きます。
												</p>
												<p><a href="#" class="image"><img src="/images/javafx.png" alt="" /></a></p>
											</section>
										</div>
									</div>
									
									<hr />
									
									<div class="row">
										<div class="3u" style="text-align: center;">
											<img alt="Takahara Kou" src="/images/smartphone-icon.jpg" style="width:100%;max-width:240px;vertical-align: middle;">
										</div>
										<div class="9u">
											<h4>Androidアプリ & iPhoneアプリ</h4>
											<section>
												<p>Androidアプリ & iPhoneアプリ の受託開発も行っております。
												</p>
												<p><a href="#" class="image"><img src="/images/smartphone.jpeg" alt="" /></a></p>
											</section>
										</div>
									</div>
									
									<hr />
									<footer>
										<ul class="actions" style="text-align: center;">
											<li><a href="/info/<%=Constants.MAIN_MENU_SELECT_CONTACT %>" class="button icon fa-external-link">システム開発のお問い合わせはこちら</a></li>
										</ul>
									</footer>
									
								</article>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/common/main_footer.jsp" />
			
		<!-- Analytics JavaScript -->
			<jsp:include page="/common/analytics_script.jsp" />

	</body>
</html>
