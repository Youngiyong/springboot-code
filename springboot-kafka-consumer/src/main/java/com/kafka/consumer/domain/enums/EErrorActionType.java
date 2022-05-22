package com.kafka.consumer.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EErrorActionType {
    POPUP,
    RETRY,
    NONE
}
