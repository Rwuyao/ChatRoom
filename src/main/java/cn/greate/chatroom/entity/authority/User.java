package cn.greate.chatroom.entity.authority;


import java.util.List;
import javax.persistence.*;
import cn.greate.chatroom.entity.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
public class User  extends BaseData{

  
	  @Column(nullable = false)
	  private String username;
	  
	  @Column(nullable = false)
	  private String password;
	  
	  private String nickname;
	  
	  private Integer  sex;
	  
	  private Integer status = 1; //-1：删除；0 禁用 1启用
	  
	  private Boolean isOnline;
	  
	  @ManyToMany(cascade = {}, fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "user_role", // 定义中间表的名称
	            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, // 定义中间表中关联User表的外键名
	            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")} // 定义中间表中关联role表的外键名
	    )
	  private List<Role> roles; // 角色外键
	  
	  
	  @ManyToMany(cascade = {}, fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "user_group", // 定义中间表的名称
	            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, // 定义中间表中关联User表的外键名
	            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")} // 定义中间表中关联role表的外键名
	    )
	  private List<Group> groups; // 角色外键
}
