package erp.server.config;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import erp.arquitetura.Sis;
import erp.arquitetura.gui.ConfiguracaoGui;
import erp.arquitetura.gui.FocoEvento;
import erp.arquitetura.gui.Gui;

@SuppressWarnings("serial")
public final class ServerPainelCad extends JPanel implements Gui {

    private ConfiguracaoGui configuracaoGui;
    private JTextField fieldDatabase;
    private JTextField fieldUsuario;
    private JTextField fieldSenha;
    private JTextField fieldServidor;
    private JTextField fieldPorta;
    private ToolBar toolBar;
    private ServerControl serverControl;

    public ServerPainelCad() {
	iniciarLayout();
	iniciarGui();
	iniciarFocoControlador();
	iniciarGuiControlador();
    }

    @Override
    public void atualizarTable() {
    }

    @Override
    public ConfiguracaoGui getConfiguracaoGui() {
	return configuracaoGui;
    }

    public JTextField getGuiDatabase() {
	return fieldDatabase;
    }

    public JTextField getGuiUsuario() {
	return fieldUsuario;
    }

    public JTextField getGuiSenha() {
	return fieldSenha;
    }

    public JTextField getGuiServidor() {
	return fieldServidor;
    }

    public JTextField getGuiPorta() {
	return fieldPorta;
    }

    public ToolBar getTB() {
	return toolBar;
    }

    public ServerControl getUsuarioCont() {
	return serverControl;
    }

    @Override
    public void iniciarControlador() {
    }

    @Override
    public void iniciarFocoControlador() {
	new FocoEvento(this);
    }

    @Override
    public void iniciarGui() {
	toolBar = new ToolBar();

	add(toolBar);

	add(new JLabel("SERVER"));

	fieldServidor = new JTextField("localhost");
	add(fieldServidor);

	add(new JLabel("PORT NUMBER"));

	fieldPorta = new JTextField("1433");
	add(fieldPorta);

	add(new JLabel("DATABASE"));

	fieldDatabase = new JTextField("master");
	add(fieldDatabase);

	add(new JLabel("USER"));

	fieldUsuario = new JTextField();
	add(fieldUsuario);

	add(new JLabel("PASSWORD"));

	fieldSenha = new JTextField();
	add(fieldSenha);
    }

    @Override
    public void iniciarGuiControlador() {
	configuracaoGui = new ConfiguracaoGui(this);
    }

    @Override
    public void iniciarLayout() {
	setBorder(Sis.getBordaPainel());
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void iniciarTabela() {
    }

    @Override
    public void limparGui() {
	configuracaoGui.limparGui();
    }

    @Override
    public void reiniciarGui() {
    }
}
