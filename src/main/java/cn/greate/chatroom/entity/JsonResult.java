package cn.greate.chatroom.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class  JsonResult  {
	
	public int code;
	public String msg;
	public Object data;
	public static JsonResult  success(String msg) {
        return JsonResult.builder()
                .code(200)
                .msg(msg)
                .build();
    }
	
	public static JsonResult success(Object data) {
        return JsonResult.builder()
                .code(200)
                .msg("OK")
                .data(data)
                .build();
    }
	
	public static JsonResult  fail(int code,String msg) {
        return JsonResult.builder()
                .code(code)
                .msg(msg)
                .build();
    }
}
