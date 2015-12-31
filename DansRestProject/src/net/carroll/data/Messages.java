package net.carroll.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Messages {
	
	@XmlElement(name = "message")
	private List<Message> messages;

	public String toString() {
		if (null!= messages) {
			StringBuffer sb = new StringBuffer();
			sb.append("Messages list size: " + messages.size());
			 for(Message msg : this.getMessages())
			    {
			        System.out.println(msg.getId());
			        System.out.println(msg.getText());
			    }
			return sb.toString();
		} else {
			return "Messages list size is null";
		}
	}
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}
