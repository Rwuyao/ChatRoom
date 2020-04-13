package cn.greate.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.greate.chatroom.entity.authority.User;

public interface UserRepository extends JpaRepository<User, String>{

	boolean existsByUsername(String username);
	User findByUsername(String username);
}
