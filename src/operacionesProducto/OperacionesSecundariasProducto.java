package operacionesProducto;

import conexion.ConexionHibernate;
import entidades.Estado;
import entidades.Iva;
import entidades.PrecioProducto;
import entidades.Producto;
import escritorios.PrincipalProducto;
import formularios.FormularioRegistrarPrecioProducto;
import formularios.FormularioRegistrarProducto;
import java.util.List;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.HeadlessException;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author TELCOM MPC
 */
public class OperacionesSecundariasProducto {

    public void aplicarIvaPrecioProducto(FormularioRegistrarPrecioProducto f) {

        Double precioBruto;
        Double iva;
        Double porcentage;
        Double precioFinal;

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 1);
            Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();

            if (f.getTxtPrecio().getText().length() == 0) {
                DesktopNotify.showDesktopMessage("   informacion   ", "  Debe insertar un valor en el campo Precio Bruto", DesktopNotify.INFORMATION, 7000);
                f.getRadioIva().setSelected(false);
            } else {
                precioBruto = Double.valueOf(f.getTxtPrecio().getText());
                iva = i.getPorcentaje();
                porcentage = precioBruto * iva;
                precioFinal = precioBruto + porcentage;
                f.getTxtPrecioFinal().setText(precioFinal.toString());
            }

            miSesion.getTransaction().commit();

        } catch (HeadlessException | NumberFormatException e) {

        }

    }

    public void aplicarIvaProducto(FormularioRegistrarProducto f) {

        Double precioBruto;
        Double iva;
        Double porcentage;
        Double precioFinal;
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 1);
            Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();
            if (f.getTxtPrecio().getText().length() == 0) {
                DesktopNotify.showDesktopMessage("   informacion   ", "  Debe insertar un valor en el campo Precio Bruto", DesktopNotify.INFORMATION, 7000);
                f.getRadioIva().setSelected(false);
            } else {
                precioBruto = Double.valueOf(f.getTxtPrecio().getText());
                iva = i.getPorcentaje();
                porcentage = precioBruto * iva;
                precioFinal = precioBruto + porcentage;
                f.getTxtPrecioFinal().setText(precioFinal.toString());
            }
            miSesion.getTransaction().commit();

        } catch (Exception e) {

        }

    }

    public void graficarHistorialPrecios(PrincipalProducto principalProducto) {

        Session miSesion = ConexionHibernate.tomarConexion();

        miSesion.beginTransaction();
        Integer totalFilas = principalProducto.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalProducto.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalProducto.getTablaProducto().getListaResutladosActuales();

        Integer id = OperacionesUtiles.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        PrecioProducto prepro = (PrecioProducto) miSesion.get(PrecioProducto.class, id);

        id = prepro.getCodigoProducto().getIdProducto();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Producto prd = (Producto) miSesion.get(Producto.class, id);

        List<PrecioProducto> precios = prd.getPrecios();

        
        for (PrecioProducto p : precios) {
            dataset.setValue(p.getPrecioTotal(),"", (String)OperacionesUtiles.formatoFecha(p.getFecha()));
          
        }
        miSesion.getTransaction().commit();

        JFreeChart chart = ChartFactory.createLineChart("Historial de Precios", "Fecha", "Precios", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.addSubtitle(new TextTitle(prd.getNombre()));
       

        //aspecto
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        LineAndShapeRenderer render = (LineAndShapeRenderer) plot.getRenderer();
        render.setSeriesStroke(0, new BasicStroke(3.0f));
        render.setSeriesPaint(0, principalProducto.getPanelPrincipalTop().getBackground());

        render.setDrawOutlines(true);
        render.setUseFillPaint(true);
        render.setFillPaint(Color.white);
        render.setShapesVisible(true);
        //ventana
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void barras(PrincipalProducto principalProducto) {
        Session miSesion = ConexionHibernate.tomarConexion();

        miSesion.beginTransaction();
        Integer totalFilas = principalProducto.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalProducto.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalProducto.getTablaProducto().getListaResutladosActuales();

        Integer id = OperacionesUtiles.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        PrecioProducto prepro = (PrecioProducto) miSesion.get(PrecioProducto.class, id);

        id = prepro.getCodigoProducto().getIdProducto();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Producto prd = (Producto) miSesion.get(Producto.class, id);

        List<PrecioProducto> precios = prd.getPrecios();

        for (PrecioProducto p : precios) {
            dataset.setValue(p.getPrecioTotal(), "", OperacionesUtiles.formatoFecha(p.getFecha()).toString());
        }
        miSesion.getTransaction().commit();
        JFreeChart chart = ChartFactory.createBarChart3D("Historial de Precios", "Fecha", "Precios", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame frame = new ChartFrame("JFreeChart", chart);

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer render = (BarRenderer) plot.getRenderer();
        render.setSeriesPaint(0, principalProducto.getPanelPrincipalTop().getBackground());
        render.setSeriesPaint(1, Color.LIGHT_GRAY);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
