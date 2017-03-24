package vistaSocios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ControladorSocio;
import modelo.Socio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaDeSocios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ControladorSocio controladorSocio;
	private JTextField textFieldBuscarNombre;

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	/**
	 * Create the dialog.
	 * @param b 
	 * @param gestionSocio 
	 */
	public ConsultaDeSocios(GestionSocio gestionSocio, boolean modal) {
		super(gestionSocio, modal);
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		textFieldBuscarNombre = new JTextField();
		textFieldBuscarNombre.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorSocio.rellenarTablaPorNombre();
			}
		});
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon("C:\\Users\\ikaslea\\Desktop\\Nueva carpeta (2)\\asd.png"));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldBuscarNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNombre)
							.addComponent(textFieldBuscarNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
		);
		{
			table = new JTable();
			table.setFont(new Font("Verdana", Font.PLAIN, 11));
			table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 11));
			table.getTableHeader().setBackground(Color.BLACK);
			table.getTableHeader().setForeground(Color.WHITE);
			table.setBackground(Color.LIGHT_GRAY);
			scrollPane.setViewportView(table);
		}
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void rellenarTabla(ArrayList<Socio> socios) {
		//Crear una tabla logica
		DefaultTableModel tableModel = new DefaultTableModel();
		
		//crear la cabezera
		Object[] burukoak = {"NOMBRE", "APELLIDO", "DIRECCION", "POBLACION", "PROVINCIA", "DNI"}; 
		tableModel.setColumnIdentifiers(burukoak);
		
		//Rellellar tabla con socios
		for (Socio socio : socios){
			Object[] lerroa = {socio.getNombre(), socio.getApellido(), socio.getDireccion(), socio.getPoblacion(), socio.getProvincia(), socio.getDni()};
			tableModel.addRow(lerroa);
		}
		
		//Rellenar tabla y darlo formato (Grafico)
		table.setModel(tableModel);
		
		//Ordenar tabla por campos (Alfabeticamente)
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(modeloOrdenado);
	}

	public String recogerNombre() {
		String nombre = textFieldBuscarNombre.getText().toString();
		return nombre;
	}
}
