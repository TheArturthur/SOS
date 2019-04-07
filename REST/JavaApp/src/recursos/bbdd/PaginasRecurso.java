package recursos.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

import datos.Pagina;
import datos.User;
import datos.Message;
import datos.Paginas;
import datos.Link;

@Path("/URI")
public class PaginasRecurso {

	@Context
	private UriInfo uriInfo;

	private DataSource ds;
	private Connection conn;

	public PaginasRecurso() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			NamingContext envCtx = (NamingContext) ctx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/PaginasyEmpleados");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**Copied from GarajesYEmpleados.GarajesRecurso.java
 * 
	// Lista de usuarios JSON/XML generada con listas en JAXB
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getPaginas2(@QueryParam("offset") @DefaultValue("1") String offset,
			@QueryParam("count") @DefaultValue("10") String count) {
		try {
			int off = Integer.parseInt(offset);
			int c = Integer.parseInt(count);
			String sql = "SELECT * FROM Pagina order by id LIMIT " + (off - 1) + "," + c + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Paginas p = new Paginas();
			ArrayList<Link> paginas = p.getPaginas();
			rs.beforeFirst();
			while (rs.next()) {
				paginas.add(new Link(uriInfo.getAbsolutePath() + "/" + rs.getInt("id"), "self"));
			}
			return Response.status(Response.Status.OK).entity(p).build(); // No se puede devolver el ArrayList (para
																			// generar XML)
		} catch (NumberFormatException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudieron convertir los índices a números")
					.build();
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error de acceso a BBDD").build();
		}
	}

	@GET
	@Path("{pagina_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getPagina(@PathParam("pagina_id") String id) {
		try {
			int int_id = Integer.parseInt(id);
			String sql = "SELECT * FROM Pagina where id=" + int_id + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Pagina pagina = paginaFromRS(rs);
				return Response.status(Response.Status.OK).entity(pagina).build();
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
	@Consumes(MediaType.APPLICATION_XML)
	public Response createPagina(Pagina pagina) {
		try {
			String sql = "INSERT INTO `PaginasyEmpleados`.`Pagina` (`nombre`, `direccion`, `telefono`) " + "VALUES ('"
					+ pagina.getNombre() + "', '" + pagina.getDireccion() + "', '" + pagina.getTelefono() + "');";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int affectedRows = ps.executeUpdate();

			// Obtener el ID del elemento recién creado.
			// Necesita haber indicado Statement.RETURN_GENERATED_KEYS al ejecutar un
			// statement.executeUpdate() o al crear un PreparedStatement
			ResultSet generatedID = ps.getGeneratedKeys();
			if (generatedID.next()) {
				pagina.setId(generatedID.getInt(1));
				String location = uriInfo.getAbsolutePath() + "/" + pagina.getId();
				return Response.status(Response.Status.CREATED).entity(pagina).header("Location", location)
						.header("Content-Location", location).build();
			}
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo crear el pagina").build();

		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("No se pudo crear el pagina\n" + e.getStackTrace()).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("{pagina_id}")
	public Response updatePagina(@PathParam("pagina_id") String id, Pagina nuevoPagina) {
		try {
			Pagina pagina;
			int int_id = Integer.parseInt(id);
			String sql = "SELECT * FROM Pagina where id=" + int_id + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pagina = paginaFromRS(rs);
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("Elemento no encontrado").build();
			}
			pagina.setDireccion(nuevoPagina.getDireccion());
			pagina.setNombre(nuevoPagina.getNombre());
			pagina.setTelefono(nuevoPagina.getTelefono());

			// UPDATE `PaginasyEmpleados`.`Pagina` SET `nombre`='No es Torres',
			// `telefono`='910234567' WHERE `id`='3';

			sql = "UPDATE `PaginasyEmpleados`.`Pagina` SET " + "`nombre`='" + pagina.getNombre() + "', `direccion`='"
					+ pagina.getDireccion() + "', `telefono`='" + pagina.getTelefono() + "';";
			ps = conn.prepareStatement(sql);
			int affectedRows = ps.executeUpdate();

			// Location a partir del URI base (host + root de la aplicación + ruta del
			// servlet)
			String location = uriInfo.getBaseUri() + "paginas/" + pagina.getId();
			return Response.status(Response.Status.OK).entity(pagina).header("Content-Location", location).build();
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("No se pudo actualizar el pagina\n" + e.getStackTrace()).build();
		}
	}

	@DELETE
	@Path("{pagina_id}")
	public Response deletePagina(@PathParam("pagina_id") String id) {
		try {
			Pagina pagina;
			int int_id = Integer.parseInt(id);
			String sql = "DELETE FROM `PaginasyEmpleados`.`Pagina` WHERE `id`='" + int_id + "';";
			PreparedStatement ps = conn.prepareStatement(sql);
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1)
				return Response.status(Response.Status.NO_CONTENT).build();
			else
				return Response.status(Response.Status.NOT_FOUND).entity("Elemento no encontrado").build();
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("No se pudo eliminar el pagina\n" + e.getStackTrace()).build();
		}
	}

	private Pagina paginaFromRS(ResultSet rs) throws SQLException {
		Pagina pagina = new Pagina(rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"));
		pagina.setId(rs.getInt("id"));
		return pagina;
	}
	*/
}
