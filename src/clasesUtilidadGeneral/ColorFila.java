package clasesUtilidadGeneral;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Hasper Franco
 * @author Nahuel Hernandez
 */
public class ColorFila extends DefaultTableCellRenderer {

    Color foreground;
    Color rojoClaro = new Color(237, 199, 199);
    Color verdeClaro = new Color(219, 255, 230);

    public ColorFila(Color foreground) {
        this.foreground = foreground;
    }

    /**
     * Se utiliza para cambiar el color a una fila con el valor dado
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //la columna con el valor de referencia
        try {

            String valor = table.getValueAt(row, 1).toString();
            char signo = valor.charAt(0);
            String s = Character.toString(signo);

            if (s.equals("-")) {
                setBackground(rojoClaro);
                setForeground(foreground);
            } else {
                setBackground(verdeClaro);
                setForeground(foreground);
            }

        } catch (NullPointerException e) {
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
