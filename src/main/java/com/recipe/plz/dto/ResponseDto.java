package com.recipe.plz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
    private boolean result;
    private String err_msg;
    private String username;
    public ResponseDto(Boolean result, String err_msg, String username) {
        this.result = result;
        this.err_msg = err_msg;
        this.username = username;
    }
    public ResponseDto(Boolean result){

        this.result = result;
    }
    public ResponseDto(String username, Boolean result){
        this.result = result;
        this.username = username;
    }
    public ResponseDto(String username){

        this.username = username;
    }
}
