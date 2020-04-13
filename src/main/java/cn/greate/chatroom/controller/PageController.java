package cn.greate.chatroom.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

	/**
	 *  进入首页
	 * @param session
	 * @return
	 */
	@RequestMapping("/")
	public String welcome() {
		return "index.html";
	}
	
	@RequestMapping("/chatroom")
	public String chatroom() {
		return "chatroom.html";
	}
	
}
