package social.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int id;
	private String nombre;
	private int edad;
	private String nombre_usuario;
	private String aficiones;
	private Date fecha_creacion;
	
	public User() {
	}
	
	
	public User (int id, String nombre, int edad, String nombre_usuario, String aficiones, Date d) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.nombre_usuario = nombre_usuario;
		this.aficiones = aficiones;
		this.fecha_creacion = d;
	}
	
	@XmlAttribute(required=false)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public String getAficiones() {
		return aficiones;
	}
	
	
	public void setAficiones(String aficiones) {
		this.aficiones = aficiones;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	
	

}
