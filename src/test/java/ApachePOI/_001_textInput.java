package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;

public class _001_textInput {
    public static void main(String[] args) throws IOException {

        /*
        String str = "Bunu dosyaya yazdir";

        File file = new File("dosya.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
         */  //not: bu kısım sıfırdan oluşturmak için gerekli. Yolunu vereceksek aşağıdaki yeterli


        String path = "src/test/java/ApachePOI/resource/BeymenProductInformation.txt";
        FileWriter fileWriter = new FileWriter(path, false);//false koyulmazsa default olarak var olan metindeki son kısma ekler
        BufferedWriter bWriter = new BufferedWriter(fileWriter);   // false olunca sil baştan yazıyor.
        bWriter.write("Yaz bakalım");
        bWriter.close();


    }
}
