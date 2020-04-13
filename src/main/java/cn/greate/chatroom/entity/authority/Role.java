package cn.greate.chatroom.entity.authority;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import cn.greate.chatroom.entity.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
public class Role extends BaseData{
	 
	@Column(nullable = false)
	private String roleName;
	
	@ManyToMany(cascade= {},fetch=FetchType.LAZY)
    @JoinTable(name = "user_resource",
    	joinColumns = @JoinColumn(name = "role_id"),
    	inverseJoinColumns = @JoinColumn(name = "resource_id"))
	private List<Resource> resources;
}
