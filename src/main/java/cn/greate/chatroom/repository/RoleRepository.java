 package cn.greate.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.greate.chatroom.entity.authority.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
