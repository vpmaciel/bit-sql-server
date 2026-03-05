package erp.arquitetura;

import java.io.File;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class NativeLoader {

    public static void carregarDLL(String nomeDll) {

        try {

            File jarDir = new File(
                    NativeLoader.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
            ).getParentFile();

            File dll = new File(jarDir, nomeDll);

            System.load(dll.getAbsolutePath());

            System.out.println("DLL loaded: " + dll.getAbsolutePath());

        } catch (URISyntaxException e) {
            System.out.println("DLL not found: " + nomeDll);
            JOptionPane.showMessageDialog(null, "DLL not found: " + nomeDll);
            e.printStackTrace();
            
        }
    }
}