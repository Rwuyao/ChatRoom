package cn.greate.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.greate.chatroom.entity.authority.Group;

public interface GroupRepository extends JpaRepository<Group, String>{

}
