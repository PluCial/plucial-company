package com.plucial.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.plucial.company.model.LangModel;

public class Constants {
    
    // ---------------------------------------------------------------------------
    // システム基本情報
    // ---------------------------------------------------------------------------
    public static final String BASE_LANG = "ja";
    
    
    // ---------------------------------------------------------------------------
    // GOOGLE PROJECT 定数(サービス アカウント OAuth)
    // ---------------------------------------------------------------------------
    public static final String GOOGLE_APPLICATION_NAME = "PluCial.inc";
    /** クライアントID */
    public static final String GOOGLE_PROJECT_CLIENT_ID = "795638059099-i00r2t818m9rp58a42vb04fgrhc725lu.apps.googleusercontent.com";
    /** クライアントシークレット */
    public static final String GOOGLE_PROJECT_CLIENT_SECRET = "RtBtLisOx67DaTyAzN1FpGl1";
    /** Google プロジェクトスコープ */
    public static final String GOOGLE_DRIVE_API_SCOPE = "https://www.googleapis.com/auth/drive https://www.googleapis.com/auth/drive.file https://www.googleapis.com/auth/drive.readonly https://www.googleapis.com/auth/drive.metadata.readonly https://www.googleapis.com/auth/drive.appdata https://www.googleapis.com/auth/drive.apps.readonly https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";
    /** Google プロジェクトスコープ */
    public static final String GOOGLE_ADSENSE_API_SCOPE = "https://www.googleapis.com/auth/adsense.readonly";
    /** Google プロジェクトスコープ */
    public static final String GOOGLE_URLSHORTENER_API_SCOPE = "https://www.googleapis.com/auth/urlshortener";
    /** GOOGLE data-cookiepolicy */
    public static final String GOOGLE_DATA_COOKIEPOLICY = "single_host_origin";
    
    // ---------------------------------------------------------------------------
    // GOOGLE PROJECT 定数(ウェブ アプリケーションのクライアント ID アプリ固定)
    // ---------------------------------------------------------------------------
    public static final String GOOGLE_SERVICE_CLIENT_ID = "795638059099-i00r2t818m9rp58a42vb04fgrhc725lu.apps.googleusercontent.com";
    public static final String GOOGLE_SERVICE_CLIENT_MAIL = "795638059099-cm13iir25v94ksbvpu88j7u6b6kcn6fu@developer.gserviceaccount.com";
    
    // ---------------------------------------------------------------------------
    // GOOGLE PROJECT 定数(公開API)
    // ---------------------------------------------------------------------------
    public static final String PUBLIC_API_KEY = "AIzaSyBrVk6ho9rDWIcvbl6sCibhmUYv_MezFAk";
    
    // ---------------------------------------------------------------------------
    // システム更新キー
    // ---------------------------------------------------------------------------
    public static final String SYSTEM_TRANSLATE_UPDATE_DATE_PROPERTY_KEY = "system_translate_update_date";
    
    // ---------------------------------------------------------------------------
    // マイページナビー
    // ---------------------------------------------------------------------------
//    /** カテゴリリスト */
//    public static final List<CategoryModel> CATEGORY_LIST = new ArrayList<CategoryModel>(
//            Arrays.asList(
//                new CategoryModel("google", "Google Platform"),
//                new CategoryModel("javafx", "JavaFXによるGUIアプリ開発"),
//                new CategoryModel("swift", "SwiftによるiOSアプリ開発"),
//                new CategoryModel("android", "Androidアプリ開発"),
//                new CategoryModel("etc", "その他"),
//                new CategoryModel("blog", "社長のつぶやき")
//           ));
    
    /** 対応言語リスト */
    public static final List<LangModel> LANG_LIST = new ArrayList<LangModel>(
            Arrays.asList(
                new LangModel("アフリカーンス語", "af"),
                new LangModel("アルバニア語", "sq"),
                new LangModel("アラビア語", "ar"),
                new LangModel("アゼルバイジャン語", "az"),
                new LangModel("バスク", "eu"),
                new LangModel("ベンガル語", "bn"),
                new LangModel("ベラルーシ語", "be"),
                new LangModel("ブルガリア語", "bg"),
                new LangModel("カタロニア語", "ca"),
                new LangModel("中国の簡体字", "zh-CN"),
                new LangModel("中国語の繁体字", "zh-TW"),
                new LangModel("クロアチア語", "hr"),
                new LangModel("チェコ語", "cs"),
                new LangModel("デンマーク語", "da"),
                new LangModel("オランダ語", "nl"),
                new LangModel("英語", "en"),
                new LangModel("エスペラント", "eo"),
                new LangModel("エストニア語", "et"),
                new LangModel("フィリピン", "tl"),
                new LangModel("フィンランド語", "fi"),
                new LangModel("フランス語", "fr"),
                new LangModel("ガリシア語", "gl"),
                new LangModel("ジョージアン", "ka"),
                new LangModel("ドイツ語", "de"),
                new LangModel("ギリシャ語", "el"),
                new LangModel("グジャラート語", "gu"),
                new LangModel("ハイチ語", "ht"),
                new LangModel("ヘブライ語", "iw"),
                new LangModel("ヒンディー語", "hi"),
                new LangModel("ハンガリー語", "hu"),
                new LangModel("アイスランド語", "is"),
                new LangModel("インドネシア語", "id"),
                new LangModel("アイリッシュ", "ga"),
                new LangModel("イタリア語", "it"),
                new LangModel("日本語", "ja"),
                new LangModel("カンナダ語", "kn"),
                new LangModel("韓国語", "ko"),
                new LangModel("ラテン語", "la"),
                new LangModel("ラトビア語", "lv"),
                new LangModel("リトアニア語", "lt"),
                new LangModel("マケドニア語", "mk"),
                new LangModel("マレー語", "ms"),
                new LangModel("マルタ語", "mt"),
                new LangModel("ノルウェー語", "no"),
                new LangModel("ペルシア語", "fa"),
                new LangModel("ポーランド語", "pl"),
                new LangModel("ポルトガル語", "pt"),
                new LangModel("ルーマニア語", "ro"),
                new LangModel("ロシア語", "ru"),
                new LangModel("セルビア語", "sr"),
                new LangModel("スロバキア語", "sk"),
                new LangModel("スロベニア語", "sl"),
                new LangModel("スペイン語", "es"),
                new LangModel("スワヒリ語", "sw"),
                new LangModel("スウェーデン語", "sv"),
                new LangModel("タミル", "ta"),
                new LangModel("テルグ語", "te"),
                new LangModel("タイ語", "th"),
                new LangModel("トルコ語", "tr"),
                new LangModel("ウクライナ語", "uk"),
                new LangModel("ウルドゥー語", "ur"),
                new LangModel("ベトナム語", "vi"),
                new LangModel("ウェールズ語", "cy"),
                new LangModel("イディッシュ語", "yi")
           ));
    
//    /** 対応言語リスト */
//    public static final List<LangModel> LANG_LIST = new ArrayList<LangModel>(
//            Arrays.asList(
//                new LangModel("Afrikaans", "af"),
//                new LangModel("Albanian", "sq"),
//                new LangModel("Arabic", "ar"),
//                new LangModel("Azerbaijani", "az"),
//                new LangModel("Basque", "eu"),
//                new LangModel("Bengali", "bn"),
//                new LangModel("Belarusian", "be"),
//                new LangModel("Bulgarian", "bg"),
//                new LangModel("Catalan", "ca"),
//                new LangModel("Chinese Simplified", "zh-CN"),
//                new LangModel("Chinese Traditional", "zh-TW"),
//                new LangModel("Croatian", "hr"),
//                new LangModel("Czech", "cs"),
//                new LangModel("Danish", "da"),
//                new LangModel("Dutch", "nl"),
//                new LangModel("English", "en"),
//                new LangModel("Esperanto", "eo"),
//                new LangModel("Estonian", "et"),
//                new LangModel("Filipino", "tl"),
//                new LangModel("Finnish", "fi"),
//                new LangModel("French", "fr"),
//                new LangModel("Galician", "gl"),
//                new LangModel("Georgian", "ka"),
//                new LangModel("German", "de"),
//                new LangModel("Greek", "el"),
//                new LangModel("Gujarati", "gu"),
//                new LangModel("Haitian Creole", "ht"),
//                new LangModel("Hebrew", "iw"),
//                new LangModel("Hindi", "hi"),
//                new LangModel("Hungarian", "hu"),
//                new LangModel("Icelandic", "is"),
//                new LangModel("Indonesian", "id"),
//                new LangModel("Irish", "ga"),
//                new LangModel("Italian", "it"),
//                new LangModel("Japanese", "ja"),
//                new LangModel("Kannada", "kn"),
//                new LangModel("Korean", "ko"),
//                new LangModel("Latin", "la"),
//                new LangModel("Latvian", "lv"),
//                new LangModel("Lithuanian", "lt"),
//                new LangModel("Macedonian", "mk"),
//                new LangModel("Malay", "ms"),
//                new LangModel("Maltese", "mt"),
//                new LangModel("Norwegian", "no"),
//                new LangModel("Persian", "fa"),
//                new LangModel("Polish", "pl"),
//                new LangModel("Portuguese", "pt"),
//                new LangModel("Romanian", "ro"),
//                new LangModel("Russian", "ru"),
//                new LangModel("Serbian", "sr"),
//                new LangModel("Slovak", "sk"),
//                new LangModel("Slovenian", "sl"),
//                new LangModel("Spanish", "es"),
//                new LangModel("Swahili", "sw"),
//                new LangModel("Swedish", "sv"),
//                new LangModel("Tamil", "ta"),
//                new LangModel("Telugu", "te"),
//                new LangModel("Thai", "th"),
//                new LangModel("Turkish", "tr"),
//                new LangModel("Ukrainian", "uk"),
//                new LangModel("Urdu", "ur"),
//                new LangModel("Vietnamese", "vi"),
//                new LangModel("Welsh", "cy"),
//                new LangModel("Yiddish", "yi")
//           ));
    
    public static final String MAIN_MENU_SELECT_HOME = "home";
    public static final String MAIN_MENU_SELECT_ABOUT = "about";
    public static final String MAIN_MENU_SELECT_BLOG = "blog";
    public static final String MAIN_MENU_SELECT_DEVELOPMENT = "development";
    public static final String MAIN_MENU_SELECT_CONTACT = "contact";
    
}
