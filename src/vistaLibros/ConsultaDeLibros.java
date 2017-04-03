package vistaLibros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ControladorLibro;
import modelo.Libro;
import modelo.Socio;
import vistaSocios.GestionSocio;

import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ConsultaDeLibros extends JDialog {
	private JTextField textFieldAutor;
	private JTextField textFieldNumPag;
	private ControladorLibro controladorLibro;
	private JComboBox comboBoxTitulos;
	private JComboBox comboBoxAutores;
	private JList listLibros;
	private JRadioButton radioButtonMenor100;
	private JRadioButton radioButtonEntre100y500;
	private JRadioButton radioButtonMayor500;
	private JTable tableLibros;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		comboBoxAutores = new JComboBox();
		comboBoxAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxAutoresActionPerformed();
			}
		});
		
		listLibros = new JList();
		
		JLabel lblEscogeUnAutor = new JLabel("Autores:");
		GroupLayout gl_panelAutor = new GroupLayout(panelAutor);
		gl_panelAutor.setHorizontalGroup(
			gl_panelAutor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAutor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAutor.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxAutores, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEscogeUnAutor))
					.addGap(18)
					.addComponent(listLibros, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelAutor.setVerticalGroup(
			gl_panelAutor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAutor.createSequentialGroup()
					.addGroup(gl_panelAutor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAutor.createSequentialGroup()
							.addContainerGap()
							.addComponent(listLibros, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
						.addGroup(gl_panelAutor.createSequentialGroup()
							.addGap(14)
							.addComponent(lblEscogeUnAutor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxAutores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panelAutor.setLayout(gl_panelAutor);
		
		JPanel panelNumPag = new JPanel();
		tabbedPane.addTab("Num. pag.", null, panelNumPag, null);
		
		radioButtonMenor100 = new JRadioButton("<100");
		radioButtonMenor100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSegunRadioButton();
			}
		});
		buttonGroup.add(radioButtonMenor100);
		
		
		radioButtonEntre100y500 = new JRadioButton("100 - 500");
		radioButtonEntre100y500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSegunRadioButton();
			}
		});
		buttonGroup.add(radioButtonEntre100y500);

		radioButtonMayor500 = new JRadioButton(">500");
		radioButtonMayor500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSegunRadioButton();
			}
		});
		buttonGroup.add(radioButtonMayor500);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelNumPag = new GroupLayout(panelNumPag);
		gl_panelNumPag.setHorizontalGroup(
			gl_panelNumPag.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumPag.createSequentialGroup()
					.addGroup(gl_panelNumPag.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumPag.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
						.addGroup(gl_panelNumPag.createSequentialGroup()
							.addGap(110)
							.addComponent(radioButtonMenor100)
							.addGap(18)
							.addComponent(radioButtonEntre100y500)
							.addGap(18)
							.addComponent(radioButtonMayor500)))
					.addContainerGap())
		);
		gl_panelNumPag.setVerticalGroup(
			gl_panelNumPag.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumPag.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelNumPag.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButtonMenor100)
						.addComponent(radioButtonEntre100y500)
						.addComponent(radioButtonMayor500))
					.addGap(7)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableLibros = new JTable();
		scrollPane.setViewportView(tableLibros);
		panelNumPag.setLayout(gl_panelNumPag);
	}

	protected void mostrarSegunRadioButton() {
		if(radioButtonMenor100.isSelected()){
			controladorLibro.buscarLibrosPorPaginas(0, 100);
		}else if(radioButtonEntre100y500.isSelected()){
			controladorLibro.buscarLibrosPorPaginas(101, 500);
		}else if(radioButtonMayor500.isSelected()){
			controladorLibro.buscarLibrosPorPaginas(501, 1000000);
		}
		
	}

	protected void comboBoxAutoresActionPerformed() {
		String autor = this.comboBoxAutores.getSelectedItem().toString();
		controladorLibro.rellenarListaPorAutor(autor);
		
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
	
	public void rellenarTablaLibros(ArrayList<Libro> libros){
		//Crear una tabla logica
		DefaultTableModel tableModel = new DefaultTableModel();
		
		//crear la cabezera
		Object[] burukoak = {"TITULO", "AUTOR", "NUMERO DE PAGINAS"}; 
		tableModel.setColumnIdentifiers(burukoak);
		
		//Rellellar tabla con socios
		for (Libro libro : libros){
			Object[] lerroa = {libro.getTitulo(), libro.getAutor(), libro.getNum_pag()};
			tableModel.addRow(lerroa);
		}
		
		//Rellenar tabla y darlo formato (Grafico)
		tableLibros.setModel(tableModel);
		
		//Ordenar tabla por campos (Alfabeticamente)
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(tableModel);
		tableLibros.setRowSorter(modeloOrdenado);
	}


	public void consultaLibrosRellenarFormulario(Libro libro) {
		// TODO Auto-generated method stub
		this.textFieldAutor.setText(libro.getAutor());
		this.textFieldNumPag.setText(String.valueOf(libro.getNum_pag()));
	}

	public void rellenarComboboxAutores(ArrayList<String> autores) {
		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for(String autor : autores){
			defaultComboBoxModel.addElement(autor);
		}
		defaultComboBoxModel.setSelectedItem("-Escoge el autor-");
		this.comboBoxAutores.setModel(defaultComboBoxModel);
	}

	public void rellenarListAutor(ArrayList<Libro> libros) {
		DefaultListModel defaultListModel = new DefaultListModel();
		
		Iterator<Libro> iterator = libros.iterator();
		while (iterator.hasNext()){
			Libro libro = iterator.next();
			defaultListModel.addElement(libro.getTitulo() + " - " + libro.getNum_pag());
		}
		this.listLibros.setModel(defaultListModel);
	}
}
