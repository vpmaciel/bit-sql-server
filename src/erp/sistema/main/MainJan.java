package erp.sistema.main;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import erp.arquitetura.Sis;
import erp.arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public class MainJan extends JFrame {

    private static MainController mainController;

    public static MainJan getFrameMain() {
	return MainController.getMainJan();
    }

    public static MainController getMainControl() {
	return mainController;
    }

    static void mostrarFrame(JFrame frame) {
	MainController.mostrarFrame(frame);
    }

    private JMenu menuAjuda;
    private JMenu menuArquivo;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuControle;
    private JMenuItem menuItemAjudaSobreSistema;
    private JMenuItem menuItemArquivoConectar;
    private JMenuItem menuItemControleCliente;
    private JMenuItem menuItemControleVeiculo;
    private JMenuItem menuItemControlesSQLVersion;
    private JMenuItem menuItemControleDBState;

    public MainJan() {
	iniciarGui();
	iniciarController();
    }

    public JMenu getMenuAjuda() {
	return menuAjuda;
    }

    public JMenu getMenuArquivo() {
	return menuArquivo;
    }

    public JMenu getMenuControle() {
	return menuControle;
    }

    public JMenuItem getMenuItemAjudaSobreSistema() {
	return menuItemAjudaSobreSistema;
    }

    public Object getMenuItemArquivoConectar() {
	return menuItemArquivoConectar;
    }

    public JMenuItem getMenuItemControleCliente() {
	return menuItemControleCliente;
    }

    public JMenuItem getMenuItemControleDBState() {
	return menuItemControleDBState;
    }

    public JMenuItem getMenuItemControleSQLVersion() {
	return menuItemControlesSQLVersion;
    }

    public JMenuItem getMenuItemControleVeiculo() {
	return menuItemControleVeiculo;
    }

    public void iniciarController() {
	mainController = MainController.getInstance(this);
	addWindowListener(mainController.new FrameGerenteEventos());
	menuItemArquivoConectar.addActionListener(mainController.new MenuGerenteEventos());
	menuItemControleVeiculo.addActionListener(mainController.new MenuGerenteEventos());
	menuItemControleDBState.addActionListener(mainController.new MenuGerenteEventos());
	menuItemControlesSQLVersion.addActionListener(mainController.new MenuGerenteEventos());
	menuItemControleCliente.addActionListener(mainController.new MenuGerenteEventos());
	menuItemAjudaSobreSistema.addActionListener(mainController.new MenuGerenteEventos());
    }

    private void iniciarGui() {
	setTitle(Sis.getNomeSistema() + " - " + "Main");
	setIconImage(Imagem.getLogoTipoImage());
	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	setMinimumSize(Sis.getTamanhoJanela());
	setSize(Sis.getTamanhoJanela());
	setPreferredSize(Sis.getTamanhoJanela());
	setMaximumSize(Sis.getTamanhoJanela());

	menuArquivo = new JMenu("File");
	menuArquivo.setMnemonic('A');

	menuItemArquivoConectar = new JMenuItem("Connect Server");

	menuArquivo.add(menuItemArquivoConectar);

	menuBar.add(menuArquivo);

	menuControle = new JMenu("Control");
	menuControle.setMnemonic('C');

	menuItemControleDBState = new JMenuItem("DB State");
	menuControle.add(menuItemControleDBState);

	menuItemControlesSQLVersion = new JMenuItem("SQL Version");
	menuControle.add(menuItemControlesSQLVersion);

	menuItemControleVeiculo = new JMenuItem("Veículo");
	menuControle.add(menuItemControleVeiculo);

	menuItemControleCliente = new JMenuItem("Cliente");
	menuControle.add(menuItemControleCliente);

	menuBar.add(menuControle);

	menuAjuda = new JMenu("Help");
	menuAjuda.setMnemonic('H');

	menuItemAjudaSobreSistema = new JMenuItem("About Bit - SQL Server");
	menuAjuda.add(menuItemAjudaSobreSistema);

	menuBar.add(menuAjuda);

	setJMenuBar(menuBar);
    }
}