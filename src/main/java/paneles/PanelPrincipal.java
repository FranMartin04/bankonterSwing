package paneles;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.ControladorContratoJPA;
import entities.Contrato;
import entities.Tipocontrato;
import entities.Usuario;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfDescripcion;
	private JTextField jtfTipoContrato;
	private JSpinner jspinner;
	private JSlider jslider;
	private JLabel lblSlider;
	private JFormattedTextField jftf;
	private JLabel lblUsuario;
	private Contrato ultimoContratoCargado;

	/**
	 * Create the panel.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Panel Principal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.getContentPane().add(new PanelPrincipal());
		frame.setVisible(true);
	}

	public PanelPrincipal() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridwidth = 7;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);

		JButton btnStart = new JButton("");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		btnStart.setIcon(new ImageIcon(
				"/home/diurno/git/tutorialjava2023-24-maven/src/main/java/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png"));
		toolBar.add(btnStart);

		JButton btnPrevio = new JButton("");
		btnPrevio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		btnPrevio.setIcon(new ImageIcon(
				"/home/diurno/git/tutorialjava2023-24-maven/src/main/java/tutorialJava/capitulo9_AWT_SWING/res/previous.png"));
		toolBar.add(btnPrevio);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarSiguiente();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(
				"/home/diurno/git/tutorialjava2023-24-maven/src/main/java/tutorialJava/capitulo9_AWT_SWING/res/next.png"));
		toolBar.add(btnSiguiente);

		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarUltimo();
			}
		});
		btnUltimo.setIcon(new ImageIcon(
				"/home/diurno/git/tutorialjava2023-24-maven/src/main/java/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png"));
		toolBar.add(btnUltimo);

		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(
				"/home/diurno/git/tutorialjava2023-24-maven/src/main/java/tutorialJava/capitulo9_AWT_SWING/res/nuevo.png"));
		toolBar.add(btnNuevo);

		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(
				"/home/diurno/git/tutorialjava2023-24-maven/src/main/java/tutorialJava/capitulo9_AWT_SWING/res/guardar.png"));
		toolBar.add(btnGuardar);

		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnEliminar.setIcon(new ImageIcon(
				"/home/diurno/git/tutorialjava2023-24-maven/src/main/java/tutorialJava/capitulo9_AWT_SWING/res/eliminar.png"));
		toolBar.add(btnEliminar);

		JLabel lblNewLabel = new JLabel("Contrato");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 6;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		GridBagConstraints gbc_jftfFecha = new GridBagConstraints();
		gbc_jftfFecha.gridwidth = 6;
		gbc_jftfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jftfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftfFecha.gridx = 1;
		gbc_jftfFecha.gridy = 3;
		add(getJFormattedTextFieldDatePersonalizado(), gbc_jftfFecha);

		JLabel lblNewLabel_4 = new JLabel("Saldo:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jspinner = new JSpinner();
		GridBagConstraints gbc_jspinner = new GridBagConstraints();
		gbc_jspinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_jspinner.gridwidth = 6;
		gbc_jspinner.insets = new Insets(0, 0, 5, 5);
		gbc_jspinner.gridx = 1;
		gbc_jspinner.gridy = 4;
		add(jspinner, gbc_jspinner);

		JLabel lblNewLabel_5 = new JLabel("Limite:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jslider = new JSlider();
		GridBagConstraints gbc_jslider = new GridBagConstraints();
		gbc_jslider.fill = GridBagConstraints.BOTH;
		gbc_jslider.gridwidth = 6;
		gbc_jslider.insets = new Insets(0, 0, 5, 5);
		gbc_jslider.gridx = 1;
		gbc_jslider.gridy = 5;
		add(jslider, gbc_jslider);

		lblSlider = new JLabel("");
		GridBagConstraints gbc_lblSlider = new GridBagConstraints();
		gbc_lblSlider.insets = new Insets(0, 0, 5, 0);
		gbc_lblSlider.gridx = 7;
		gbc_lblSlider.gridy = 5;
		add(lblSlider, gbc_lblSlider);

		JLabel lblNewLabel_6 = new JLabel("TipoContrato:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfTipoContrato = new JTextField();
		jtfTipoContrato.setEnabled(false);
		GridBagConstraints gbc_jtfTipoContrato = new GridBagConstraints();
		gbc_jtfTipoContrato.gridwidth = 5;
		gbc_jtfTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipoContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipoContrato.gridx = 1;
		gbc_jtfTipoContrato.gridy = 6;
		add(jtfTipoContrato, gbc_jtfTipoContrato);
		jtfTipoContrato.setColumns(10);

		JButton btnTipoContrato = new JButton("Selecciona");
		btnTipoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Tipo Contrato");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelTipoContrato());
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que
				// deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - dialogo.getWidth() / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - dialogo.getHeight() / 2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnTipoContrato = new GridBagConstraints();
		gbc_btnTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_btnTipoContrato.gridx = 6;
		gbc_btnTipoContrato.gridy = 6;
		add(btnTipoContrato, gbc_btnTipoContrato);

		JLabel lblNewLabel_7 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		lblUsuario = new JLabel("New label");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.gridwidth = 5;
		gbc_lblUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 7;
		add(lblUsuario, gbc_lblUsuario);

		JButton btnUsuario = new JButton("Selecciona");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Usuario");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelUsuario());
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que
				// deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - dialogo.getWidth() / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - dialogo.getHeight() / 2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnUsuario = new GridBagConstraints();
		gbc_btnUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_btnUsuario.gridx = 6;
		gbc_btnUsuario.gridy = 7;
		add(btnUsuario, gbc_btnUsuario);

		sincronizarSpinnerYSlider();
		cargarPrimero();

	}

	public void sincronizarSpinnerYSlider() {
		jspinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valorMaximo = (int) jspinner.getValue();
				jslider.setMaximum(valorMaximo);
				lblSlider.setText(String.valueOf(valorMaximo));
			}
		});
	}

	private JFormattedTextField getJFormattedTextFieldDatePersonalizado() {
		jftf = new JFormattedTextField(new JFormattedTextField.AbstractFormatter() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null && value instanceof Date) {
					return sdf.format(((Date) value));
				}
				return "";
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				try {
					return sdf.parse(text);
				} catch (Exception e) {
					jftf.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Error en la fecha");
					jftf.setBackground(Color.WHITE);
					return null;
				}
			}
		});
		jftf.setColumns(20);
		jftf.setValue(new Date());
		return jftf;
	}

	/**
	 * 
	 * @return
	 */
	public void cargarContrato(Contrato contrato) {
	    jtfDescripcion.setText(contrato.getDescripcion());
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    String fechaFormateada = sdf.format(contrato.getFechaFirma());
	    jftf.setText(fechaFormateada);
	    // jspinner.setValue(contrato.getSaldo());
	    jslider.setValue((int) contrato.getLimite());
	    Tipocontrato tipoContrato = contrato.getTipocontrato();
	    String textoTipoContrato = tipoContrato.getId() + "-" + tipoContrato.getDescripcion();
	    jtfTipoContrato.setText(textoTipoContrato);
	    Usuario usuario = contrato.getUsuario();
	    String textoUsuario = usuario.getId() + "-" + usuario.getNombreUsuario();
	    lblUsuario.setText(textoUsuario);
	}

	public void cargarPrimero() {
        Contrato primerContrato = (Contrato) ControladorContratoJPA.getInstance().findFirst();
        cargarContrato(primerContrato);
        ultimoContratoCargado = primerContrato; // Guardar referencia al último contrato cargado
    }

    public void cargarUltimo() {
        Contrato ultimoContrato = (Contrato) ControladorContratoJPA.getInstance().findLast();
        cargarContrato(ultimoContrato);
        ultimoContratoCargado = ultimoContrato; // Guardar referencia al último contrato cargado
    }

    public void cargarSiguiente() {
        if (ultimoContratoCargado == null) {
            cargarPrimero();
        } else {
            // Obtenemos el siguiente contrato después del último cargado
            Contrato siguienteContrato = (Contrato) ControladorContratoJPA.getInstance().findNext(ultimoContratoCargado);
            if (siguienteContrato != null) {
                cargarContrato(siguienteContrato);
                ultimoContratoCargado = siguienteContrato;
            } 
  
        }
    }
    public void cargarAnterior() {
    	if (ultimoContratoCargado == null) {
            cargarPrimero();
        } else {
            // Obtenemos el siguiente contrato después del último cargado
            Contrato siguienteContrato = (Contrato) ControladorContratoJPA.getInstance().findPrevious(ultimoContratoCargado);
            if (siguienteContrato != null) {
                cargarContrato(siguienteContrato);
                ultimoContratoCargado = siguienteContrato;
            } 
  
        }
    }
	


}
