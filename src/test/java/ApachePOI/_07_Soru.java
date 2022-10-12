package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
public class _07_Soru {
    public static void main(String[] args) {
        System.out.print("Istenen sütun=");
        Scanner oku=new Scanner(System.in);
        int column=oku.nextInt();

        String donenSonuc=bul(column);
        System.out.println("donenSonuc = " + donenSonuc);

    }
    public static String bul(int sutun){
        String donecek="";

        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook=null;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);//.getSheet("Login")
        // int satirSayisi=sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            if(sheet.getRow(i).getPhysicalNumberOfCells()>sutun)
            donecek+=sheet.getRow(i).getCell(sutun)+"\n";


        return donecek;
    }
}
