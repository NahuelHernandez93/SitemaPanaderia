package operacionesCaja;

import clasesUtilidadGeneral.OperacionesUtiles;
import formularios.FormularioRegistrarCorte;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author Hasper Franco
 */
public class OperacionesRegistrarCorte {

    public void calcularbalance(FormularioRegistrarCorte formularioRegistrarCorte) {
        try {
            double ingresos = Double.valueOf(formularioRegistrarCorte.getTxtTotalVentas().getText());
            double egresos = Double.valueOf(formularioRegistrarCorte.getTxtTotalGastos().getText());
            formularioRegistrarCorte.getTxtBalance().setText(String.valueOf(ingresos - egresos));
        } catch (java.lang.NumberFormatException e) {
        }

    }
    
        /**
     * Suma todos los registros de la tabla ventas y guarda el resultado en el
     * label total eltradas.
     *
     * @param f
     */
    public void calcularTotalVentas(FormularioRegistrarCorte formularioRegistrarCorte) {
        Double suma = 0.00;
        try {
            for (int i = 0; i < formularioRegistrarCorte.getTablaEntradas().getRowCount(); i++) {
                suma = suma + (Double.valueOf(formularioRegistrarCorte.getTablaEntradas().getValueAt(i, 2).toString()));
            }
            formularioRegistrarCorte.getTxtTotalVentas().setText(new OperacionesUtiles().formatoDouble(suma));
        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular total entradas");

        }

    }
    
    
        /**
     * Suma todos los registros de la tabla gastos y guarda el resultado en el
     * label total salidas.
     *
     * @param f
     */
    public void calcularTotalGastos(FormularioRegistrarCorte formularioRegistrarCorte) {
        Double suma = 0.0;
        try {
            for (int i = 0; i < formularioRegistrarCorte.getTablaSlidas().getRowCount(); i++) {
                suma = suma + (Double.valueOf(formularioRegistrarCorte.getTablaSlidas().getValueAt(i, 2).toString()));
            }
            formularioRegistrarCorte.getTxtTotalGastos().setText(new OperacionesUtiles().formatoDouble(suma));
        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular total salidas");
        }

    }
    
        /**
     * Calcula el balance de el corte diario restando el total de entras de el
     * total de salidas y guarda el resultado en el sabel balance.
     *
     * @param f
     */
    public void calcularBalance(FormularioRegistrarCorte formularioRegistrarCortef) {
        Double suma = 0.0;
        Double entradas = 0.0;
        Double salidas = 0.0;
        try {
            entradas = Double.valueOf(formularioRegistrarCortef.getTxtTotalVentas().getText());
            salidas = Double.valueOf(formularioRegistrarCortef.getTxtTotalGastos().getText());
            suma = entradas + (-salidas);
            
            formularioRegistrarCortef.getTxtBalance().setText(new OperacionesUtiles().formatoDouble(suma));

        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular balance");
        }

    }

}
