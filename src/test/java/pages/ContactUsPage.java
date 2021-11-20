package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(xpath = "//*[@id=\"id_contact\"]")
    private WebElement subjectHeadingSelect;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "id_order")
    private WebElement orderReferenceField;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li")
    private WebElement errorText;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement successText;

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void fillMessageFieldWith(String text){ messageField.sendKeys(text);}

    public void selectSubjectHeading(String subjectHeading){
        Select dropdown = new Select(subjectHeadingSelect);
        dropdown.selectByVisibleText(subjectHeading);
    }

    public void fillEmailFieldWith(String text){ emailField.sendKeys(text); }

    public void fillOrderReferenceWith(String text){ orderReferenceField.sendKeys(text); }

    public void clickSendButton(){ sendButton.click(); }

    public String getErrorMessageText(){
        String text;
        try{
            text = errorText.getText();
        }catch (NoSuchElementException | TimeoutException exception){
            return "";
        }
        return text.strip();
    }

    public String getSuccessMessageText(){
        String text;
        try{
            text = successText.getText();
        }catch (NoSuchElementException | TimeoutException exception){
            return "";
        }
        return text.strip();
    }
}
