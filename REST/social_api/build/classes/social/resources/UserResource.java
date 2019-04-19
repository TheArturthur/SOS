package social.resources;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import org.apache.naming.NamingContext;

import social.models.*;
import social.services.*;

@Path("/usuarios")
public class UserResource {
	@Context
	private UriInfo uriInfo;

	private DataSource ds;
	private Connection conn;

	public UserResource() {
		InitialContext ctx;

		try {
			ctx = new InitialContext();
			NamingContext envCtx = (NamingContext) ctx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/social_bbdd");
			conn = ds.getConnection();
			System.out.println("conexion establecida");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getUsers (@QueryParam("indicio_n") @DefaultValue("") String indicio_n) {
		try {
			String sql = "SELECT * FROM Usuarios order by id;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			user_service u = new user_service();
			ArrayList<LinkUser> users = u.getUsers();
			rs.beforeFirst();
			while (rs.next()) {
				if (rs.getString("nombre").startsWith(indicio_n)) {
					users.add(new LinkUser(uriInfo.getAbsolutePath() + "/" + rs.getInt("id"),"self", rs.getString("nombre")));
				}
			}
			return Response.status(Response.Status.OK).entity(u).build();
		} catch (NumberFormatException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudieron convertir los índices a números").build();
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}	
	}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getUser(@PathParam("id") String id) {
		try {
			int int_id = Integer.parseInt(id);
			String sql = "SELECT * FROM Usuarios where id=" + int_id + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User User =  UserFromRS(rs);
				return Response.status(Response.Status.OK).entity(User).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("Elemento no encontrado").build();
			}
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		} catch (SQLException e) {

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}

	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response createUser(User user) {


		try {
			java.util.Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			String sql = "INSERT INTO `social_bbdd`.`Usuarios` (`nombre`, `edad`,`nombre_usuario`, `aficiones`, `fecha_creacion`) " + "VALUES ('"
					+ user.getNombre() + "', '" + user.getEdad() + "', '" + user.getNombre_usuario() + "', '" + user.getAficiones() + "', '" + date + "');";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			int affectedRows = ps.executeUpdate();
			ResultSet generatedID = ps.getGeneratedKeys();

			if (generatedID.next()) {
				user.setId(generatedID.getInt(1));
				LinkUser l = new LinkUser(uriInfo.getAbsolutePath() + "/" + generatedID.getInt(1),"self", user.getNombre());

				return Response.status(Response.Status.CREATED).entity(l).build();
			}

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario").build();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario\n" + e.getStackTrace()).build();
		}
	}

	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response updateUser(User user, @PathParam("id") String id) {


		try {
			int int_id = Integer.parseInt(id);
			java.util.Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			String sql = "UPDATE `social_bbdd`.`Usuarios` SET `nombre` = " +"'"+ user.getNombre()+ "'" +
					", `edad` = "+ "'"+ user.getEdad()+ "'" + ", `nombre_usuario` = " + "'" + user.getNombre_usuario() + "'" + ", `aficiones` = " + "'" + user.getAficiones() + "'"
					+ ", `fecha_creacion` = " + "'" + date + "'" + "WHERE" + "`id` = " + "'" + int_id + "'" + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			int affectedRows = ps.executeUpdate();

			LinkUser l = new LinkUser(uriInfo.getAbsolutePath() + "/" +id,"self", user.getNombre());

			return Response.status(Response.Status.CREATED).entity(l).build();


			//		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario").build();
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		}	
		 catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario\n" + e.getStackTrace()).build();
		}
	}

	@DELETE
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteUser(@PathParam("id") String id) {

		User User;
		try {
			int int_id = Integer.parseInt(id);
			String sql = "SELECT * FROM Usuarios where id=" + int_id + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User =  UserFromRS(rs);				
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("Elemento no encontrado").build();
			}
			sql = "DELETE FROM `social_bbdd`.`Usuarios`" + " WHERE" + "`id` = " + "'" + int_id + "'" + ";";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			int affectedRows = ps2.executeUpdate();

			LinkUser l = new LinkUser(uriInfo.getAbsolutePath() + "/" +id,"self", User.getNombre());

			return Response.status(Response.Status.CREATED).entity(l).build();
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		}	
		//		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario").build();

		catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario\n" + e.getStackTrace()).build();
		}
	}
	
	@GET
	@Path("{id}/mensajes")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getMessages (@PathParam("id") String id) {
		try {
			int int_id = Integer.parseInt(id);
			String sql = "SELECT * FROM Mensajes where id_usuario =" + int_id + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			message_service m = new message_service();
			ArrayList<LinkMessage> messages = m.getMessages();
			rs.beforeFirst();
			while (rs.next()) {	
				messages.add(new LinkMessage(uriInfo.getAbsolutePath() + "/" + rs.getInt("id"),"self"));
				
			}
			return Response.status(Response.Status.OK).entity(m).build();
		} catch (NumberFormatException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudieron convertir los índices a números").build();
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}	
	}
//---------------------------------------------------------------------------------------------------------------------------------------------//
	
	@GET
	@Path("{id}/mensajes/{id_msg}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getMessage(@PathParam("id") String id, @PathParam("id_msg") String id_msg) {
		try {
			
			int int_id = Integer.parseInt(id);
			int int_id_msg = Integer.parseInt(id_msg);
			String sql = "SELECT * FROM Mensajes where id_usuario =" + int_id + " AND id = " + int_id_msg + ";";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.beforeFirst();
			
			if (rs.next()) {
				Message msg = MessageFromRS(rs);
				System.out.println("hola");
				return Response.status(Response.Status.OK).entity(msg).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("Elemento no encontrado").build();
			}
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}

	}

	@POST
	@Path("{id}/mensajes")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response createMessage(Message msg, @PathParam ("id") String id) {


		try {
			int int_id = Integer.parseInt(id);
			java.util.Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			String sql = "INSERT INTO `social_bbdd`.`Mensajes` (`id_usuario`, `contenido`, `fecha_envio`) " + "VALUES ('" + int_id + "', '" + msg.getContenido() + "', '" + date + "');";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			int affectedRows = ps.executeUpdate();
			ResultSet generatedID = ps.getGeneratedKeys();

			if (generatedID.next()) {
				msg.setId(generatedID.getInt(1));
				LinkMessage l = new LinkMessage(uriInfo.getAbsolutePath() + "/" + generatedID.getInt(1),"self");

				return Response.status(Response.Status.CREATED).entity(l).build();
			}

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario").build();
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario\n" + e.getStackTrace()).build();
		}
	}

	@PUT
	@Path("{id}/mensajes/{id_msg}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response updateMessage(Message msg, @PathParam("id") String id, @PathParam("id_msg") String id_msg) {


		try {
			int int_id = Integer.parseInt(id);
			int int_id_msg = Integer.parseInt(id_msg);
			java.util.Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			String sql = "UPDATE `social_bbdd`.`Mensajes` SET `contenido` = " +"'"+ msg.getContenido() + "'" +
					 ", `fecha_envio` = " + "'" + date + "'" + "WHERE" + "`id_usuario` = " + "'" + int_id + "'" + " AND 'id' = '" + int_id_msg + "' ;";
			PreparedStatement ps = conn.prepareStatement(sql);
			int affectedRows = ps.executeUpdate();

			LinkMessage l = new LinkMessage(uriInfo.getAbsolutePath().toString(),"self");

			return Response.status(Response.Status.CREATED).entity(l).build();


			//		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario").build();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario\n" + e.getStackTrace()).build();
		}
	}

	@DELETE
	@Path("{id}/mensajes/{id_msg}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteMessage(@PathParam("id") String id, @PathParam("id_msg") String id_msg) {
		User User;
		try {
			int int_id = Integer.parseInt(id);
			int int_id_msg = Integer.parseInt(id_msg);
			String sql = "SELECT * FROM Mensajes where id_usuario =" + int_id + "AND id = "+ int_id_msg + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User =  UserFromRS(rs);				
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("Elemento no encontrado").build();
			}
			sql = "DELETE FROM `social_bbdd`.`Usuarios`" + " WHERE" + "id_usuario = " + int_id + " AND id = "+ int_id_msg + ";";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			int affectedRows = ps2.executeUpdate();

			LinkMessage l = new LinkMessage(uriInfo.getAbsolutePath().toString(), "self");

			return Response.status(Response.Status.CREATED).entity(l).build();
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		}	
		//		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario").build();

		catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el usuario\n" + e.getStackTrace()).build();
		}
	}
//------------------------------------------------------------------------------------------------------------------------------------------//
	
	@GET
	@Path("{id}/privados")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPrivates (@PathParam("id") String id) {
		try {
			int int_id = Integer.parseInt(id);
			String sql = "SELECT * FROM Privados where destinatario =" + int_id + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			private_service m = new private_service();
			ArrayList<LinkPrivate> privates = m.getPrivates();
			rs.beforeFirst();
			while (rs.next()) {	
				privates.add(new LinkPrivate(uriInfo.getAbsolutePath() + "/" + rs.getInt("id"),"self"));
				
			}
			return Response.status(Response.Status.OK).entity(m).build();
		} catch (NumberFormatException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudieron convertir los índices a números").build();
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}	
	}
//---------------------------------------------------------------------------------------------------------------------------------------------//
	
	@GET
	@Path("{id}/privados/{id_msg}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPrivate(@PathParam("id") String id, @PathParam("id_msg") String id_msg) {
		try {
			
			int int_id = Integer.parseInt(id);
			int int_id_msg = Integer.parseInt(id_msg);
			String sql = "SELECT * FROM Privados where destinatario =" + int_id + " AND id = " + int_id_msg + ";";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.beforeFirst();
			
			if (rs.next()) {
				Private prv = PrivateFromRS(rs);
				System.out.println("hola");
				return Response.status(Response.Status.OK).entity(prv).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("Elemento no encontrado").build();
			}
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}

	}

	@POST
	@Path("{id}/privados")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response createPrivate(Private prv, @PathParam ("id") String id) {


		try {
			int int_id = Integer.parseInt(id);
			java.util.Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			String sql = "INSERT INTO `social_bbdd`.`Privados` (`contenido`, `destinatario`, `fecha_envio`) " + "VALUES ('" + prv.getContenido() + "', '" + int_id + "', '" + date + "');";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			int affectedRows = ps.executeUpdate();
			ResultSet generatedID = ps.getGeneratedKeys();

			if (generatedID.next()) {
				prv.setId(generatedID.getInt(1));
				LinkPrivate l = new LinkPrivate(uriInfo.getAbsolutePath() + "/" + generatedID.getInt(1),"self");

				return Response.status(Response.Status.CREATED).entity(l).header("Mensaje enviado", "OK").build();
			}

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo enviar el mensaje").build();
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el mensaje privado\n" + e.getStackTrace()).build();
		}
	}
	
	@GET
	@Path("{id}/amigos")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getFriends(@PathParam ("id") String id) {
		try {
			int int_id = Integer.parseInt(id);
			java.util.Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			String sql = "SELECT * FROM Amistad where idAmigo = " + int_id + " OR idAmistad = " + int_id + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			user_service u = new user_service();
			ArrayList<LinkUser> users = u.getUsers();
			rs.beforeFirst();
			while (rs.next()) {
				if (rs.getInt("idAmistad") == int_id) {
					users.add(new LinkUser(uriInfo.getAbsolutePath() + "/" + rs.getInt("idAmigo"),"self", ""));
				}
				else {
					users.add(new LinkUser(uriInfo.getAbsolutePath() + "/" + rs.getInt("idAmistad"),"self", ""));
				}
			}
			return Response.status(Response.Status.OK).entity(u).build();
		} catch (NumberFormatException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudieron convertir los índices a números").build();
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}
	}
	
	@POST
	@Path("{id}/amigos")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response createFriend(Peticion_amistad pt, @PathParam ("id") String id) {


		try {
			int int_id = Integer.parseInt(id);
			java.util.Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			
//			String sql = "INSERT INTO `social_bbdd`.`Privados` (`contenido`, `destinatario`, `fecha_envio`) " + "VALUES ('" + prv.getContenido() + "', '" + int_id + "', '" + date + "');";
//			System.out.println(sql);
//			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//	int affectedRows = ps.executeUpdate();
		//	ResultSet generatedID = ps.getGeneratedKeys();
			
			String sql = "SELECT * FROM Usuarios where nombre_usuario = " + '"' +pt.getId_amigo()+ '"' + ";";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int id_usuario = 0;
			rs.beforeFirst();
			if (rs.next()) {
				id_usuario = rs.getInt(1);
			}
			
			String sql2 = "INSERT INTO `social_bbdd`.`Amistad` (`idAmigo`, `idAmistad`) " + "VALUES ('" + int_id + "', '" + id_usuario  + "');";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			int affectedRows = ps2.executeUpdate();
			
			rs.beforeFirst();
			if (rs.next()) {
				
				LinkUser l = new LinkUser(uriInfo.getBaseUri().toString(),"self", rs.getString("nombre"));

				return Response.status(Response.Status.CREATED).entity(l).header("Mensaje enviado", "OK").build();
			}

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo enviar el mensaje").build();
		} catch (NumberFormatException e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("No puedo parsear a entero").build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el mensaje privado\n" + e.getStackTrace()).build();
		}
	}
	

	private User UserFromRS(ResultSet rs) throws SQLException {

		User user = new User(rs.getInt("id"), rs.getString("nombre"),rs.getInt("edad"),rs.getString("nombre_usuario"), rs.getString("aficiones"), new Date());
		return user;
	}
	
	private Message MessageFromRS(ResultSet rs) throws SQLException {
		Message msg = new Message (rs.getInt("id"), rs.getInt("id_usuario"), rs.getString("contenido"), new Date());
		return msg;
	}
	
	private Private PrivateFromRS(ResultSet rs) throws SQLException{
		Private prv = new Private (rs.getInt("id"), rs.getString("contenido"), rs.getInt("destinatario"), new Date());
		return prv;
	}

}
