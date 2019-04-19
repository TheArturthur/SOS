package social.services;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import social.models.LinkUser;
import social.models.*;

@XmlRootElement(name = "mensajes")
public class message_service {
	private ArrayList<LinkMessage> messages;

	public message_service() {
		this.messages = new ArrayList<LinkMessage>();
	}

	@XmlElement(name="mensaje")
	public ArrayList<LinkMessage> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<LinkMessage> messages) {
		this.messages = messages;
	}
	

}
