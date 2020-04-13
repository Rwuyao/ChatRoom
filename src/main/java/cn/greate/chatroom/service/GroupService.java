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
import cn.greate.chatroom.entity.authority.Group;
import cn.greate.chatroom.repository.GroupRepository;

@Service(value = "groupService")
@Transactional
public class GroupService {
	
	@Autowired
	private GroupRepository groupDao;
	
	
	 /**
     * 保存
     */
    public Group save(Group group) {

        return groupDao.save(group);
    }

    /**
     * 批量添加
     */
    public List<Group> saveAll(List<Group> list) {
       
        return groupDao.saveAll(list);
    }

    /**
     * 分页查询所有，带排序功能
     */
    public Page<Group> findAll(int page,int size) {
        //分页+排序查询演示：
        Sort sort =  Sort.by(Sort.Direction.DESC, "updateTime","createTime");
        Pageable pageable = PageRequest.of(page, size, sort);       
        return groupDao.findAll(pageable);
    }

    /**
     * 更新
     */
    @Transactional
    public Boolean update(Group group) {
        Optional<Group> g = groupDao.findById(group.getId());
        if (g.isPresent()) {
        	Group oldGroup = g.get();
        	oldGroup.setGroupname(group.getGroupname());
        	oldGroup.setDescription(group.getDescription());                  
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除
     */
    
    public void delete(String id) {
    	groupDao.deleteById(id);
    }
}
