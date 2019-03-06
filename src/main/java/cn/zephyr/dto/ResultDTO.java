package cn.zephyr.dto;

import lombok.Data;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/6 14:59
 * @Description: 统一返回的结果集
 */
@Data
public class ResultDTO<T> {
    private T data;
    private Integer status;
    private String msg;

    public ResultDTO(T data, Integer status, String msg) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }

    public static <T> ResultDTO<T> build(T data, Integer status, String msg){
        return new ResultDTO<>(data, status, msg);
    }

    public static <T> ResultDTO<T> unAuth(){
        return ResultDTO.build(null,403,"未登录或登录状态失效");
    }
    public static <T> ResultDTO<T> querySucc(T data){
        return ResultDTO.build(data,200,"查询成功");
    }
    public static <T> ResultDTO<T> operateSucc(){
        return ResultDTO.build(null,200,"操作成功");
    }
    public static <T> ResultDTO<T> operateSucc(T t){
        return ResultDTO.build(t,200,"操作成功");
    }
    public static <T> ResultDTO<T> operateFail(){
        return ResultDTO.build(null,500,"操作失败");
    }
    public static <T> ResultDTO<T> operateFail(String msg){
        return ResultDTO.build(null,500,msg);
    }
}
