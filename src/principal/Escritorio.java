package principal;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author
 * //<a href="https://www.freepik.com/free-photos-vectors/background">Background
 * vector created by freepik - www.freepik.com</a>
 */
public class Escritorio extends JDesktopPane {

    private boolean minimiza = false;
    public boolean cerra = false;
    Image IMG = new ImageIcon(getClass().getResource("/imagenes/fondoEs.jpg")).getImage();

    @Override
    public void paintChildren(Graphics g) {
        g.drawImage(IMG, 0, 0, getWidth(), getHeight(), this);
        super.paintChildren(g);
    }

    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = this.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
                cerra = false;
            }
            i++;
        }
        return cerrado;
    }

}
