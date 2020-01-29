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
	static Frame sim;
	public static void main(String args[]) {
		sim = new Frame();
	}
	
	public Color[][] readFromExcel(int sheet) throws IOException{
		File myFile = new File("map1.xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
       
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(sheet);
       
        // Get iterator to all the rows in current sheet
      
       
        Color[][] mapColors = new Color[113][100];

        // Traversing over each row of XLSX file
        int i = 0;
        while (i < 113) {
            
        	
            // For each row, iterate through each columns
         
            int j = 0;
            while (j < 100) {
            	
                Cell cell = mySheet.getRow(i).getCell(j);
                String bgColor = "ffffffff";
               
             
                try {  
                	bgColor = ((ExtendedColor) cell.getCellStyle().getFillForegroundColorColor()).getARGBHex();
                }
                catch(Exception e) {
                
                }
             
                if (true) {
                	
                	mapColors[i][j] = hex2Rgb(bgColor);
                	
                }
                if (sheet == 2 && i==111 ) {   
            		mapColors[112][j] = Color.white;
            	}
                if (sheet == 2 && i==111 && j==99) {
                	i=113;
                }
            j++;
            }
           i++; 
        }  
 
        return mapColors;
	}
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
	            Integer.valueOf( colorStr.substring( 4, 6 ), 16 ),
	            Integer.valueOf( colorStr.substring( 6, 8), 16 ) );
	}
}

