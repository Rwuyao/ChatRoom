package cn.greate.chatroom.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.greate.chatroom.config.MyHandler;
import cn.greate.chatroom.entity.JsonResult;
import cn.greate.chatroom.entity.authority.User;
import cn.greate.chatroom.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ChatController {
	
	@Autowired
	private MyHandler myHandler;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/login")
	public JsonResult login(HttpSession session,User user) {
		User user1=userservice.findByUserName(user);
		if(user1==null) {
			return JsonResult.fail(201, "用户不存在");	
		}
		if(!user1.getPassword().equals(user.getPassword())) {
			return JsonResult.fail(201, "密码错误");		
		}		
		session.setAttribute("WEBSOCKET_USERNAME",user1.getUsername());
		return JsonResult.success("ok");
	}
	
	@RequestMapping("/register")
	public JsonResult register(User user) {
		
		if(userservice.isExist(user)) {
			return JsonResult.fail(201, "用户已存在");		
		}	
		userservice.save(user);
		return JsonResult.success("ok");
	}
	
	
	@RequestMapping("/send")
	public JsonResult send(HttpSession session,String tousername,String msg,int type) {
		
		   log.info("处理要发送的消息");
	       
	        JSONObject obj = new JSONObject();
	        String userName = (String) session.getAttribute("WEBSOCKET_USERNAME");
	        obj.put("username",userName);
	        if (type == 1) {
	            //给所有人
	            obj.put("msg", msg);
	            myHandler.sendMessageToUsers(new TextMessage(obj.toJSONString()));
	        } else {
	            //给个人
	            String to =tousername;
	            obj.put("msg", msg);
	            myHandler.sendMessageToUser(to, new TextMessage(obj.toJSONString()));
	        }
				
		return JsonResult.success("ok");
	}
}
