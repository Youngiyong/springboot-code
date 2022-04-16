package com.service.contents.dto;

import lombok.Getter;

public class RequestDto {

    @Getter
    public static class RequestPost{
        private String name;
        private String icon;
        private String description;
    }

    @Getter
    public static class RequestPostComment{
        private String description;
    }
}
