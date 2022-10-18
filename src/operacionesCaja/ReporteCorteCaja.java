package operacionesCaja;

import operacionesGasto.*;
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
import entidades.CorteCaja;
import entidades.Gasto;
import formularios.FormularioReporteCorteCaja;
import formularios.FormularioReporteGastos;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import operacionesIngresoMateriaPrima.ReporteIngresos;

/**
 * @author Hasper Franco
 */
public class ReporteCorteCaja extends Consultas {

    private FormularioReporteCorteCaja formularioReporteCorteCaja;
    private String fechaIicio;
    private String fechaFin;
    private List lista;
    private Font titulofuente = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
    private Font datosfuente = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);

    public FormularioReporteCorteCaja getFormularioReporteCorteCaja() {
        return formularioReporteCorteCaja;
    }

    public void setFormularioReporteCorteCaja(FormularioReporteCorteCaja formularioReporteCorteCaja) {
        this.formularioReporteCorteCaja = formularioReporteCorteCaja;
    }



    public void ejecutarBusqueda() {
        obtenerFechas();
        consultaIngresos();
        rellenarTabla();
    }

    private void obtenerFechas() {
        try {
            fechaIicio = (String) new OperacionesUtiles().formatoFechaSinHoraYearFirst(formularioReporteCorteCaja.getFechaInicio().getDatoFecha());
            fechaFin = (String) new OperacionesUtiles().formatoFechaSinHoraYearFirst(formularioReporteCorteCaja.getFechaFin().getDatoFecha());
        } catch (NullPointerException e) {
            DesktopNotify.showDesktopMessage("informacion ", "   Debe ingresar una fecha limite  inicio y una fecha limite fin", DesktopNotify.INFORMATION, 5000);
        }

    }

    private void consultaIngresos() {
        setConsultaList("from CorteCaja where fecha BETWEEN '" + fechaIicio + "' AND '" + fechaFin + "'");
        obtenerListaConsulta();
    }

    private void rellenarTabla() {
        Double resultado = 0.0;
        DefaultTableModel tablaIngresos = (DefaultTableModel) formularioReporteCorteCaja.getTablaGrafica().getModel();
        lista = this.getListaResultados();
        new OperacionesUtiles().removerFilas(tablaIngresos);

        for (Object o : lista) {
            CorteCaja c = (CorteCaja) o;
            if (c.getCodigoEstado().getIdEstado().equals(1)) {
                Vector<Object> fila = new Vector<>();
                fila.add(c.getTotalIngresos());
                fila.add(c.getTotalEgresos());
                fila.add(c.getBalance());
                fila.add(new OperacionesUtiles().formatoFechaSinHora(c.getFecha()));
                resultado += c.getBalance();
                tablaIngresos.addRow(fila);
            }
        }
        formularioReporteCorteCaja.getLblImporteTotal().setText(resultado.toString());
    }


    public void ejecutarGenerarReportes() throws FileNotFoundException, DocumentException {
        generarReportePDF5(new File("reportes//CorteCaja//CorteCaja " + fechaIicio + " " + fechaFin + ".pdf"));
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
            texto.add("Reporte Cortes de Caja");

            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            texto.add(dottedline);
            texto.setFont(datosfuente);
            texto.add("\n");
           texto.add("Fecha en la que se genero este reporte: " + OperacionesUtiles.formatoFechaSinHora(new Date()));
            texto.add("\n");
            String fechaIicioPdf = (String) new OperacionesUtiles().formatoFechaSinHora(formularioReporteCorteCaja.getFechaInicio().getDatoFecha());
            String fechaFinPdf = (String) new OperacionesUtiles().formatoFechaSinHora(formularioReporteCorteCaja.getFechaFin().getDatoFecha());

            texto.add(new Paragraph("Desde: " + fechaIicioPdf + " Hasta: " + fechaFinPdf));

            texto.add(new Paragraph("\n"));

            Double resultado = 0.0;

            PdfPTable table = new PdfPTable(4);
            PdfPCell columnHeader;

            columnHeader = new PdfPCell(new Phrase("Toatal Ventas"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total Gastos"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Balance"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Fecha"));
            table.addCell(columnHeader);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.setHeaderRows(1);

            for (Object o : lista) {
                CorteCaja c = (CorteCaja) o;
                if (c.getCodigoEstado().getIdEstado().equals(1)) {
                    table.addCell("$ " +c.getTotalIngresos().toString());
                    table.addCell("$ " + c.getTotalEgresos());
                    table.addCell("$ " + c.getBalance());
                    resultado += c.getBalance();
                    table.addCell((String) new OperacionesUtiles().formatoFechaSinHora(c.getFecha()));
                }
            }

            texto.add(table);
            texto.add(new Paragraph("\n"));
            texto.add("Balance final: " + resultado);
            document.add(texto);
            document.close();
            DesktopNotify.showDesktopMessage("exito ", "   REPORTE GENERADO\n   CON EXITO", DesktopNotify.SUCCESS, 7000);

            if (this.formularioReporteCorteCaja.getRadBtnAbrirDocumento().isSelected()) {
                OperacionesUtiles.abrirArchivo(pdfNewFile.toString());
            }
            if (this.formularioReporteCorteCaja.getRadBtnImprimir().isSelected()) {
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