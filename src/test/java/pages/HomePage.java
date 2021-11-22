package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/index.php";


    @FindBy(id = "search_query_top")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    private WebElement contactUsButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[2]")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span")
    private WebElement searchResultWithWarning;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement helpText;

    public HomePage(WebDriver driver){
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void fillSearchBarWith(String text){ searchBar.sendKeys(text);}

    public void clickSearchButton(){
        searchButton.click();
    }

    public String getSearchResultText(){
        String text;
        try{
            text = searchResult.getText().strip();
        }catch (NoSuchElementException  |  TimeoutException exception){
            text = searchResultWithWarning.getText().strip();
        }
        return text.strip();
    }

    public String getSearchHelpText() {
        String text;
        try{
            text = helpText.getText();
        }catch (NoSuchElementException  |  TimeoutException exception){
            return "";
        }
        return text.strip();
    }

    public void clickContactUsButton(){contactUsButton.click();}

    public void clickSignInButton(){signInButton.click();}
}
