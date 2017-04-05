package vistaPrestamos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrestamo;
import modelo.Socio;
import vistaSocios.Principal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorPrestamo controladorPrestamo;
	private JTextField textFieldSocio;
	private JTextField textFieldLibro;

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}
	/**
	 * Create the dialog.
	 * @param modal 
	 * @param principal 
	 */
	public RealizarPrestamo(GestionPrestamo gestionPrestamo, boolean modal) {
		super(gestionPrestamo, modal);
		setBounds(100, 100, 388, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		textFieldSocio = new JTextField();
		
		textFieldLibro = new JTextField();
		textFieldLibro.setToolTipText("");
		
		JLabel lblEscogeElSocio = new JLabel("Mete el ID del socio:");
		
		JLabel lblEscogeElLibro = new JLabel("Titulo de libro:");
		
		JButton btnCrearPrestamo = new JButton("Crear prestamo");
		btnCrearPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hacerPrestamo();
			}
		});
		
		JLabel lblCrearUnNuevo = new JLabel("CREAR UN NUEVO PRESTAMO");
		lblCrearUnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEscogeElLibro)
							.addGap(89)
							.addGap(51)
							.addComponent(btnCrearPrestamo))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFieldLibro, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldSocio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblEscogeElSocio)))
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(120, Short.MAX_VALUE)
					.addComponent(lblCrearUnNuevo)
					.addGap(97))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCrearUnNuevo)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(btnCrearPrestamo)
							.addGap(92))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblEscogeElSocio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(lblEscogeElLibro)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldLibro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(36))))
		);
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
		}
	}

	protected void hacerPrestamo() {
		int idSocio = Integer.parseInt(textFieldSocio.getText());
		String tituloLibro = textFieldLibro.getText();
		controladorPrestamo.recogerLibro(tituloLibro, idSocio);
		
		textFieldSocio.setText("");
		textFieldLibro.setText("");
	}
}
