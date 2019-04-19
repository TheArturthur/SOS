package social.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Peticion_amistad {
	
	private String id_amigo;
	private String motivo;
	
	
	public Peticion_amistad() {
		
	}
	
	public Peticion_amistad(String id_amigo, String motivo) {
		this.id_amigo = id_amigo;
		this.motivo = motivo;
	}
	
	public String getId_amigo() {
		return id_amigo;
	}
	public void setId_amigo(String id_amigo) {
		this.id_amigo = id_amigo;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	

}
