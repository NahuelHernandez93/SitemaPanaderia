package operacionesConfiguracion;

import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JPanel;
import principal.PrincipalAdministrador;

public class ConfiguracionTxt {

    private ColorTema color = new ColorTema();
    private String saldoCuenta;
    private PrincipalAdministrador principalAdministrador;

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }

    public String getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(String saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public ColorTema getColor() {
        return color;
    }

    public void setColor(ColorTema color) {
        this.color = color;
    }
    
    
    

    /**
     * Recibe 6 valores, 3 RGB para crear color primario y 3 RGB para crear el
     * color secundario de la interfaz grafica.
     *
     * @param pr colorPrimarioRed
     * @param pg colorPrimarioGreen
     * @param pb colorPrimarioBlue
     * @param sr colorSecundarioRed
     * @param sg colorSecundarioGreen
     * @param sb colorSecundarioBlue
     */
    public void setColor(Integer pr, Integer pg, Integer pb, Integer sr, Integer sg, Integer sb) {
        color.setPrincipalBlue(pb);
        color.setPrincipalGreen(pg);
        color.setPrincipalRed(pr);
        color.setSecundarioBlue(sb);
        color.setSecundarioGreen(sg);
        color.setSecundarioRed(sr);
        color.setColorPrimario(new Color(color.getPrincipalRed(), color.getPrincipalGreen(), color.getPrincipalBlue()));
        color.setColorSecundario(new Color(color.getSecundarioRed(), color.getSecundarioGreen(), color.getSecundarioBlue()));
    }

    /**
     * Inserta el color principal previamente definido en el panel prmario y los
     * botones de la ventana principal y el color secundario en los paneles
     * secundarios.
     */
    public void setTemaPrincipalAdministrador() {
        principalAdministrador.getPanelPrincipalTop().setBackground(color.getColorPrimario());
        principalAdministrador.getPanelPrincipalBody().setBackground(color.getColorSecundario());
        principalAdministrador.getBtnConfiguracion().setBackground(color.getColorPrimario());
        principalAdministrador.getBtnGestionCliente().setBackground(color.getColorPrimario());
        principalAdministrador.getBtnGestionCaja().setBackground(color.getColorPrimario());
        principalAdministrador.getBtnGestionMateriPrima().setBackground(color.getColorPrimario());
        principalAdministrador.getBtnGestionVentas().setBackground(color.getColorPrimario());
        principalAdministrador.getBtnGestionProducto().setBackground(color.getColorPrimario());
        principalAdministrador.getBtnGestionProveedor().setBackground(color.getColorPrimario());
        principalAdministrador.getBtnGestionGastos().setBackground(color.getColorPrimario());
    }
    
    
    public void setColorPanel(JPanel panel){
        panel.setBackground(color.getColorPrimario());
    }

    /**
     * recupera los valores almacenados en el archivo ConfiguracionColor.txt
     * para definir el color de la interfaz grafica al iniciar una nueva sesion.
     */
    public void leerArchivoConfig() {
        try {
            LinkedList valores = new LinkedList();
            Scanner input = new Scanner(new File("Configuracion.txt"));

            while (input.hasNextLine()) {
                valores.add(input.nextLine());
            }
            color.setPrincipalRed(Integer.valueOf(valores.get(0).toString()));
            color.setPrincipalGreen(Integer.valueOf(valores.get(1).toString()));
            color.setPrincipalBlue(Integer.valueOf(valores.get(2).toString()));
            color.setSecundarioRed(Integer.valueOf(valores.get(3).toString()));
            color.setSecundarioGreen(Integer.valueOf(valores.get(4).toString()));
            color.setSecundarioBlue(Integer.valueOf(valores.get(5).toString()));
            color.setColorPrimario(new Color(color.getPrincipalRed(), color.getPrincipalGreen(), color.getPrincipalBlue()));
            color.setColorSecundario(new Color(color.getSecundarioRed(), color.getSecundarioGreen(), color.getSecundarioBlue()));
            setSaldoCuenta(valores.get(6).toString());
            input.close();
        } catch (FileNotFoundException | NumberFormatException ex) {
        }
    }

    /**
     * Abre el archivo ConfiguracionColor.txt e inserta en el los valores
     * devueltos en el metodo contenidoConfig.
     */
    public void guardarConfiguaracion() {
        try {
            String ruta = "Configuracion.txt";
            String contenido = contenidoConfig();
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
             DesktopNotify.showDesktopMessage("   exito   ", "  Configuracion guardada", DesktopNotify.SUCCESS, 5000);
        } catch (IOException e) {
            DesktopNotify.showDesktopMessage("   error   ", "  Error al intentar guardar configuracion", DesktopNotify.ERROR, 5000);
        }
    }

    /**
     * Devuelve una cadena con los valores que conponen el color principal y
     * secundario de la interfaz grafica.
     *
     */
    public String contenidoConfig() {
        return color.getPrincipalRed() + "\n"
                + color.getPrincipalGreen() + "\n"
                + color.getPrincipalBlue() + "\n"
                + color.getSecundarioRed() + "\n"
                + color.getSecundarioGreen() + "\n"
                + color.getSecundarioBlue()+ "\n"
                +saldoCuenta;
    }

}
