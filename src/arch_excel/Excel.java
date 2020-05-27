package arch_excel;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    
    public  void escribir(String nombreArchivo, String rutaArchivo, String[] cabecera, String[][] contenido){
        
        String hoja = "Hoja 1";
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
     
        //poner negrita a la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        //generar los datos para el documento
	for (int i = 0; i <= contenido.length; i++) {
            XSSFRow row=hoja1.createRow(i);//se crea las filas
            for (int j = 0; j <cabecera.length; j++) {
		if (i==0) {//para la cabecera
                    XSSFCell cell= row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellStyle(style); // se añade el style crea anteriormente 
                    cell.setCellValue(cabecera[j]);//se añade el contenido					
		}else{//para el contenido
                    XSSFCell cell= row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    cell.setCellValue(contenido[i-1][j]); //se añade el contenido
		}				
            }
	}
        File file;
	file = new File(rutaArchivo);
	try (FileOutputStream fileOuS = new FileOutputStream(file))
        {						
            if (file.exists()) // si el archivo existe se elimina
            {
		file.delete();
		System.out.println("Archivo eliminado por uno nuevo");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo generado exitosamente");
			
	} catch (Exception e) {
            System.out.println(e.getMessage());
    }
  }
}
