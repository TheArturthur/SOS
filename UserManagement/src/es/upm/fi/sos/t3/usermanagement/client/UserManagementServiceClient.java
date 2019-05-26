package es.upm.fi.sos.t3.usermanagement.client;

import es.upm.fi.sos.t3.usermanagement.client.UserManagementWSStub.*;

public class UserManagementServiceClient {

	public static void main (String[] args) throws Exception {
		UserManagementWSStub stub = new UserManagementWSStub();
				
		AddUserResponse user = stub.addUser(new AddUser());
		LoginResponse login = stub.login(new Login());
		
		if (user.is_returnSpecified() && login.is_returnSpecified()) {
			
		} else {
			throw new Exception("Wrong arguments.");
		}
	}
}
