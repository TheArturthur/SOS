package social.services;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import social.models.LinkUser;

@XmlRootElement(name = "usuarios")
public class user_service {
	private ArrayList<LinkUser> users;

	public user_service() {
		this.users = new ArrayList<LinkUser>();
	}

	@XmlElement(name="usuario")
	public ArrayList<LinkUser> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<LinkUser> users) {
		this.users = users;
	}
}