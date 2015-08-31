package com.plucial.company.controller;

import org.slim3.controller.router.RouterImpl;

/**
 * 公開部分ルーティング
 * addRoutingメソッドの順番変更は禁止！
 * @author takahara
 *
 */
public class AppRouter extends RouterImpl {

	public AppRouter() {
	    
	    // TOP
        addRouting(
                "/",
                "/index?baseURI=/");
        
	    // TOP
        addRouting(
                "/{lang}/",
                "/?lang={lang}&baseURI=/");

        // カテゴリページ
        addRouting(
                "/ac-{categoryId}",
                "/articleCategory?categoryId={categoryId}&baseURI=/ac-{categoryId}");
        
	    // カテゴリページ(他言語)
        addRouting(
                "/{lang}/ac-{categoryId}",
                "/articleCategory?categoryId={categoryId}&lang={lang}&baseURI=/ac-{categoryId}");
        
        // 記事詳細ページ
        addRouting(
                "/article/{articleId}",
                "/article?id={articleId}&baseURI=/article/{articleId}");
        
        // 記事詳細ページ(他言語)
        addRouting(
                "/{lang}/article/{articleId}",
                "/article?id={articleId}&lang={lang}&baseURI=/article/{articleId}");
        
        // INFO ABOUT
        addRouting(
                "/info/about",
                "/info/about?baseURI=/info/about");
        
        // INFO ABOUT
        addRouting(
                "/{lang}/info/about",
                "/info/about?lang={lang}&baseURI=/info/about");
        
        // INFO CONTACT
        addRouting(
                "/info/contact",
                "/info/contact?baseURI=/info/contact");
        
        // INFO CONTACT
        addRouting(
                "/{lang}/info/contact",
                "/info/contact?lang={lang}&baseURI=/info/contact");
        
        // INFO CONTACT END
        addRouting(
                "/info/contactEnd",
                "/info/contactEnd?baseURI=/info/contactEnd");
        
        // INFO CONTACT END
        addRouting(
                "/{lang}/info/contactEnd",
                "/info/contactEnd?lang={lang}&baseURI=/info/contactEnd");
        
        // INFO CEVELOPMENT
        addRouting(
                "/info/development",
                "/info/development?baseURI=/info/development");
        
        // INFO CEVELOPMENT
        addRouting(
                "/{lang}/info/development",
                "/info/development?lang={lang}&baseURI=/info/development");
	}

}
