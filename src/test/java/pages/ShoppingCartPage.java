package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    private WebElement proceedButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    private WebElement secondProceedButton;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    private WebElement thirdProceedButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    private WebElement payByCheckButton;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    private WebElement iConfirmOrderButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]")
    private WebElement orderSuccessMessage;

    @FindBy(id="cgv")
    private WebElement termsCheckBox;

    public ShoppingCartPage(WebDriver driver){ PageFactory.initElements(driver, this); }

    public void clickProceedButton(){proceedButton.click();}
    public void clickSecondProceedButton(){secondProceedButton.click();}
    public void clickThirdProceedButton(){thirdProceedButton.click();}
    public void clickCartButton(){cartButton.click();}
    public void clickProceedToCheckOutButton(){proceedToCheckoutButton.click();}
    public void clickPayByCheckButton(){payByCheckButton.click();}
    public void clickIConfirmOrderButton(){iConfirmOrderButton.click();}

    public void checkTermsCheckbox(){
        if(! termsCheckBox.isSelected()) termsCheckBox.click();
    }
    public String getMessage(){ return message.getText().strip();}

    public String getOrderSuccessMessage() {return orderSuccessMessage.getText().strip();}
}
