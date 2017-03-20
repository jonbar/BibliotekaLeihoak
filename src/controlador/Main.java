package controlador;

import controlador.*;
import Vista.*;
import modelo.*;

public class Main {

	public static void main(String[] args) {
//		Crear controlador
		ControladorSocio controladorSocio = new ControladorSocio();
		
//		Crear modelos
		SocioModelo SocioModelo = new SocioModelo();
		
//		Crear ventanas
		Principal principal = new Principal();
		GestionSocio gestionSocio = new GestionSocio(principal, true);
		FormularioDeSocio formularioSocio = new FormularioDeSocio(gestionSocio, true);
		
//		Poner controlador a las ventanas
		principal.setControladorSocio(controladorSocio);
		gestionSocio.setControladorSocio(controladorSocio);
		formularioSocio.setControladorSocio(controladorSocio);
		
//		asignar ventanas y modelos al controlador
		controladorSocio.setPrincipal(principal);
		controladorSocio.setGestionSocio(gestionSocio);
		controladorSocio.setFormularioSocio(formularioSocio);
		controladorSocio.setSocioModelo(SocioModelo);
		
		principal.setVisible(true);
	}

}
