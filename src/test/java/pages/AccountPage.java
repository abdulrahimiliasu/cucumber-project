package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")
    private WebElement orderHistoryAndDetailsButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a")
    private WebElement myCreditSlipsButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a")
    private WebElement myAddressesButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")
    private WebElement myPersonalInformation;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement orderText;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[4]")
    private WebElement addressBox;

    @FindBy(xpath = "//*[@id=\"block-history\"]/p")
    private WebElement noSlipsWarning;


    public AccountPage(WebDriver driver){ PageFactory.initElements(driver, this); }

    public void clickOrderHistoryAndDetailsButton(){ orderHistoryAndDetailsButton.click();}
    public void clickMyCreditSlipsButton(){myCreditSlipsButton.click();}
    public void clickMyAddressesButton(){myAddressesButton.click();}
    public void clickMyPersonalInformationButton(){myPersonalInformation.click();}

    public String getOrderText(){
        return orderText.getText().strip();
    }

    public String getWarningMessage(){
        return noSlipsWarning.getText().strip();
    }

    public String getAddress(){
        return addressBox.getText().strip();
    }

}
