package cn.greate.chatroom.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "chatinfo")
public class ChatInfo extends BaseData{

	private String sendFrom ;
	private String sendTo;
	private String msg;
	private Integer type;
}
