package vistaPrestamos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ControladorPrestamo;
import modelo.Libro;
import modelo.Prestamo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VisualizarPrestamosDeSocio extends JDialog {

	private final JPanel contentPanelBuscarId = new JPanel();
	ControladorPrestamo controladorPrestamo;
	private JTextField textFieldIdSocio;
	private JTable tableInformacion;

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	/**
	 * Create the dialog.
	 * @param modal 
	 * @param gestionPrestamo 
	 */
	public VisualizarPrestamosDeSocio(GestionPrestamo gestionPrestamo, boolean modal) {
		super(gestionPrestamo, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.NORTH);
		tabbedPane.addTab("Buscar por ID", null, contentPanelBuscarId, null);
		contentPanelBuscarId.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel label = new JLabel("ID del socio:");
		
		textFieldIdSocio = new JTextField();
		textFieldIdSocio.setColumns(10);
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonBuscarActionListener();				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableInformacion = new JTable();
		scrollPane.setViewportView(tableInformacion);
		GroupLayout gl_contentPanelBuscarId = new GroupLayout(contentPanelBuscarId);
		gl_contentPanelBuscarId.setHorizontalGroup(
			gl_contentPanelBuscarId.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanelBuscarId.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPanelBuscarId.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanelBuscarId.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textFieldIdSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(buttonBuscar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPanelBuscarId.setVerticalGroup(
			gl_contentPanelBuscarId.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanelBuscarId.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPanelBuscarId.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanelBuscarId.createSequentialGroup()
							.addGap(4)
							.addComponent(label))
						.addGroup(gl_contentPanelBuscarId.createSequentialGroup()
							.addGap(1)
							.addComponent(textFieldIdSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonBuscar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
		);
		contentPanelBuscarId.setLayout(gl_contentPanelBuscarId);
	}
	
	protected void buttonBuscarActionListener() {
		int idSocio = Integer.parseInt(textFieldIdSocio.getText());
		controladorPrestamo.buscarPrestamosPorSocio(idSocio);		
	}

	public void rellenarTablaPrestamos(ArrayList<Prestamo> prestamos){
		//Crear una tabla logica
		DefaultTableModel tableModel = new DefaultTableModel();
		
		//crear la cabezera
		Object[] burukoak = {"TITULO", "FECHA", "DEVUELTO"}; 
		tableModel.setColumnIdentifiers(burukoak);
		
		//
		for (Prestamo prestamo : prestamos){
			Object[] lerroa = {prestamo.getLibro().getTitulo(), prestamo.getFecha(), prestamo.isDevuelto()};
			tableModel.addRow(lerroa);
		}
		
		//Rellenar tabla y darlo formato (Grafico)
		tableInformacion.setModel(tableModel);
		
		//Ordenar tabla por campos (Alfabeticamente)
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(tableModel);
		tableInformacion.setRowSorter(modeloOrdenado);
	}
}
