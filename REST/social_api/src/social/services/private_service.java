package social.services;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import social.models.*;

@XmlRootElement(name = "privados")
public class private_service {
	private ArrayList<LinkPrivate> privates;

	public private_service() {
		this.privates = new ArrayList<LinkPrivate>();
	}

	@XmlElement(name="privado")
	public ArrayList<LinkPrivate> getPrivates() {
		return privates;
	}

	public void setPrivates (ArrayList<LinkPrivate> privates) {
		this.privates = privates;
	}
	

}
