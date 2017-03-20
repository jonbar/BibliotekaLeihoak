package controlador;

import javax.swing.JOptionPane;

import Vista.*;
import modelo.Socio;
import modelo.SocioModelo;

public class ControladorSocio {

	private GestionSocio gestionSocio;
	private Principal principal;
	private FormularioDeSocio formularioDeSocio;
	private SocioModelo socioModelo;
	
	public SocioModelo getSocioModelo() {
		return socioModelo;
	}
	public void setSocioModelo(SocioModelo socioModelo) {
		this.socioModelo = socioModelo;
	}
	public GestionSocio getGestionSocio() {
		return gestionSocio;
	}
	public void setGestionSocio(GestionSocio gestionSocio) {
		this.gestionSocio = gestionSocio;
	}
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	
	public FormularioDeSocio getFormularioSocio() {
		return formularioDeSocio;
	}
	public void setFormularioSocio(FormularioDeSocio formularioSocio) {
		this.formularioDeSocio = formularioSocio;
	}
	public void abrirVentanaGesSocio() {
		this.formularioDeSocio.setVisible(true);		
	}
	public void cerrarFormularioDeSocio() {
		this.formularioDeSocio.limpiarFormulario();
		this.formularioDeSocio.dispose();	
	}
	public void guardarSocio(String nombre, String apellido, String direccion, String poblacion, String provincia, String dni) {
		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);
		
		socioModelo.insert(socio);
		
		JOptionPane.showMessageDialog(formularioDeSocio, "Gestion finalizada con exito", "Bien", 1);
	}
	public void limpiarFormulario() {
		this.formularioDeSocio.limpiarFormulario();
	}
	
}
