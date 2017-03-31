package vistaLibros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;
import modelo.Libro;
import vistaSocios.GestionSocio;

import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaDeLibros extends JDialog {
	private JTextField textFieldAutor;
	private JTextField textFieldNumPag;
	private ControladorLibro controladorLibro;
	private JComboBox comboBoxTitulos;

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	/**
	 * Create the dialog.
	 * @param modal 
	 * @param gestionSocio 
	 */
	public ConsultaDeLibros(GestionLibro gestionLibro, boolean modal) {
		super(gestionLibro, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelTitulo = new JPanel();
		tabbedPane.addTab("Titulo", null, panelTitulo, null);
		
		comboBoxTitulos = new JComboBox();
		comboBoxTitulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboboxTituluaActionPerformed();
			}
		});
		
		JLabel lblAutor = new JLabel("Autor:");
		
		textFieldAutor = new JTextField();
		textFieldAutor.setEnabled(false);
		textFieldAutor.setEditable(false);
		textFieldAutor.setColumns(10);
		
		JLabel lblNumeroDePaginas = new JLabel("Numero de paginas:");
		
		textFieldNumPag = new JTextField();
		textFieldNumPag.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNumPag.setEnabled(false);
		textFieldNumPag.setEditable(false);
		textFieldNumPag.setColumns(10);
		
		JLabel lblEligeElTitulo = new JLabel("Elige el titulo del libro:");
		GroupLayout gl_panelTitulo = new GroupLayout(panelTitulo);
		gl_panelTitulo.setHorizontalGroup(
			gl_panelTitulo.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTitulo.createSequentialGroup()
					.addContainerGap(190, Short.MAX_VALUE)
					.addGroup(gl_panelTitulo.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNumeroDePaginas)
						.addComponent(lblAutor, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNumPag)
						.addComponent(textFieldAutor, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
				.addGroup(Alignment.LEADING, gl_panelTitulo.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panelTitulo.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxTitulos, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEligeElTitulo))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		gl_panelTitulo.setVerticalGroup(
			gl_panelTitulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTitulo.createSequentialGroup()
					.addGap(13)
					.addComponent(lblEligeElTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxTitulos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAutor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNumeroDePaginas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNumPag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		panelTitulo.setLayout(gl_panelTitulo);
		
		JPanel panelAutor = new JPanel();
		tabbedPane.addTab("Autor", null, panelAutor, null);
		
		JPanel panelNumPag = new JPanel();
		tabbedPane.addTab("Num. pag.", null, panelNumPag, null);
	}

	protected void comboboxTituluaActionPerformed() {
		String item = this.comboBoxTitulos.getSelectedItem().toString();
		String[] partes = item.split(":");
		int idLiburua = Integer.parseInt(partes[0]);
		controladorLibro.rellenarPorTitulo(idLiburua);
	}

	public void rellenarCombobox(ArrayList<Libro> libros) {
		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for(Libro libro : libros){
			defaultComboBoxModel.addElement(libro.getId() + ": " + libro.getTitulo());
		}
		defaultComboBoxModel.setSelectedItem("-Elige el titulo-");
		this.comboBoxTitulos.setModel(defaultComboBoxModel);
		
//		Iterator<Libro> iterator = libros.iterator();
//		while (iterator.hasNext()){
//			Libro libro = iterator.next();
//			comboBoxTitulos.addItem(libro.getId() + ": " + libro.getTitulo());
//		}
//		this.comboBoxTitulos.setSelectedIndex(-1);
	}


	public void consultaLibrosRellenarFormulario(Libro libro) {
		// TODO Auto-generated method stub
		this.textFieldAutor.setText(libro.getAutor());
		this.textFieldNumPag.setText(String.valueOf(libro.getNum_pag()));
	}
}
