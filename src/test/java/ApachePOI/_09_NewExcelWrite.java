package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        Row newRow=sheet.createRow(0);//0. yerde satır oluşturuldu
        Cell newCell=newRow.createCell(0);// yeni satırda ilk hücre oluşturuldu
        newCell.setCellValue("Merhaba Dünya");//bilgi yazıldı.
        for (int i = 1; i < 10; i++) {
            newRow.createCell(i).setCellValue(i);
        }

        //yazma işlemini YAZMA modunda açıp öyle yapacağız.
        String yeniExcelPath="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close();//hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");



    }
}
