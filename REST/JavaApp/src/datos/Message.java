package datos;

import java.util.Date;

public class Message {
	private int id;
	private String content;
	private int idUser;
	private Date date;
	
	public Message(int id, String content, int idUser, Date date) {
		this.id = id;
		this.content = content;
		this.idUser = idUser;
		this.date = date;
	}
	
	//Getters:
	public int getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public Date getDate() {
		return date;
	}
}
