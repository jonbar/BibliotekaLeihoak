package controlador;

import controlador.*;
import modelo.*;
import vistaLibros.*;
import vistaPrestamos.GestionPrestamo;
import vistaPrestamos.RealizarPrestamo;
import vistaSocios.*;

public class Main {

	public static void main(String[] args) {
//		Crear controlador
		ControladorSocio controladorSocio = new ControladorSocio();
		ControladorLibro controladorLibro = new ControladorLibro();
		ControladorPrestamo controladorPrestamo = new ControladorPrestamo();
		
//		Crear modelos
		SocioModelo socioModelo = new SocioModelo();
		LibroModelo libroModelo = new LibroModelo();
		PrestamoModelo prestamoModelo = new PrestamoModelo();
		
//		Crear ventanas
		Principal principal = new Principal();
		
		GestionSocio gestionSocio = new GestionSocio(principal, true);
		FormularioDeSocio formularioSocio = new FormularioDeSocio(gestionSocio, true);
		BorrarSocios borrarSocios = new BorrarSocios(gestionSocio, true);
		ConsultaDeSocios consultaDeSocios = new ConsultaDeSocios(gestionSocio, true);
		
		GestionLibro gestionLibro = new GestionLibro(principal, true);
		FormularioLibro formularioLibro = new FormularioLibro(gestionLibro, true);
		ConsultaDeLibros consultaDeLibros = new ConsultaDeLibros(gestionLibro, true);
		
		GestionPrestamo gestionPrestamo = new GestionPrestamo(principal, true);
		RealizarPrestamo realizarPrestamo = new RealizarPrestamo(gestionPrestamo, true);
		
//		Poner controlador a las ventanas
		principal.setControladorSocio(controladorSocio);
		gestionSocio.setControladorSocio(controladorSocio);
		formularioSocio.setControladorSocio(controladorSocio);
		borrarSocios.setControladorSocio(controladorSocio);
		consultaDeSocios.setControladorSocio(controladorSocio);
		
		principal.setControladorLibro(controladorLibro);
		gestionLibro.setControladorLibro(controladorLibro);
		formularioLibro.setControladorLibro(controladorLibro);
		consultaDeLibros.setControladorLibro(controladorLibro);
		
		principal.setControladorPrestamo(controladorPrestamo);
		gestionPrestamo.setControladorPrestamo(controladorPrestamo);
		realizarPrestamo.setControladorPrestamo(controladorPrestamo);
		
//		asignar ventanas y modelos al controlador
		controladorSocio.setPrincipal(principal);
		controladorSocio.setGestionSocio(gestionSocio);
		controladorSocio.setFormularioSocio(formularioSocio);
		controladorSocio.setSocioModelo(socioModelo);
		controladorSocio.setBorrarSocios(borrarSocios);
		controladorSocio.setConsultaDeSocios(consultaDeSocios);
		
		controladorLibro.setPrincipal(principal);
		controladorLibro.setGestionLibro(gestionLibro);
		controladorLibro.setFormularioLibro(formularioLibro);
		controladorLibro.setLibroModelo(libroModelo);
		controladorLibro.setConsultaDeLibros(consultaDeLibros);
		
		controladorPrestamo.setPrincipal(principal);
		controladorPrestamo.setPrestamoModelo(prestamoModelo);
		controladorPrestamo.setLibroModelo(libroModelo);
		controladorPrestamo.setSocioModelo(socioModelo);
		controladorPrestamo.setGestionPrestamo(gestionPrestamo);
		controladorPrestamo.setRealizarPrestamo(realizarPrestamo);
		
		principal.setVisible(true);
	}

}
