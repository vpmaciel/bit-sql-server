package erp.database.state;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class DBStatePainelPesq extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public DBStatePainelPesq() {

	setLayout(new BorderLayout());

	String[] colunas = { "DATABASE", "STATE" };

	model = new DefaultTableModel(colunas, 0) {
	    public boolean isCellEditable(int row, int column) {
		return false;
	    }
	};

	table = new JTable(model);

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
	    Object estado = row[1];

	    model.addRow(new Object[] { nome, estado });
	}
    }

    private void iniciarAtualizacaoAutomatica() {

	Timer timer = new Timer(60000, e -> {

	    try {

		Collection<Object[]> dados = DBStateImp.pesquisar();

		carregarDados(dados);

	    } catch (Exception ex) {
		ex.printStackTrace();
	    }

	});

	timer.start();
    }

    public void atualizar() {

	try {

	    Collection<Object[]> dados = DBStateImp.pesquisar();

	    carregarDados(dados);

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}