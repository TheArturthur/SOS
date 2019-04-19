package social.models;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.annotation.XmlAttribute;

public class LinkUser {
	private URL url;
	private String rel;
	private String nombre;
	
	@XmlAttribute(name="href")
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	
	@XmlAttribute
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	@XmlAttribute
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LinkUser(String url, String rel, String nombre) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		this.rel = rel;
		this.nombre = nombre;
	}
	
	public LinkUser() {

	}
}