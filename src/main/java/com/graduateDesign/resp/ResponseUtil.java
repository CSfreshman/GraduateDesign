package com.graduateDesign.resp;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务器响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
public class ResponseUtil<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private Integer status;

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> ResponseUtil<T> success(T object) {
        ResponseUtil<T> r = new ResponseUtil<T>();
        r.data = object;
        r.code = 200;
        r.status = 1;
        return r;
    }

    public static <T> ResponseUtil<T> error(String msg) {
        ResponseUtil r = new ResponseUtil();
        r.msg = msg;
        r.code = 0;
        r.status = 0;
        return r;
    }

    public ResponseUtil<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
