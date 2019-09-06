package pojos;

public class Admin {

	private String idAdmin;
	private String pass;
	private String mensaje;
	private String asunto;
	
	public Admin(){
		this.idAdmin = "";
		this.pass = "";
		this.mensaje = "";
		this.asunto = "";
	}
	
	public Admin(String idAdmin, String pass, String mensaje, String asunto) {
		this.idAdmin = idAdmin;
		this.pass = pass;
		this.mensaje = mensaje;
		this.asunto = asunto;
	}

	public String getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
}
