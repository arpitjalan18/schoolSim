package schoolSim;

import java.awt.Color;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class readExcel {
	

	public Color[][] readFromExcel() throws IOException{
		File myFile = new File("C:\\Users\\arpit\\coding\\twiet\\schoolSim\\map0.xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
       
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(1);
       
        // Get iterator to all the rows in current sheet
      
       
        Color[][] mapColors = new Color[119][113];
        Integer[][] mapBool = new Integer[119][113];
        // Traversing over each row of XLSX file
        int i = 0;
        while (i < 119) {
            
        	
            // For each row, iterate through each columns
         
            int j = 0;
            while (j < 113) {
                Cell cell = mySheet.getRow(j).getCell(i);
                String bgColor = "ffffffff";
               
             
                try {  
                	bgColor = ((ExtendedColor) cell.getCellStyle().getFillForegroundColorColor()).getARGBHex();
                }
                catch(Exception e) {}
             
                if (true) {
                	
                	mapColors[i][j] = hex2Rgb(bgColor);
                	
                }
            j++;
            }
           i++; 
        }  
        System.out.println(mapColors[14][80]);
        return mapColors;
	}
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
	            Integer.valueOf( colorStr.substring( 4, 6 ), 16 ),
	            Integer.valueOf( colorStr.substring( 6, 8), 16 ) );
	}
}

