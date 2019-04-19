package social.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Private {
	
	private int id;
	private String contenido;
	private int destinatario;
	private Date fecha_envio;
	
	public Private () {
	}
	
	public Private(int id, String contenido, int destinatario, Date fecha_envio) {

		this.id = id;
		this.contenido = contenido;
		this.destinatario = destinatario;
		this.fecha_envio = fecha_envio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public int getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(int destinatario) {
		this.destinatario = destinatario;
	}
	public Date getFecha_envio() {
		return fecha_envio;
	}
	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

}
