package vistaLibros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;
import vistaSocios.Principal;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorLibro controladorLibro;

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	/**
	 * Create the dialog.
	 * @param modal 
	 * @param principal 
	 */
	public GestionLibro(Principal principal, boolean modal) {
		super(principal, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton btnAadirLibro = new JButton("A\u00F1adir libro");
		btnAadirLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorLibro.abrirVentanaForLibro();
			}
		});
		
		JButton btnEliminarLibro = new JButton("Eliminar libro");
		
		JButton btnModificar = new JButton("Modificar");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ikaslea\\Desktop\\descarga (2).jpg"));
		
		JButton btnConsultarLibros = new JButton("Consultar libros");
		btnConsultarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaDeLibrosActionPerformed();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnEliminarLibro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAadirLibro))
						.addComponent(btnConsultarLibros))
					.addGap(48)
					.addComponent(lblNewLabel)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(29)
							.addComponent(btnAadirLibro)
							.addGap(18)
							.addComponent(btnEliminarLibro)
							.addGap(18)
							.addComponent(btnModificar)
							.addGap(18)
							.addComponent(btnConsultarLibros)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorLibro.cerrarVentana();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void consultaDeLibrosActionPerformed() {
		controladorLibro.abrirVentanaConsultaDeLibros();
	}
}
