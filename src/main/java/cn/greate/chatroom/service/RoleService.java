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
import cn.greate.chatroom.entity.authority.Role;
import cn.greate.chatroom.repository.RoleRepository;

@Service(value = "roleService")
@Transactional
public class RoleService {

	
	@Autowired
	private RoleRepository roleDao;
	
	
	 /**
     * 保存
     */
    public Role save(Role role) {

        return roleDao.save(role);
    }

    /**
     * 批量添加
     */
    public List<Role> saveAll(List<Role> list) {
       
        return roleDao.saveAll(list);
    }

    /**
     * 分页查询所有，带排序功能
     */
    public Page<Role> findAll(int page,int size) {
        //分页+排序查询演示：
        Sort sort =  Sort.by(Sort.Direction.DESC, "updateTime","createTime");
        Pageable pageable = PageRequest.of(page, size, sort);       
        return roleDao.findAll(pageable);
    }

    /**
     * 更新
     */
    @Transactional
    public Boolean update(Role role) {
        Optional<Role> r = roleDao.findById(role.getId());
        if (r.isPresent()) {
        	Role oldRole = r.get();
        	oldRole.setRoleName(role.getRoleName());                   
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除
     */
    
    public void delete(String id) {
    	roleDao.deleteById(id);
    }
}
