package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class Tekrar1_1 {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/denemeapache.xlsx";
        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);

        Workbook workbook=WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet sheet=workbook.getSheet("Sayfa1");




        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row=sheet.getRow(i);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell=row.getCell(j);
                System.out.print(" " + cell+" ");

            }
            System.out.println();
        }


    }
}
