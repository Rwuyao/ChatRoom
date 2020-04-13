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
import cn.greate.chatroom.entity.authority.Resource;
import cn.greate.chatroom.repository.ResourceRepository;

@Service(value = "resourceService")
@Transactional
public class ResourceService {

	@Autowired
	private ResourceRepository resourceDao;
	
	
	 /**
     * 保存
     */
    public Resource save(Resource resource) {

        return resourceDao.save(resource);
    }

    /**
     * 批量添加
     */
    public List<Resource> saveAll(List<Resource> list) {
       
        return resourceDao.saveAll(list);
    }

    /**
     * 分页查询所有，带排序功能
     */
    public Page<Resource> findAll(int page,int size) {
        //分页+排序查询演示：
        Sort sort =  Sort.by(Sort.Direction.DESC, "updateTime","createTime");
        Pageable pageable = PageRequest.of(page, size, sort);       
        return resourceDao.findAll(pageable);
    }

    /**
     * 更新
     */
    @Transactional
    public Boolean update(Resource resource) {
        Optional<Resource> r = resourceDao.findById(resource.getId());
        if (r.isPresent()) {
        	Resource oldResource = r.get();
        	oldResource.setName(resource.getName());
        	oldResource.setUrl(resource.getUrl());        	                  
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除
     */
    
    public void delete(String id) {
    	resourceDao.deleteById(id);
    }
}
