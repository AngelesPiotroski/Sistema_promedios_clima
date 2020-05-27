package controlador;
import arch_excel.Excel;
import java.util.Calendar;

public class controlador {
   private Excel excel = new Excel();
   
    public String obtenerDiaString()
    {
        String nombreArch = String.valueOf(Calendar.DATE);
        return nombreArch;
    }
    public void genearArchivo(String [][]contenido)
    {
        String nombreArch = obtenerDiaString();
        String rutaArchivo = "C:\\Ficheros-Excel\\"+nombreArch;
        String cabecera [] = {"Tiempo","Temperatura","Promedio"}; 
        excel.escribir(nombreArch,rutaArchivo,cabecera,contenido);
    }
}
