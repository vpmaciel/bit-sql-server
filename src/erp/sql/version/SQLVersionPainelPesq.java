package erp.sql.version;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import erp.arquitetura.MultiLineCellRenderer;

@SuppressWarnings("serial")
public class SQLVersionPainelPesq extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public SQLVersionPainelPesq() {

	setLayout(new BorderLayout());

	String[] colunas = { "VERSION" };

	model = new DefaultTableModel(colunas, 0) {
	    public boolean isCellEditable(int row, int column) {
		return false;
	    }
	};

	table = new JTable(model);
	table.getColumnModel().getColumn(0)
	     .setCellRenderer(new MultiLineCellRenderer());

	add(new JScrollPane(table), BorderLayout.CENTER);

	iniciarAtualizacaoAutomatica();
    }

    public void carregarDados(Collection<Object[]> dados) {
	if (dados == null) {
	    return;
	}

	model.setRowCount(0);

	for (Object[] row : dados) {

	    Object nome = row[0];	    

	    model.addRow(new Object[] { nome });
	}
    }

    private void iniciarAtualizacaoAutomatica() {

	Timer timer = new Timer(60000, e -> {

	    try {

		Collection<Object[]> dados = SQLVersionImp.pesquisar();

		carregarDados(dados);

	    } catch (Exception ex) {
		ex.printStackTrace();
	    }

	});

	timer.start();
    }

    public void atualizar() {

	try {

	    Collection<Object[]> dados = SQLVersionImp.pesquisar();

	    carregarDados(dados);

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}