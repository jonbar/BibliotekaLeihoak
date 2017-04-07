package controlador;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.LibroModelo;
import modelo.Prestamo;
import modelo.PrestamoModelo;
import modelo.SocioModelo;
import vistaPrestamos.GestionPrestamo;
import vistaPrestamos.RealizarPrestamo;
import vistaPrestamos.VisualizarPrestamosDeSocio;
import vistaSocios.Principal;

public class ControladorPrestamo {

	private Principal principal;
	private ControladorPrestamo controladorPrestamo;
	private PrestamoModelo prestamoModelo;
	private SocioModelo socioModelo;
	private LibroModelo libroModelo;
	private RealizarPrestamo realizarPrestamo;
	private GestionPrestamo gestionPrestamo;
	private VisualizarPrestamosDeSocio visualizarPrestamosDeSocio;
	
	public VisualizarPrestamosDeSocio getVisualizarPrestamosDeSocio() {
		return visualizarPrestamosDeSocio;
	}
	public void setVisualizarPrestamosDeSocio(VisualizarPrestamosDeSocio visualizarPrestamosDeSocio) {
		this.visualizarPrestamosDeSocio = visualizarPrestamosDeSocio;
	}
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

	public void recogerLibro(String tituloLibro, int idSocio) {
		
		if (this.socioModelo.select(idSocio) != null){
			//SELECT hecho para conseguir el id del libro
			Libro libro = libroModelo.selectPorTitulo(tituloLibro);
			int idLibro = libro.getId();
			
			//prestamo creado para pasarselo al INSERT
			Prestamo prestamo = new Prestamo();
			prestamo.setId_libro(idLibro);
			prestamo.setId_socio(idSocio);
			prestamo.setFecha(new Date());
			prestamo.setDevuelto(false);
			
			//Prestamo pasado al insert
			prestamoModelo.insert(prestamo);
			JOptionPane.showMessageDialog(this.realizarPrestamo, "Prestamo realizado", "Prestamo", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			this.realizarPrestamo.remarcarError();
			JOptionPane.showMessageDialog(this.realizarPrestamo, "Error");
		}
		//Limpiar TextFields
		realizarPrestamo.limpiar();
	}
	public void abrirVentanaVisualizarPrestamosDeSocio() {
		this.visualizarPrestamosDeSocio.setVisible(true);
	}
	public void buscarPrestamosPorSocio(int idSocio) {
		ArrayList<Prestamo> prestamos = prestamoModelo.selectPrestamosDeSocio(idSocio);
		
		this.visualizarPrestamosDeSocio.rellenarTablaPrestamos(prestamos);
	}
}
