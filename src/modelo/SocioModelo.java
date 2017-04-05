package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.*;

public class SocioModelo extends Conector{

	private ControladorSocio controladorSocio;
	private ControladorPrestamo controladorPrestamo;
	
	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	public SocioModelo() {
		super();
	}
	
	public ArrayList <Socio> select(){
		ArrayList<Socio> socios = new ArrayList<Socio>(); 
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios");
			while(rs.next()){
				socios.add(new Socio(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("poblacion"), rs.getString("provincia"), rs.getString("dni")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socios;
	}
	
	public Socio select(int id) {
		Socio socio = null;
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios where id='" + id + "'");
			rs.next();
			socio = new Socio((id), rs.getString("nombre"), rs.getString("apellido"),
									rs.getString("direccion"), rs.getString("poblacion"),
									rs.getString("provincia"), rs.getString("dni"));
			return socio;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return socio;
	}
	
	public ArrayList<Socio> select(String nombre) {
		ArrayList<Socio> socios = null;
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios where Nombre='" + nombre + "'");
			rs.next();
			Socio socio = new Socio(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
									rs.getString("direccion"), rs.getString("poblacion"),
									rs.getString("provincia"), rs.getString("dni"));
			socios.add(socio);
			return socios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return socios;
	}
	
	public void insert(Socio socio) {
		Statement st;
		try {
			st = super.getConexion().createStatement();
			System.out.println("INSERT INTO socios (nombre,apellido,direccion,poblacion,provincia,dni) " 
					 + "VALUES ('" + socio.getNombre() + "','"
		 			   + socio.getApellido() + "','" 
		 			   + socio.getDireccion() + "','" 
		 			   + socio.getPoblacion() + "','" 
		 			   + socio.getProvincia() + "','" 
		 			   + socio.getDni() + "')");
			st.execute("INSERT INTO socios (nombre,apellido,direccion,poblacion,provincia,dni) " 
					 + "VALUES ('" + socio.getNombre() + "','"
					 			   + socio.getApellido() + "','" 
					 			   + socio.getDireccion() + "','" 
					 			   + socio.getPoblacion() + "','" 
					 			   + socio.getProvincia() + "','" 
					 			   + socio.getDni() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int update(Socio socio) {
		int lineasCambiadas = 0;
		try {
			Statement st = super.getConexion().createStatement();
			lineasCambiadas = st.executeUpdate("UPDATE socios "
											 + "SET nombre='"  	 + socio.getNombre()  	+ "'"
											 + ",apellido='"  + socio.getApellido() 	+ "'"
											 + ",direccion='" + socio.getDireccion() + "'"
											 + ",poblacion='" + socio.getPoblacion() + "'"
											 + ",provincia='" + socio.getProvincia() + "'"
											 + ",dni='"		 + socio.getDni() 		+ "'"
											 + " WHERE id=" + socio.getId());
			return lineasCambiadas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineasCambiadas;

	}
	
	public void delete(int id) {
		try {
			Statement st = super.getConexion().createStatement();
			st.execute("DELETE FROM socios " + "WHERE id= ('" + id + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
