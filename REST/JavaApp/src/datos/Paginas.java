package datos;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paginas")
public class Paginas {
	private ArrayList<Link> paginas;

	public Paginas() {
		this.paginas = new ArrayList<Link>();
	}

	@XmlElement(name="pagina")
	public ArrayList<Link> getPaginas() {
		return paginas;
	}

	public void setPaginas(ArrayList<Link> paginas) {
		this.paginas = paginas;
	}
}
