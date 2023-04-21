package com.management.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Xiaoyang Yu
 * @create_at: 2023/4/19 6:57
 * @version: 1.0
 */
@Data  //生成get，set方法
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(){
        return new Result<>(20000, "success", null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>(20000, "success", data);
    }
    public static <T> Result<T> success(T data, String message){
        return new Result<>(20000, message, data);
    }
    public static <T> Result<T> success(String message){
        return new Result<>(20000, message, null);
    }
    //失败
    public static <T> Result<T> fail(){
        return new Result<>(20001, "fail", null);
    }
    public static <T> Result<T> fail(Integer code){
        return new Result<>(code, "fail", null);
    }
    public static <T> Result<T> fail(Integer code, String message){
        return new Result<>(code, message, null);
    }
    public static <T> Result<T> fail(String message){
        return new Result<>(20001, message, null);
    }
}
