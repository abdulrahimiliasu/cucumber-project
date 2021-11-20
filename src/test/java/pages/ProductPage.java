package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a")
    private WebElement productPageLink;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    private WebElement addProductToCartButton;

    @FindBy(xpath = "//*[@id=\"send_friend_button\"]")
    private WebElement sendToAFriendButton;

    @FindBy(xpath = "//*[@id=\"friend_name\"]")
    private WebElement nameOfFriendField;

    @FindBy(xpath = "//*[@id=\"friend_email\"]")
    private WebElement emailOfFriendField;

    @FindBy(xpath = "//*[@id=\"sendEmail\"]")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//*[@id=\"product_comments_block_extra\"]/ul/li/a")
    private WebElement writeAReviewButton;

    @FindBy(xpath = "//*[@id=\"comment_title\"]")
    private WebElement titleOfReviewField;

    @FindBy(xpath = "//*[@id=\"content\"]")
    private WebElement commentOfReviewField;

    @FindBy(xpath = "//*[@id=\"submitNewMessage\"]")
    private WebElement sendReviewButton;

    @FindBy(xpath = "//*[@id=\"send_friend_form_error\"]")
    private WebElement sendToFriendErrorMessage;

    @FindBy(xpath = "//*[@id=\"new_comment_form_error\"]/ul/li[1]")
    private WebElement titleIncorrectErrorMessage;

    @FindBy(xpath = "//*[@id=\"new_comment_form_error\"]/ul/li[2]")
    private WebElement commentIncorrectErrorMessage;

    public ProductPage(WebDriver driver){ PageFactory.initElements(driver, this); }

    public void clickProductPageLink(){ productPageLink.click();}
    public void clickAddProductToCartButton(){addProductToCartButton.click();}

    public void clickSendToAFriendButton(){ sendToAFriendButton.click();}
    public void clickSendMessageButton(){ sendMessageButton.click();}
    public void clickWriteAReviewButton(){ writeAReviewButton.click();}
    public void clickSendReviewButton(){ sendReviewButton.click();}

    public void fillNameOfFriendFieldWith(String text){nameOfFriendField.sendKeys(text);}
    public void fillEmailOfFriendFieldWith(String text){emailOfFriendField.sendKeys(text);}
    public void fillTitleOfReviewFieldWith(String text){titleOfReviewField.sendKeys(text);}
    public void fillCommentOfReviewFieldWith(String text){commentOfReviewField.sendKeys(text);}

    public String getSendToFriendErrorMessage(){ return sendToFriendErrorMessage.getText().strip();}
    public String getTitleIncorrectErrorMessage(){ return titleIncorrectErrorMessage.getText().strip();}
    public String getCommentIncorrectErrorMessage(){ return commentIncorrectErrorMessage.getText().strip();}

}
