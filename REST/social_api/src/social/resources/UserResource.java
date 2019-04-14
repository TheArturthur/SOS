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
			String sql = "INSERT INTO `social_bbdd`.`Usuarios` (`nombre`, `edad`, `aficiones`, `fecha_creacion`) " + "VALUES ('"
					+ user.getNombre() + "', '" + user.getEdad() + "', '" + user.getAficiones() + "', '" + date + "');";
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
	
	
	
	
	
	private User UserFromRS(ResultSet rs) throws SQLException {
		
		User user = new User(rs.getInt("id"), rs.getString("nombre"),rs.getInt("edad"), rs.getString("aficiones"), new Date());
		return user;
	}

}
