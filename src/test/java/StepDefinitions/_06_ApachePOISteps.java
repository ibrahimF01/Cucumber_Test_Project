package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class _06_ApachePOISteps {
    DialogContent dc=new DialogContent();
    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        //excelden oku ve citizenshipi create et
        ArrayList<ArrayList<String>> tablo=
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for(ArrayList<String> satir:tablo){
            dc.findAndClick("addButton");
            dc.findAndSend("nameInput",satir.get(0));
            dc.findAndSend("shortName",satir.get(1));
            dc.findAndClick("saveButton");
            dc.findAndContainsText("successMessage","success");
        }


    }

    @Then("User Delete citizenship with apachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        //kaydettiklerini yine excelden okuyarak sil
        ArrayList<ArrayList<String>> tablo=
        ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",1);

        for(ArrayList<String> satir:tablo){
            System.out.println("satir = " + satir);
            System.out.println("satir.get(0) = " + satir.get(0));
//            WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
//            wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));
            dc.SearchAndDelete(satir.get(0));
            dc.findAndContainsText("succesMessage","succes");
        }


    }
}
