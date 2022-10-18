package clasesUtilidadGeneral;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import principal.PrincipalAdministrador;

public class ApiDolar {

    /**
     * Establece una conexion con un enlace que proporciona el precio atual de
     * venta del dolar libre e inserta dicho valor en un Label presente en la
     * ventana principal de la aplicacion.
     *
     * @throws Exception
     */
    public void precioDolarOficial(PrincipalAdministrador principalAdministrador) throws Exception {
        
        String url = "https://api-dolar-argentina.herokuapp.com/api/dolaroficial";
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }

        String precioCompra = response.substring(41, 46);
        String precioVenta = response.substring(57, 62);
        principalAdministrador.getLblCompraDolar().setText("$"+precioCompra);
        principalAdministrador.getLblVentaDolar().setText("$"+precioVenta);
        in.close();

    }

}


/**
 *  String url = "https://api-dolar-argentina.herokuapp.com/api/dolaroficial";
        //https://www.dolarsi.com/api/api.php?type=valoresprincipales
        URL obj = new URL(url);
        try {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject myResponse = new JSONObject(response.substring(0, 61));
            principalAdministrador.getLblLibre().setText(myResponse.getString("compra"));
            
           //  DesktopNotify.showDesktopMessage(" INFORMACION  ", " DOLAR OFICIAL:\n COMPRA: "+myResponse.getString("compra")+"\n VENTA: "+ myResponse.getString("venta")+"", DesktopNotify.INFORMATION, 10000);
          
        } catch (Exception e) {
          // DesktopNotify.showDesktopMessage("   error de conexion   ", "    NO SE PUDO OBTENER\n    EL PRECIO DEL DOLAR", DesktopNotify.ERROR, 7000);
           principalAdministrador.getLblLibre().setText("Sin resultados");
        }
 */
