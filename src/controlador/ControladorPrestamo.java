package controlador;

import java.util.ArrayList;

import modelo.Libro;
import modelo.LibroModelo;
import modelo.PrestamoModelo;
import modelo.Socio;
import modelo.SocioModelo;
import vistaPrestamos.GestionPrestamo;
import vistaPrestamos.RealizarPrestamo;
import vistaSocios.Principal;

public class ControladorPrestamo {

	private Principal principal;
	private ControladorPrestamo controladorPrestamo;
	private PrestamoModelo prestamoModelo;
	private SocioModelo socioModelo;
	private LibroModelo libroModelo;
	private RealizarPrestamo realizarPrestamo;
	private GestionPrestamo gestionPrestamo;
	
	public SocioModelo getSocioModelo() {
		return socioModelo;
	}
	public void setSocioModelo(SocioModelo socioModelo) {
		this.socioModelo = socioModelo;
	}
	public LibroModelo getLibroModelo() {
		return libroModelo;
	}
	public void setLibroModelo(LibroModelo libroModelo) {
		this.libroModelo = libroModelo;
	}
	public RealizarPrestamo getRealizarPrestamo() {
		return realizarPrestamo;
	}
	public void setRealizarPrestamo(RealizarPrestamo realizarPrestamo) {
		this.realizarPrestamo = realizarPrestamo;
	}
	public PrestamoModelo getPrestamoModelo() {
		return prestamoModelo;
	}
	public void setPrestamoModelo(PrestamoModelo prestamoModelo) {
		this.prestamoModelo = prestamoModelo;
	}
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}
	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}
	public GestionPrestamo getGestionPrestamo() {
		return gestionPrestamo;
	}
	public void setGestionPrestamo(GestionPrestamo gestionPrestamo) {
		this.gestionPrestamo = gestionPrestamo;
	}
	public void abrirVentanaGesPrestamo() {
		this.gestionPrestamo.setVisible(true);	
	}
	public void abrirVentanaRealizarPrestamo() {
		this.realizarPrestamo.setVisible(true);
	}
	public void crearPrestamo(int idSocio, int idLibro) {
		prestamoModelo.insert(idSocio, idLibro);
	}
	public void recogerLibro(String tituloLibro, int idSocio) {
		Libro libro = libroModelo.selectPorTitulo(tituloLibro);
		int id = libro.getId();
		
		prestamoModelo.insert(idSocio, id);
	}
}
