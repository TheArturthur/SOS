package social.client;

import social.resources.UserResource;
import social.models.*;

public class SocialClient {
	
	UserResource ur = new UserResource();
	
	/**
	 * add new User
	 */
	public void addUser() {
		System.out.println("Introduzca su nombre:");
		String userName = (String) System.in.read(name);
		//ur.createUser(user);
	}
	
	/**
	 * see user basic data
	 */
	
	/**
	 * change basic data (except userName)
	 */
	
	/**
	 * search users
	 */
	
	/**
	 * public message in user's page
	 */
	
	/**
	 * delete own message
	 */
	
	/**
	 * edit message
	 */
	
	/**
	 * get message list. Can be filtered by text or number of messages to show
	 */
	
	/**
	 * add new friend
	 */
	
	/**
	 * delete friend
	 */
	
	/**
	 * get friend list. Can be filtered by friend name
	 */
	
	/**
	 * send private message
	 */
	
	/**
	 * delete social profile
	 */
	
	/**
	 * get list of last messages in our page, ordered by date. Can be filtered by text.
	 */
	
	/**
	 * get app info: user data, last message, # of friends & 10 last messages on friends pages
	 */
	
	
	public static void main (String[] args) {
		System.out.println("hola");
		addUser();
		System.out.println("adios");
	}
}