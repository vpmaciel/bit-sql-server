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
    private JMenuItem menuItemArquivoSair;
    private JMenuItem menuItemControleCliente;
    private JMenuItem menuItemControleVeiculo;
    private JMenuItem menuItemControleServico;
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

    public JMenuItem getMenuItemArquivoSair() {
	return menuItemArquivoSair;
    }

    public JMenuItem getMenuItemControleCliente() {
	return menuItemControleCliente;
    }

    public JMenuItem getMenuItemControlePedidoPlaca() {
	return menuItemControleDBState;
    }

    public JMenuItem getMenuItemControleServico() {
	return menuItemControleServico;
    }

    public JMenuItem getMenuItemControleVeiculo() {
	return menuItemControleVeiculo;
    }

    public void iniciarController() {
	mainController = MainController.getInstance(this);
	addWindowListener(mainController.new FrameGerenteEventos());
	menuItemArquivoSair.addActionListener(mainController.new MenuGerenteEventos());
	menuItemArquivoConectar.addActionListener(mainController.new MenuGerenteEventos());
	menuItemControleVeiculo.addActionListener(mainController.new MenuGerenteEventos());
	menuItemControleDBState.addActionListener(mainController.new MenuGerenteEventos());
	menuItemControleServico.addActionListener(mainController.new MenuGerenteEventos());
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

	menuItemArquivoSair = new JMenuItem("Exit");

	menuArquivo.add(menuItemArquivoSair);

	menuBar.add(menuArquivo);

	menuControle = new JMenu("Control");
	menuControle.setMnemonic('C');

	menuItemControleDBState = new JMenuItem("DB State");
	menuControle.add(menuItemControleDBState);

	menuItemControleServico = new JMenuItem("Serviço");
	menuControle.add(menuItemControleServico);

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