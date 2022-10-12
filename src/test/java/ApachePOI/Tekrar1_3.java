package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Tekrar1_3 {
    public static void main(String[] args) {
        System.out.print("Sütun numarası giriniz= ");
        Scanner oku=new Scanner(System.in);
        int sutunNo=oku.nextInt();
        String arananSonuc=bul(sutunNo);
        System.out.println("arananSonuc = " + arananSonuc);
    }

    public static String bul(int sutunNo){
        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook=null;
        String donecek="";
        try {
            FileInputStream baglanti=new FileInputStream(path);
            workbook= WorkbookFactory.create(baglanti);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if(sheet.getRow(i).getCell(sutunNo)!=null)
              //  if(sheet.getRow(i).getPhysicalNumberOfCells()>sutunNo) bu şekil de oluyor
            donecek+=sheet.getRow(i).getCell(sutunNo)+" "+"\n";

        }

        return donecek;
    }
}
