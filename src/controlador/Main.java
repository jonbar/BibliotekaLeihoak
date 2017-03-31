package controlador;

import controlador.*;
import modelo.*;
import vistaLibros.*;
import vistaSocios.*;

public class Main {

	public static void main(String[] args) {
//		Crear controlador
		ControladorSocio controladorSocio = new ControladorSocio();
		ControladorLibro controladorLibro = new ControladorLibro();
		
//		Crear modelos
		SocioModelo SocioModelo = new SocioModelo();
		LibroModelo libroModelo = new LibroModelo();
		
//		Crear ventanas
		Principal principal = new Principal();
		GestionSocio gestionSocio = new GestionSocio(principal, true);
		FormularioDeSocio formularioSocio = new FormularioDeSocio(gestionSocio, true);
		BorrarSocios borrarSocios = new BorrarSocios(gestionSocio, true);
		ConsultaDeSocios consultaDeSocios = new ConsultaDeSocios(gestionSocio, true);
		GestionLibro gestionLibro = new GestionLibro(principal, true);
		FormularioLibro formularioLibro = new FormularioLibro(gestionLibro, true);
		ConsultaDeLibros consultaDeLibros = new ConsultaDeLibros(gestionLibro, true);
		
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
		
//		asignar ventanas y modelos al controlador
		controladorSocio.setPrincipal(principal);
		controladorSocio.setGestionSocio(gestionSocio);
		controladorSocio.setFormularioSocio(formularioSocio);
		controladorSocio.setSocioModelo(SocioModelo);
		controladorSocio.setBorrarSocios(borrarSocios);
		controladorSocio.setConsultaDeSocios(consultaDeSocios);
		
		controladorLibro.setPrincipal(principal);
		controladorLibro.setGestionLibro(gestionLibro);
		controladorLibro.setFormularioLibro(formularioLibro);
		controladorLibro.setLibroModelo(libroModelo);
		controladorLibro.setConsultaDeLibros(consultaDeLibros);
		
		principal.setVisible(true);
	}

}
