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
import cn.greate.chatroom.entity.ChatInfo;
import cn.greate.chatroom.repository.ChatInfoRepository;

@Service(value = "chatinfoService")
@Transactional
public class ChatinfoService {
	
	@Autowired
	private ChatInfoRepository chatinfoDao;
	
	
	 /**
     * 保存
     */
    public ChatInfo save(ChatInfo chatinfo) {

        return chatinfoDao.save(chatinfo);
    }

    /**
     * 批量添加
     */
    public List<ChatInfo> saveAll(List<ChatInfo> list) {
       
        return chatinfoDao.saveAll(list);
    }

    /**
     * 分页查询所有，带排序功能
     */
    public Page<ChatInfo> findAll(int page,int size) {
        //分页+排序查询演示：
        Sort sort =  Sort.by(Sort.Direction.DESC, "updateTime","createTime");
        Pageable pageable = PageRequest.of(page, size, sort);       
        return chatinfoDao.findAll(pageable);
    }

    /**
     * 更新
     */
    @Transactional
    public Boolean update(ChatInfo chatinfo) {
        Optional<ChatInfo> c = chatinfoDao.findById(chatinfo.getId());
        if (c.isPresent()) {
        	ChatInfo oldChatInfo =c.get();
        	oldChatInfo.setMsg(chatinfo.getMsg());
        	oldChatInfo.setSendFrom(chatinfo.getSendFrom());
        	oldChatInfo.setSendTo(chatinfo.getSendTo());
        	oldChatInfo.setType(chatinfo.getType());                
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除
     */
    
    public void delete(String id) {
    	chatinfoDao.deleteById(id);
    }
}
