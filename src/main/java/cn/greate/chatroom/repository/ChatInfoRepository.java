package cn.greate.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.greate.chatroom.entity.ChatInfo;

public interface ChatInfoRepository extends JpaRepository<ChatInfo, String>{

}
