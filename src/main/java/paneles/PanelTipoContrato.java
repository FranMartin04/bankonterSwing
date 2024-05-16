package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class PanelTipoContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
    private DefaultTableModel tableModel;


	public PanelTipoContrato() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTipoContrato = new JLabel("Tipo Contrato");
		GridBagConstraints gbc_lblTipoContrato = new GridBagConstraints();
		gbc_lblTipoContrato.gridwidth = 2;
		gbc_lblTipoContrato.insets = new Insets(0, 0, 5, 0);
		gbc_lblTipoContrato.gridx = 0;
		gbc_lblTipoContrato.gridy = 0;
		add(lblTipoContrato, gbc_lblTipoContrato);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		table  = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(DatosEnTabla.getTitulosColumnas());

        // Crear la tabla con el modelo
        table = new JTable(tableModel);

	}

}
