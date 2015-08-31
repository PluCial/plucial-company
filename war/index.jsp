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
	<body class="homepage">

		<!-- Header -->
			<div id="header-wrapper">
				<div id="header">
					
					<!-- Logo -->
						<!-- <h1><a href="/"><span style="font-size: 0.5em;">株式会社</span> <span style="color:#dd4b39">P</span>lu<span style="color:#dd4b39">C</span>ial</a></h1> -->
						<h1><a href="/<%=Constants.BASE_LANG %>/"><span style="font-size: 0.5em;margin-right:10px">株式会社</span><span style="display: none;">PluCial</span><img alt="PluCial" width="120px;" src="/images/h1-logo.png"></a></h1>
					
					<!-- Nav -->
						<jsp:include page="/common/main_header_nav.jsp" />

					<!-- Banner -->
						<section id="banner">
							<header>
								<h2 style="margin: 0.65em 0 0.65em 0;">サービスで世界に挑む</h2>
								<p>このサイトは64ヵ国の言語に対応しています。</p>
								<jsp:include page="/common/change_lang_form.jsp" />
							</header>
						</section>

					<!-- Intro -->
						<section id="intro" class="container">
							<div class="row">
								<div class="4u">
									<section class="first">
										<i class="icon featured fa-heart-o"></i>
										<header>
											<h2>サービスの提供</h2>
										</header>
										<p>世の中に+αするような様々なサービスを構築・運営しています。</p>
									</section>
								</div>
								<div class="4u">
									<section class="middle">
										<i class="icon featured alt fa-desktop"></i>
										<header>
											<h2>システム受託開発</h2>
										</header>
										<p>最新技術を使ったシステムやアプリの受託開発を行っています。<br /><br />
											<span class="icon fa-external-link" style="padding-right:5px;"></span>
											<a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_DEVELOPMENT %>">詳しくはこちら</a>
										</p>
									</section>
								</div>
								<div class="4u">
									<section class="last">
										<i class="icon featured alt2 fa-rss"></i>
										<header>
											<h2>技術情報の配信</h2>
										</header>
										<p>開発に使用した技術情報やサンプルを随時配信しています。</p>
									</section>
								</div>
							</div>
						</section>
		
				</div>
			</div>

		<!-- Main -->
			<div id="main-wrapper">
				<div class="container">
					<div class="row">
						<div class="12u">

							<!-- サービス -->
								<section>
									<header class="major">
										<h2>運営中のサービス</h2>
									</header>
									<div class="row">
										<div class="6u">
											<section class="box">
												<a href="#" class="image featured"><img src="/images/plucial.png" alt="" /></a>
												<header>
													<h3>PluCial</h3>
													<p>Google+の投稿を他のSNSに自動転送しすべて一元管理する</p>
												</header>
												<p style="color: #777;font-size: 0.8em;">ご利用のGoogle+のアカウントを使って登録し、転送先のSNSを設定するだけですぐにご利用頂けます。また、ハッシュタグを使って転送先を投稿毎に自由に切り替えます。さらにすべての投稿がブログとして一元管理できます。</p>
												<footer>
													<ul class="actions" style="text-align: right;">
														<li><a href="http://plucial.com/" class="button icon fa-external-link" target="_blank">詳しくはこちら</a></li>
													</ul>
												</footer>
											</section>
										</div>
										<div class="6u">
											<section class="box">
												<a href="#" class="image featured"><img src="/images/clafu.png" alt="" /></a>
												<header>
													<h3>Clafu</h3>
													<p>これでもアクセスが増えなかったらもう諦めよう</p>
												</header>
												<p style="color: #777;font-size: 0.8em;">宣伝や告知のためのソーシャルフォロワーはもう集める必要がありません。これからはフォロワー集めの代わりにClafuで共感してくれる応援者を集めよう。あなたの告知や宣伝は応援者のSNSアカウントから配信されより多くの方に届きます。</p>
												<footer>
													<ul class="actions" style="text-align: right;">
														<li><a href="http://www.clafu.com/" class="button icon fa-external-link" target="_blank">詳しくはこちら</a></li>
													</ul>
												</footer>
											</section>
										</div>
									</div>
								</section>
							
						</div>
					</div>
				
					<div class="row">
						<div class="12u">
							
							<!-- Portfolio -->
								<section>
									<header class="major">
										<h2>新着記事</h2>
									</header>
									<div class="row">
									
										<jsp:include page="/common/article_list.jsp" />
										
									</div>
									
								</section>

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
