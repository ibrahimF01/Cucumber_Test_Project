package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);//okuma modunda açıldı
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        Row newRow=sheet.createRow(0);//0. yerde satır oluşturuldu
        Cell newCell=newRow.createCell(0);// yeni satırda ilk hücre oluşturuldu
        newCell.setCellValue("Merhaba Dünya");//bilgi yazıldı.
        for (int i = 1; i < 10; i++) {
            newRow.createCell(i).setCellValue(i);
        }
        // sıra kaydetmeye geldii bütün bilgiler hafızada buraya kadar, her şey WORKBOOK da
        inputStream.close();//okuma modunu kapattım, çünkü yazma modunda açmam gerekiyor.

        //yazma işlemini YAZMA modunda açıp öyle yapacağız.
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();//hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");


    }
}
