<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="java.util.Date" %>
<%@page import="com.plucial.company.Constants" %>
<%@page import="com.plucial.company.model.*" %>
<%@ page import="java.util.List" %>
<%
UserModel loginUserModel = null;
boolean isLogin = Boolean.valueOf((String) request.getAttribute("isLogin"));
if(isLogin) {
	loginUserModel = (UserModel) request.getAttribute("loginUserModel");
}
String dateValue = new java.text.SimpleDateFormat( "yyyy", java.util.Locale.US).format(new Date());
List<ArticleCategoryModel> categoryList = (List<ArticleCategoryModel>)request.getAttribute("categoryList");
%>
		<!-- Footer -->
			<div id="footer-wrapper">
				<section id="footer" class="container" style="font-size: 14px;">
					
					<div class="row">
						<div class="4u">
							<section>
								<header>
									<h2>SERVICE</h2>
								</header>
								<ul class="divided">
									<li><a href="http://plucial.com/">PluCial</a><br />Google+を起点とした新しいソーシャルライフの形をあなたに</li>
									<li><a href="http://www.clafu.com/">Clafu</a><br />不特定多数の人のSNSアカウントの配信権を集めるためのクラウドファンディング</li>
								</ul>
							</section>
						</div>
						<div class="4u">
							<section>
								<header>
									<h2>Blog Category</h2>
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
						</div>
						<div class="4u">
							<section>
								<header>
									<h2>ABOUT US</h2>
								</header>
								<ul class="divided">
									<li><span class="icon fa-hospital-o" style="padding-right:5px;"></span><a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_ABOUT %>">会社概要</a></li>
									<li><span class="icon fa-desktop" style="padding-right:5px;"></span><a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_DEVELOPMENT %>">システム開発</a></li>
									<li><span class="icon fa-envelope" style="padding-right:5px;"></span><a href="/<%=Constants.BASE_LANG %>/info/<%=Constants.MAIN_MENU_SELECT_CONTACT %>">お問い合わせ</a></li>
								</ul>
							</section>
							<section>
								<header>
									<h2>Social Media</h2>
									<p>提供している各サービスの最新情報を配信しています。</p>
								</header>
								<ul class="social">
									<li><a class="icon fa-google-plus" target="_blank" href="https://plus.google.com/b/111586968979366611293/+Plucial/posts"><span class="label">Google+</span></a></li>
									<li><a class="icon fa-facebook" target="_blank" href="https://www.facebook.com/plucial"><span class="label">Facebook</span></a></li>
									<li><a class="icon fa-twitter" target="_blank" href="https://twitter.com/PluCial"><span class="label">Twitter</span></a></li>
									<!-- <li><a class="icon fa-linkedin" href="#"><span class="label">LinkedIn</span></a></li> -->
								</ul>
								<%if(isLogin) { %>
								<div>
								<a href="/admin/addContent">管理画面</a>
								</div>
								<%} %>
							</section>
						</div>
					</div>
					<div class="row">
						<div class="12u">
						
							<!-- Copyright -->
								<div id="copyright">
									<ul class="links">
										<li>Copyright &copy; PluCial <%=dateValue %>. All Rights Reserved.</li>
									</ul>
								</div>
						</div>
					</div>
				</section>
			</div>