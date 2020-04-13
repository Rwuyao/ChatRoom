package cn.greate.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.greate.chatroom.entity.authority.Resource;


public interface ResourceRepository extends JpaRepository<Resource, String>{

}
