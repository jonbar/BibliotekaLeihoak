package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSocio;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioDeSocio extends JDialog {

	private ControladorSocio controladorSocio;

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDireccion;
	private JTextField textFieldPoblacion;
	private JTextField textFieldProvincia;
	private JTextField textFieldDNI;

	/**
	 * Create the dialog.
	 * 
	 * @param modal
	 * @param gestionSocio
	 */
	public FormularioDeSocio(GestionSocio gestionSocio, boolean modal) {
		super(gestionSocio, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNombre = new JLabel("Nombre: ");
		JLabel lblApellido = new JLabel("Apellido: ");
		JLabel lblDireccion = new JLabel("Direccion: ");
		JLabel lblPoblacion = new JLabel("Poblacion:");
		JLabel lblProvincia = new JLabel("Provincia:");
		JLabel lblDni = new JLabel("DNI:");
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldPoblacion = new JTextField();
		textFieldPoblacion.setColumns(10);
		textFieldProvincia = new JTextField();
		textFieldProvincia.setColumns(10);
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblNombre).addGap(18)
										.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblDireccion).addGap(12)
										.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblApellido).addGap(18)
										.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblPoblacion)
								.addComponent(lblDni).addComponent(lblProvincia))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldPoblacion, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(textFieldDNI).addComponent(textFieldProvincia, Alignment.TRAILING))
						.addGap(24)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPoblacion).addComponent(textFieldPoblacion, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblApellido)
								.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProvincia).addComponent(textFieldProvincia, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblDireccion)
								.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDni).addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(118, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Guardar = new JButton("Guardar");
				Guardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorSocio.guardarSocio(textFieldNombre.getText(), textFieldApellido.getText(),
								textFieldDireccion.getText(), textFieldPoblacion.getText(),
								textFieldProvincia.getText(), textFieldDNI.getText());
						controladorSocio.limpiarFormulario();
					}	
				});
				Guardar.setActionCommand("OK");
				buttonPane.add(Guardar);
				getRootPane().setDefaultButton(Guardar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorSocio.cerrarFormularioDeSocio();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldDireccion.setText(""); 
		textFieldPoblacion.setText("");
		textFieldProvincia.setText(""); 
		textFieldDNI.setText("");
		
	}

}
