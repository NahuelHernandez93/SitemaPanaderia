package operacionesCaja;

import clasesUtilidadGeneral.OperacionesUtiles;
import formularios.FormularioEditarCorte;

/**
 * @author Hasper Franco
 */
public class OperacionesEditarCorte {

    public static void calcularBalance(FormularioEditarCorte formularioEditarCorte) {
        Double balance = 0.00;
        Double gastos = 0.00;
        Double ventas = 0.00;

        try {
            ventas = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioEditarCorte.getTxtTotalIngresos().getText())));
            gastos = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioEditarCorte.getTxtTotalEgresos().getText())));
            balance = (ventas) - (gastos);
            formularioEditarCorte.getTxtBalance().setText(String.valueOf( OperacionesUtiles.formatoDouble(balance)));
        } catch (java.lang.NumberFormatException e) {
        }

    }

}
