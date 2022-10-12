package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Tekrar1_2 {
    public static void main(String[] args) {
        System.out.print("Aranacak kelime= ");
        Scanner oku=new Scanner(System.in);
        String arananKelime=oku.next();

        String arananSonuc=bul(arananKelime);
        System.out.println("arananSonuc = " + arananSonuc);
    }
    public static String bul(String arananKelime){
        String donecek="";
        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook=null;
        try {
            FileInputStream baglanti=new FileInputStream(path);
            workbook= WorkbookFactory.create(baglanti);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);
            if (cell.toString().toLowerCase().contains(arananKelime)){
                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++) {
                    donecek+=row.getCell(j)+" ";
                }
            }

        }



        return donecek;
    }
}
