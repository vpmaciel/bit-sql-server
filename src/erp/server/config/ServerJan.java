package erp.server.config;

import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import erp.arquitetura.Sis;
import erp.arquitetura.gui.ConfiguracaoGui;
import erp.arquitetura.gui.FocoEvento;
import erp.arquitetura.gui.Gui;
import erp.arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ServerJan extends JFrame implements Gui {

    private ConfiguracaoGui configuracaoGui;
    private JTabbedPane tabbedPane;
    private ServerControl serverControl;
    private ServerPainelCad serverPainelCad;

    public ServerJan() {
	iniciarLayout();
	iniciarGui();
	iniciarFocoControlador();
	iniciarGuiControlador();
	iniciarControlador();
    }

    @Override
    public void atualizarTable() {

    }

    public void desabilitarGui() {

    }

    public ServerControl getUsuarioCont() {
	return serverControl;
    }

    @Override
    public ConfiguracaoGui getConfiguracaoGui() {
	return configuracaoGui;
    }

    public ServerPainelCad getServerPainelCad() {
	return serverPainelCad;
    }

    public ServerPainelCad getPanelUsuarioCad() {
	return serverPainelCad;
    }

    public JTabbedPane getTabbedPane() {
	return tabbedPane;
    }

    @Override
    public void iniciarControlador() {
	setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	serverControl = new ServerControl();
	addWindowListener(serverControl.new Frame());
	serverPainelCad.getTB().getConectarSOBtn().addActionListener(serverControl.new ConectaUserSO());
	serverPainelCad.getTB().getConectarUserBtn().addActionListener(serverControl.new ConectaUserSQL());
    }

    @Override
    public void iniciarFocoControlador() {
	new FocoEvento(this);
    }

    @Override
    public void iniciarGui() {
	setTitle(Sis.getNomeSistema() + " - " + "Server");
	setIconImage(Imagem.getLogoTipoImage());
	tabbedPane = new JTabbedPane();
	serverPainelCad = new ServerPainelCad();

	final JScrollPane scrollPane = new JScrollPane(serverPainelCad);

	KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
		new PropertyChangeListener() {

		    @Override
		    public void propertyChange(PropertyChangeEvent evt) {
			if (!(evt.getNewValue() instanceof JComponent)) {
			    return;
			}
			JComponent focused = (JComponent) evt.getNewValue();
			if (serverPainelCad.isAncestorOf(focused)) {
			    serverPainelCad.scrollRectToVisible(focused.getBounds());
			}
		    }
		});
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	tabbedPane.addTab("Configuration", scrollPane);

	add(tabbedPane);
	setContentPane(tabbedPane);
	pack();

    }

    @Override
    public void iniciarGuiControlador() {
	configuracaoGui = new ConfiguracaoGui(this);
    }

    @Override
    public void iniciarLayout() {
	setLayout(new FlowLayout(FlowLayout.CENTER));
	setPreferredSize(Sis.getTamanhoJanela());
	setMinimumSize(Sis.getTamanhoJanela());
	setSize(Sis.getTamanhoJanela());
	setMaximumSize(Sis.getTamanhoJanela());
    }

    @Override
    public void iniciarTabela() {

    }

    @Override
    public void limparGui() {
	serverPainelCad.limparGui();
    }

    @Override
    public void reiniciarGui() {
	serverPainelCad.reiniciarGui();
    }
}
