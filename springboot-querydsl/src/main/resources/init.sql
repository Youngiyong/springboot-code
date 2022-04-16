CREATE TABLE `user` (
                                 `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                 `uuid` VARCHAR(36) NOT NULL UNIQUE COMMENT 'UUID',
                                 `tel` VARCHAR(20) NOT NULL COMMENT '휴대폰 번호',
                                 `name` VARCHAR(50) NOT NULL COMMENT '이름',
                                 `thumbnail` VARCHAR(256) COMMENT 'host 제외한 썸네일 URL',
                                 `grade_flag` CHAR(1) NOT NULL DEFAULT 'B' COMMENT '회원 등급 (B: 브론즈, S:실버, G:골드)',
                                 `is_alert_push` TINYINT(1) DEFAULT 1 COMMENT '푸시 알림 여부',
                                 `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일자',
                                 `update_date` TIMESTAMP NULL COMMENT '업데이트 일자' DEFAULT NULL,
                                 `delete_date` TIMESTAMP NULL COMMENT '탈퇴 일자',
                                 PRIMARY KEY (`id`))
    COMMENT = '사용자 테이블'
    ENGINE = InnoDb DEFAULT CHARSET=utf8;