package erp.arquitetura;

import java.awt.Cursor;
import java.awt.Dimension;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Sis {
    private static Dimension tamanhoTela = new Dimension(900, 670);    

    public static Border getBordaPainel() {
	Border externa = BorderFactory.createEtchedBorder();
	Border interna = BorderFactory.createEmptyBorder(15, 15, 15, 15);
	return BorderFactory.createCompoundBorder(externa, interna);
    }

    public static String getNomeHosat() {
	try {
	    return InetAddress.getLocalHost().getCanonicalHostName();
	} catch (UnknownHostException e) {
	    return null;
	}
    }

    public static String getNomeSistema() {
	return "Bit - SQL Server 1.0";
    }

    public static Cursor getNovaJanelaCursor() {
	return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    }

    public static Dimension getTamanhoJanela() {
	return tamanhoTela;
    }
}
