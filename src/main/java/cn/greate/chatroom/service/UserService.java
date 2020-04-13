package cn.greate.chatroom.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.greate.chatroom.entity.authority.User;
import cn.greate.chatroom.repository.UserRepository;

@Service(value = "userService")
@Transactional
public class UserService {

	@Autowired
	private UserRepository userDao;
	
	
	public User findByUserName(User user) {
	      return userDao.findByUsername(user.getUsername()); 
	}
	
	public boolean isExist(User user) {
		  return userDao.existsByUsername(user.getUsername());
	} 
	
	/**
     * 保存
     */
    public User save(User user) {

        return userDao.save(user);
    }

    /**
     * 批量添加
     */
    public List<User> saveAll(List<User> list) {
       
        return userDao.saveAll(list);
    }

    /**
     * 分页查询所有，带排序功能
     */
    public Page<User> findAll(int page,int size) {
        //分页+排序查询演示：
        Sort sort =  Sort.by(Sort.Direction.DESC, "updateTime","createTime");
        Pageable pageable = PageRequest.of(page, size, sort);       
        return userDao.findAll(pageable);
    }

    /**
     * 更新
     */
    @Transactional
    public Boolean update(User user) {
        Optional<User> u = userDao.findById(user.getId());
        if (u.isPresent()) {
            User oldUser = u.get();
            oldUser.setIsOnline(user.getIsOnline());
            oldUser.setNickname(user.getNickname());
            oldUser.setPassword(user.getPassword());
            oldUser.setSex(user.getSex());
            oldUser.setStatus(user.getStatus()); 
            oldUser.setUsername(user.getUsername());            
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除
     */
    
    public void delete(String id) {
        userDao.deleteById(id);
    }
}
