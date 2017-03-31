package controlador;

import modelo.*;
import vistaSocios.*;
import vistaLibros.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.*;

public class ControladorLibro {

	private Principal principal;
	private FormularioLibro formularioLibro;
	private GestionLibro gestionLibro;
	private LibroModelo libroModelo;
	private ConsultaDeLibros consultaDeLibros;
	
	
	public ConsultaDeLibros getConsultaDeLibros() {
		return consultaDeLibros;
	}
	public void setConsultaDeLibros(ConsultaDeLibros consultaDeLibros) {
		this.consultaDeLibros = consultaDeLibros;
	}
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public FormularioLibro getFormularioLibro() {
		return formularioLibro;
	}
	public void setFormularioLibro(FormularioLibro formularioLibro) {
		this.formularioLibro = formularioLibro;
	}
	public GestionLibro getGestionLibro() {
		return gestionLibro;
	}
	public void setGestionLibro(GestionLibro gestionLibro) {
		this.gestionLibro = gestionLibro;
	}
	public LibroModelo getLibroModelo() {
		return libroModelo;
	}
	public void setLibroModelo(LibroModelo libroModelo) {
		this.libroModelo = libroModelo;
	}
	public void abrirVentanaGesLibro() {
		this.gestionLibro.setVisible(true);	
	}	
	public void abrirVentanaForLibro() {
		this.formularioLibro.setVisible(true);	
	}
	public void limpiarFormulario() {
		formularioLibro.limpiarFormulario();
	}
	public void guardarLibro(String titulo, String autor, String numpaginas) {
		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setNum_pag(Integer.parseInt(numpaginas));
		
		libroModelo.insert(libro);
		
		JOptionPane.showMessageDialog(formularioLibro, "Gestion finalizada con exito", "Bien", 1);
	}
	public void cerrarVentana() {
		formularioLibro.limpiarFormulario();
		formularioLibro.dispose();
	}
	public void abrirVentanaConsultaDeLibros() {
		ArrayList<Libro> libros = libroModelo.select();
		this.consultaDeLibros.rellenarCombobox(libros);
		this.consultaDeLibros.setVisible(true);
	}
	public void rellenarPorTitulo(int idLiburua) {
		Libro libro = this.libroModelo.select(idLiburua);
		this.consultaDeLibros.consultaLibrosRellenarFormulario(libro);
	}	
}
