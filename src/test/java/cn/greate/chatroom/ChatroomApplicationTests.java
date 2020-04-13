package cn.greate.chatroom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatroomApplicationTests {

	@Test
	void contextLoads() {
		try {
			int i=1/0;
		}
		catch(Exception e1) 
		{
			System.out.println(e1.getMessage());
		}
		
	}

	public static void main(String[] args) {
		try {
			int i=1/0;
		}
		catch(ArithmeticException e1) 
		{
			System.out.println(e1.getMessage());
		}
	}
	
}
