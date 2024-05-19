package paneles;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import controllers.ControladorUsuarioJPA;
import entities.Usuario;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelSeleccionUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfTextoToFilter;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnUsername;
	private JRadioButton rdbtnEmail;
	private JCheckBox chckCaseSensitive;
	private Usuario user;
	private PanelPrincipal panelGestionContrato;
	private JList<Usuario> jList;

	/**
	 * Create the panel.
	 */
	public PanelSeleccionUsuario(Usuario user, PanelPrincipal panelGestionContrato) {
		this.user = user;
		this.panelGestionContrato = panelGestionContrato;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Selección de usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Texto de búsqueda:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfTextoToFilter = new JTextField();
		GridBagConstraints gbc_jtfTextoToFilter = new GridBagConstraints();
		gbc_jtfTextoToFilter.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTextoToFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTextoToFilter.gridx = 1;
		gbc_jtfTextoToFilter.gridy = 1;
		add(jtfTextoToFilter, gbc_jtfTextoToFilter);
		jtfTextoToFilter.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rdbtnUsername = new JRadioButton("Nombre de usuario");
		panel.add(rdbtnUsername);
		
		rdbtnEmail = new JRadioButton("Email");
		panel.add(rdbtnEmail);
		
		chckCaseSensitive = new JCheckBox("Case-sensitive");
		chckCaseSensitive.setSelected(true);
		GridBagConstraints gbc_chckCaseSensitive = new GridBagConstraints();
		gbc_chckCaseSensitive.insets = new Insets(0, 0, 5, 0);
		gbc_chckCaseSensitive.gridwidth = 2;
		gbc_chckCaseSensitive.gridx = 0;
		gbc_chckCaseSensitive.gridy = 3;
		add(chckCaseSensitive, gbc_chckCaseSensitive);
		
		JButton btnFilter = new JButton("Buscar usuarios");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//findUsers();
			}
		});
		GridBagConstraints gbc_btnFilter = new GridBagConstraints();
		gbc_btnFilter.insets = new Insets(0, 0, 5, 0);
		gbc_btnFilter.anchor = GridBagConstraints.EAST;
		gbc_btnFilter.gridx = 1;
		gbc_btnFilter.gridy = 4;
		add(btnFilter, gbc_btnFilter);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		JButton btnSelectUser = new JButton("Seleccionar usuario");
		btnSelectUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectUser();
			}
		});
		GridBagConstraints gbc_btnSelectUser = new GridBagConstraints();
		gbc_btnSelectUser.gridwidth = 2;
		gbc_btnSelectUser.gridx = 0;
		gbc_btnSelectUser.gridy = 6;
		add(btnSelectUser, gbc_btnSelectUser);
		
		// Agrego los comportamientos específicos de cada elemento
		addControlCustomizableBehaviours();

		// Realizo una primera búsqueda, para cargar los usuarios
		//findUsers();
	}
	
	
	/**
	 * 
	 */
	private void addControlCustomizableBehaviours() {
		// Comportamiento excluyente en los JRadioButton
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnUsername);
		bg.add(rdbtnEmail);
		rdbtnUsername.setSelected(true);		
	}
	
	
	/**
	 * 
	 */
//	private void findUsers() {
//		// Determino si se desea buscar por nombre de usuario o email
//		String tableColumn = (rdbtnUsername.isSelected())? "nombreUsuario" : "email";
//		
//		List<Usuario> filteredUsers = (List<Usuario>) ControladorUsuarioJPA.getInstance().findByLikeOperator(tableColumn, 
//				this.jtfTextoToFilter.getText(), this.chckCaseSensitive.isSelected());
//		
//		// Con los usuarios listados, construyo un JList, junto a su DefaultListModel
//		DefaultListModel<Usuario> dlm = new DefaultListModel<Usuario>();
//		dlm.addAll(filteredUsers);
//		
//		jList = new JList<Usuario>(dlm);
//		
//		// Tamaño mínimo de la JList
//		jList.setMinimumSize(new Dimension(0, 200));
//		jList.setPreferredSize(new Dimension(0, 200));
//		
//		this.scrollPane.setViewportView(jList);
//	}

	
	/**
	 * 
	 */
	private void selectUser() {
		if (this.jList != null) {
			this.panelGestionContrato.setUsuario(jList.getSelectedValue());
			GuiUtils.closeDialogFromInnerJPanel(this);
		}
	}
}
