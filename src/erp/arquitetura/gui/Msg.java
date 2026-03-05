package erp.arquitetura.gui;

import javax.swing.JOptionPane;

import erp.sistema.main.MainJan;
import erp.sistema.main.SobrePainel;

public final class Msg {

    public static void avisoFecharSistema() {
	JOptionPane.showMessageDialog(null, "System will be closed !", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void avisoCampoObrigatorio(Object campo) {
	JOptionPane.showMessageDialog(null, "You need to fill field " + campo.toString().toUpperCase(), "Information",
		JOptionPane.WARNING_MESSAGE);
    }

    public static void ajuda() {
	JOptionPane.showMessageDialog(MainJan.getFrameMain(), new SobrePainel(), "About system",
		JOptionPane.INFORMATION_MESSAGE);
    }

    public static int confirmarFecharJanela() {

	return JOptionPane.showConfirmDialog(null, "Do you want to close the window ?", "Confirm",
		JOptionPane.YES_NO_OPTION);
    }

    public static int confirmarSairDoSistema() {

	return JOptionPane.showConfirmDialog(null, "Do you want to exit the sistem ?", "Confirm",
		JOptionPane.YES_NO_OPTION);
    }

    public static int confirmarConectarServidor() {

	return JOptionPane.showConfirmDialog(null, "Connect to Server ?", "Confirm", JOptionPane.YES_NO_OPTION);
    }

    public static void erroGeral() {
	JOptionPane.showMessageDialog(null, "Found a error !", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void erroLookAndFeel() {
	JOptionPane.showMessageDialog(null, "Look and Feel error !", "Erro",
		JOptionPane.ERROR_MESSAGE);
    }

    public static void erroConectarServidor() {
	JOptionPane.showMessageDialog(null, "Error connect server !", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void sucessoConectarServidor() {
	JOptionPane.showMessageDialog(null, "Connection established successfully !", "Informação",
		JOptionPane.INFORMATION_MESSAGE);
    }
}
