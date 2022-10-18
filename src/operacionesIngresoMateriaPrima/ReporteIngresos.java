package operacionesIngresoMateriaPrima;

import calsesPadre.Consultas;
import clasesUtilidadGeneral.OperacionesUtiles;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import ds.desktop.notify.DesktopNotify;
import entidades.Gasto;
import entidades.IngresoMateriaPrima;
import entidades.PrecioProducto;
import entidades.Producto_Venta;
import formularios.FormularioReporteIngresoMateriaPrima;
import java.awt.Desktop;
import java.awt.Dialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class ReporteIngresos extends Consultas {

    private FormularioReporteIngresoMateriaPrima formularioReporteIngresoMateriaPrima;
    private String fechaIicio;
    private String fechaFin;
    private List lista;
    private static final Font titulofuente = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
    private static final Font datosfuente = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);

    public FormularioReporteIngresoMateriaPrima getFormularioReporteIngresoMateriaPrima() {
        return formularioReporteIngresoMateriaPrima;
    }

    public void setFormularioReporteIngresoMateriaPrima(FormularioReporteIngresoMateriaPrima formularioReporteIngresoMateriaPrima) {
        this.formularioReporteIngresoMateriaPrima = formularioReporteIngresoMateriaPrima;
    }

    public void ejecutarBusqueda() {
        obtenerFechas();
        consultaIngresos();
        rellenarTabla();
    }

    private void obtenerFechas() {
        try {
            fechaIicio = (String) new OperacionesUtiles().formatoFechaSinHoraYearFirst(formularioReporteIngresoMateriaPrima.getFechaInicio().getDatoFecha());
            fechaFin = (String) new OperacionesUtiles().formatoFechaSinHoraYearFirst(formularioReporteIngresoMateriaPrima.getFechaFin().getDatoFecha());
        } catch (NullPointerException e) {
            DesktopNotify.showDesktopMessage("informacion ", "   Debe ingresar una fecha limite  inicio y una fecha limite fin", DesktopNotify.INFORMATION, 5000);
        }
    }

    private void consultaIngresos() {
        setConsultaList("from IngresoMateriaPrima where fecha BETWEEN '" + fechaIicio + "' AND '" + fechaFin + "'");
        obtenerListaConsulta();
    }

    private void rellenarTabla() {
        Double resultado = 0.0;
        DefaultTableModel tablaIngresos = (DefaultTableModel) formularioReporteIngresoMateriaPrima.getTablaGrafica().getModel();
        lista = this.getListaResultados();
        new OperacionesUtiles().removerFilas(tablaIngresos);

        for (Object o : lista) {
            IngresoMateriaPrima i = (IngresoMateriaPrima) o;
            if (i.getCodigoEstado().getIdEstado().equals(1)) {
                Vector<Object> fila = new Vector<>();
                fila.add(i.getCodigoMateriaPrima().getNombre());
                fila.add(i.getTotalEnvases());
                fila.add(i.getUdPorEnvase());
                fila.add(i.getPrecioTotal());
                fila.add(new OperacionesUtiles().formatoFechaSinHora(i.getFecha()));
                resultado += i.getPrecioTotal();
                tablaIngresos.addRow(fila);
            }
        }
        formularioReporteIngresoMateriaPrima.getLblImporteTotal().setText(resultado.toString());
    }

    public void ejecutarGenerarReportes() throws FileNotFoundException, DocumentException {
        generarReportePDF5(new File("reportes//IngresosMateriaPrima//IngresosMateriaPrima " + fechaIicio + " " + fechaFin + ".pdf"));
    }

    public void generarReportePDF5(File pdfNewFile) {
        try {

            //al añadir un new Chapter se cambia a otra pagina
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            document.open();
            //capitulo
            // Chapter chapterOne = new Chapter(0);
            Paragraph texto = new Paragraph();
            texto.setFont(titulofuente);
            texto.add("Reporte Ingresos Materia Prima");

            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            texto.add(dottedline);
            texto.setFont(datosfuente);
            texto.add("\n");
            texto.add("Fecha en la que se genero este reporte: " + OperacionesUtiles.formatoFechaSinHora(new Date()));
            texto.add("\n");
            String fechaIicioPdf = (String) new OperacionesUtiles().formatoFechaSinHora(formularioReporteIngresoMateriaPrima.getFechaInicio().getDatoFecha());
            String fechaFinPdf = (String) new OperacionesUtiles().formatoFechaSinHora(formularioReporteIngresoMateriaPrima.getFechaFin().getDatoFecha());

            texto.add(new Paragraph("Desde: " + fechaIicioPdf + " Hasta: " + fechaFinPdf));

            texto.add(new Paragraph("\n"));

            Double resultado = 0.0;

            PdfPTable table = new PdfPTable(5);
            PdfPCell columnHeader;

            columnHeader = new PdfPCell(new Phrase("Materia prima"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total envases"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Uds por envase"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total gastado"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Fecha"));
            table.addCell(columnHeader);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.setHeaderRows(1);

            for (Object o : lista) {
                IngresoMateriaPrima i = (IngresoMateriaPrima) o;
                if (i.getCodigoEstado().getIdEstado().equals(1)) {
                    table.addCell(i.getCodigoMateriaPrima().getNombre());
                    table.addCell(i.getTotalEnvases().toString());
                    table.addCell(i.getUdPorEnvase().toString());
                    table.addCell("$ " + i.getPrecioTotal().toString());
                    resultado += i.getPrecioTotal();
                    table.addCell((String) new OperacionesUtiles().formatoFechaSinHora(i.getFecha()));
                }
            }

            texto.add(table);
            texto.add(new Paragraph("\n"));
            texto.add("Importe Total: " + resultado);
            document.add(texto);
            document.close();

            DesktopNotify.showDesktopMessage("exito ", "   REPORTE GENERADO\n   CON EXITO", DesktopNotify.SUCCESS, 7000);

            if (this.formularioReporteIngresoMateriaPrima.getRadBtnAbrirDocumento().isSelected()) {
                OperacionesUtiles.abrirArchivo(pdfNewFile.toString());
            }
            if (this.formularioReporteIngresoMateriaPrima.getRadBtnImprimir().isSelected()) {
                try {
                    Desktop.getDesktop().print(pdfNewFile);
                } catch (IOException ex) {
                    Logger.getLogger(ReporteIngresos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException | DocumentException | NullPointerException e) {
            DesktopNotify.showDesktopMessage("error ", "    NO SE PUDO GENERAR\n    EL REPORTE", DesktopNotify.ERROR, 7000);
        }
    }
}
