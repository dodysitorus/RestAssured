package DataFromExcel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Excel {

    public void  getRowCount()  {

        try {
            String excelPath = "./data/Book2.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            


        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }

    }
}
