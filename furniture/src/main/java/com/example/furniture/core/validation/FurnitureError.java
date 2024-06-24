package com.example.furniture.core.validation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FurnitureError {
    public enum FurnitureErrorCode {
        UNKNOW ,
        DATA_INVALID , ACCOUNT_EXIST
    }    
    private FurnitureErrorCode code;
    private String message;

    public FurnitureError(FurnitureErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
