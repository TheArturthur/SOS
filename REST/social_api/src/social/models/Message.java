package social.models;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private int id;
	private int id_usuario;
	private String contenido;
	private Date fecha_envio;
	
	public Message() {
	}
	
	public Message(int id, int id_usuario, String contenido, Date fecha_envio) {
		this.id = id;
		this.id_usuario = id_usuario;
		this.contenido = contenido;
		this.fecha_envio = fecha_envio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	
	}


