package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Socio;
import modelo.SocioModelo;
import vistaSocios.*;

public class ControladorSocio {

	private GestionSocio gestionSocio;
	private Principal principal;
	private FormularioDeSocio formularioDeSocio;
	private SocioModelo socioModelo;
	private BorrarSocios borrarSocios;
	
	public FormularioDeSocio getFormularioDeSocio() {
		return formularioDeSocio;
	}
	public void setFormularioDeSocio(FormularioDeSocio formularioDeSocio) {
		this.formularioDeSocio = formularioDeSocio;
	}
	public BorrarSocios getBorrarSocios() {
		return borrarSocios;
	}
	public void setBorrarSocios(BorrarSocios borrarSocios) {
		this.borrarSocios = borrarSocios;
	}
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
		this.gestionSocio.setVisible(true);		
	}
	public void abrirVentanaForSocio() {
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
	public void abrirVentanaBorrarSocios() {
		ArrayList<Socio> socios = socioModelo.select();
		borrarSocios.rellenarCombobox(socios);
		this.borrarSocios.setVisible(true);
	}
	public void cerrarBorrarSocio() {
		this.borrarSocios.dispose();
	}
	public void rellenarFormularioDeBorradoSocio(int idSocio) {
		Socio socio = socioModelo.select(idSocio);
		borrarSocios.rellenarCamposDeFormulario(socio);
	}
	public void eliminarSocio(int id) {
		socioModelo.delete(id);
		borrarSocios.clearAll();
		ArrayList<Socio> socios = socioModelo.select();
		borrarSocios.rellenarCombobox(socios);
	}
	
}
