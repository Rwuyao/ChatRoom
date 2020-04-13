package cn.greate.chatroom.entity.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import cn.greate.chatroom.entity.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "chatgroup")
public class Group  extends BaseData{

	
	  @Column(nullable = false)
	  private String groupname;
	  
	  private String description;
	 
}
