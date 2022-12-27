package DataDrivenTesting;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class JXL_library {

    Workbook workbook;

    public JXL_library(String filepath){
        try {
            workbook = Workbook.getWorkbook(new File(filepath));
        } catch (BiffException e){
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }//end of constructor

    public String getCellValue( int sheetNumber, int column, int row){
        return workbook.getSheet(sheetNumber).getCell(column,row).getContents();
    }



}//end of class