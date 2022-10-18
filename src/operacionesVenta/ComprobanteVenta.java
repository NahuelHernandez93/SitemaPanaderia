/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacionesVenta;

import calsesPadre.Consultas;
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
import entidades.PrecioProducto;
import entidades.Producto_Venta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import clasesUtilidadGeneral.OperacionesUtiles;
import formularios.FormularioDetalleDeVenta;
import formularios.FormularioRegistrarVenta;
import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import operacionesIngresoMateriaPrima.ReporteIngresos;

/**
 *
 * @author FRANCO
 */
public class ComprobanteVenta extends Consultas {

    private static final Font titulofuente = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
    private static final Font datosfuente = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);
    
    private Integer idVenta;
    private JRadioButton radBtnImprimir;
    private JRadioButton radBtnAbrirDocumento;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public JRadioButton getRadBtnImprimir() {
        return radBtnImprimir;
    }

    public void setRadBtnImprimir(JRadioButton radBtnImprimir) {
        this.radBtnImprimir = radBtnImprimir;
    }

    public JRadioButton getRadBtnAbrirDocumento() {
        return radBtnAbrirDocumento;
    }

    public void setRadBtnAbrirDocumento(JRadioButton radBtnAbrirDocumento) {
        this.radBtnAbrirDocumento = radBtnAbrirDocumento;
    }
    
    
    
    
    public void ejecutarGenerarReporte() throws FileNotFoundException, DocumentException {
        setConsultaObject("from Producto_Venta where codigo_venta=" + idVenta);
        obtenerObjetoConsulta();
        setConsultaList("from Producto_Venta where codigo_venta=" + idVenta);
        obtenerListaConsulta();        
        generarReportePDF5(new File("reportes//Ventas//" + nombreDocumento() + ".pdf"));
    }

 
    
    private String nombreDocumento() {
        Object objeto = this.getObjetoResultado();
        Producto_Venta pro = (Producto_Venta) objeto;
        return idVenta.toString() + " " + pro.getCodigoVenta().getCodigoCliente().getNombre();
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
            texto.add("Recibo Sistema Panaderia");

            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            texto.add(dottedline);
            texto.setFont(datosfuente);
            texto.add("\n");
            texto.add("Datos de Cliente");
            texto.add("\n");

            Object objeto = this.getObjetoResultado();
            Producto_Venta pro = (Producto_Venta) objeto;
            texto.add(new Paragraph("Cliente: " + pro.getCodigoVenta().getCodigoCliente().getNombre() + "  " + pro.getCodigoVenta().getCodigoCliente().getApellido()));
            texto.add(new Paragraph("Fecha: " + (OperacionesUtiles.formatoFecha(pro.getCodigoVenta().getFechaHoraVenta()).toString())));

            texto.add(new Paragraph("\n"));

            Double resultado;
            java.util.List lista = this.getListaResultados();

            PdfPTable table = new PdfPTable(3);
            PdfPCell columnHeader;

            columnHeader = new PdfPCell(new Phrase("Nombre"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total Unidades"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total"));
            table.addCell(columnHeader);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.setHeaderRows(1);

            for (Object o : lista) {
                Producto_Venta pr = (Producto_Venta) o;
                table.addCell(pr.getCodigoProducto().getNombre().toString());
                table.addCell(pr.getTotalUnidades().toString());
                java.util.List<PrecioProducto> precios = pr.getCodigoProducto().getPrecios();
                for (PrecioProducto pre : precios) {
                    if (pre.getCodigoEstado().getIdEstado().equals(1)) {
                        resultado = (pr.getTotalUnidades() * pre.getPrecioTotal());
                        table.addCell("$ " + (Double.toString(resultado)));

                    }
                }

            }
            texto.add(table);
            texto.add(new Paragraph("\n"));
            texto.add("Importe Total:   " + pro.getCodigoVenta().getPrecioTotal().toString());
            texto.add("\n");
            texto.add("Descuento:        " + pro.getCodigoVenta().getDescuento().toString());
            texto.add("\n");
            texto.add("Pagado:             " + pro.getCodigoVenta().getPagado().toString());
            texto.add("\n");
            texto.add("Vuelto:               " + pro.getCodigoVenta().getVuelto().toString());

            document.add(texto);
            document.close();

            DesktopNotify.showDesktopMessage("exito ", "   RECIBO GENERADO\n   CON EXITO", DesktopNotify.SUCCESS, 7000);

            if (radBtnAbrirDocumento.isSelected()) {
                OperacionesUtiles.abrirArchivo(pdfNewFile.toString());
            }
            if (radBtnImprimir.isSelected()) {
                try {
                    Desktop.getDesktop().print(pdfNewFile);
                } catch (IOException ex) {
                    Logger.getLogger(ReporteIngresos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException | DocumentException e) {
            DesktopNotify.showDesktopMessage("error ", "    NO SE PUDO GENERAR\n    EL RECIBO", DesktopNotify.ERROR, 7000);
        }

    }

}
