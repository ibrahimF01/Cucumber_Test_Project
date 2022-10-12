package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tekrar1_4 {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/denemeapache.xlsx";
        FileInputStream baglanti=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(baglanti);
        Sheet sheet=workbook.getSheet("Sayfa2");
        Row row= sheet.createRow(0);
        Cell cell=row.createCell(0);
        cell.setCellValue("Merhaba Dünya");



    }
}
