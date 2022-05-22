package com.kafka.producer.domain.common;

public class SmsContent {

    public static final String TSID_INSTALL_TYPE = "LMS";
    public static final String TSID_INSTALL_SUBJECT = "TSID 앱";
    public static final String TSID_INSTALL_CONTENT = "" +
            "[TSID 앱]\r\n" +
            "아래 링크를 눌러 TSID 앱을 다운 받으시고 회원가입 후 서비스를 이용해보세요.\r\n" +
            "[Android]\r\n" +
            "https://cms.tsidcert.com/upload/aos_tsid.apk\r\n" +
            "[IOS]\r\n" +
            "https://cms.tsidcert.com/upload/ios_tsid.apk";

}
