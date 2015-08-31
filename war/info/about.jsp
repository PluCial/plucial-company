<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.company.Constants" %>
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
									<a href="#" class="image featured"><img src="/images/about3.jpg" alt="" /></a>
									<header>
										<h2>会社概要</h2>
										<p>様々なサービスを構築・運用しているベンチャー企業です。これからもお金を得られるサービスではなく皆様にとってよりメリットのあるサービスを中心に提供していきます。<br /><br />ご支援を賜りますようにお願い致します。</p>
									</header>
									
									<table>
										<tbody>
											<tr>
												<td>会社名</td>
												<td>株式会社PluCial</td>
											</tr>
											<tr>
												<td>設立</td>
												<td>2015年1月9日</td>
											</tr>
											<tr>
												<td>所在地</td>
												<td>福岡県福岡市博多区博多駅東1-12-17 オフェスニューガイア博多駅前3F</td>
											</tr>
											<tr>
												<td>資本金</td>
												<td>3,000,000円</td>
											</tr>
											<!-- <tr>
												<td>事業内容</td>
												<td>
													<ul></ul>
												</td>
											</tr> -->
											<tr>
												<td>お問い合わせ</td>
												<td><a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_CONTACT %>" >お問い合わせフォーム</a></td>
											</tr>
										</tbody>
									</table>
									
									<div class="row" style="margin-top: 2em;">
									
									<div class="3u">
										<img alt="Takahara Kou" src="/images/takahara2.png" style="width:100%;vertical-align: middle;">
											
									</div>
									<div class="9u">
										<h4>代表取締役&nbsp;&nbsp;&nbsp;高原 功(タカハラ コウ)</h4>
									<section>
										<p>
											10年以上システムエンジニアとして働きながら、自分が必要と思われるサービスを一人で構築・運用し、2015年に「株式会社PluCial」を設立しました。<br />Google+を中心に活動しています。お気軽に声をかけてください。
										</p>
										
										<ul class="social">
											<li><a class="icon fa-google-plus" target="_blank" href="https://plus.google.com/+takaharakou"><span class="label">Google+</span></a></li>
											<li><a class="icon fa-facebook" target="_blank" href="https://www.facebook.com/profile.php?id=100007135908776"><span class="label">Facebook</span></a></li>
											<li><a class="icon fa-twitter" target="_blank" href="https://twitter.com/SE_PAPIKO"><span class="label">Twitter</span></a></li>
										</ul>
										
										<h4>エンジニアとして得意としていること：</h4>
										<p>Google App Engine、PCアプリ(JavaFx)、Androidアプリ、インフラ構築(Linux)、WEBデザイン、ソーシャルログインや様々なWEB API・・・・</p>
									</section>
									</div>
									</div>
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
