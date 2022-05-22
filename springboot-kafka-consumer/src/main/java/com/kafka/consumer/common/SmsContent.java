package com.kafka.consumer.common;

public class SmsContent {
    public static final String TEST_INVITE_TYPE = "LMS";

    public static final String TEST_INSTALL_TYPE = "LMS";
    public static final String TEST_INSTALL_SUBJECT = "TEST 앱";
    public static final String TEST_INSTALL_CONTENT = "" +
            "[TEST 앱]\r\n" +
            "아래 링크를 눌러 TEST 앱을 다운 받으시고 회원가입 후 서비스를 이용해보세요.\r\n" +
            "[Android]\r\n" +
            "https://cms.test.com/upload/test.apk\r\n" +
            "[IOS]\r\n" +
            "https://cms.test.com/upload/test.apk";
}
