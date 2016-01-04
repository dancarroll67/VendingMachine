package net.carroll.data;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private Long id;
	private String text;
	private Date createDate;
	
	public String toString() {
		return "Message: " + id + "::" + text;
	}	
	
	public Message(){
		super();
	}
	
	public Message(Long id, String message, Date createDate) {
		super();
		this.id = id;
		this.text = message;
		this.createDate = createDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
}
