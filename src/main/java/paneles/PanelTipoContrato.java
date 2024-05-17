package paneles;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PanelTipoContrato extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private DefaultTableModel tableModel;
    private Object datosEnTabla[][] = DatosEnTabla.getDatosDeTabla();
    private String titulosEnTabla[] = DatosEnTabla.getTitulosColumnas();
    private DefaultTableModel dtm = null;
    private TableRowSorter<DefaultTableModel> rowSorter;

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

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String text = textField.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 1;
        add(btnNewButton, gbc_btnNewButton);

        dtm = getDefaultTableModelNoEditable();
        JTable table = new JTable(dtm);
        rowSorter = new TableRowSorter<>(dtm); // Inicialización del rowSorter
        table.setRowSorter(rowSorter);
        JScrollPane scrollPane = new JScrollPane(table);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridwidth = 2;
        gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 2;
        add(scrollPane, gbc_scrollPane);
    }

    private DefaultTableModel getDefaultTableModelNoEditable() {
        DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1;
            }
        };
        return dtm;
    }
}
