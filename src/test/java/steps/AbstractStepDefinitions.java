package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractStepDefinitions {

    private static final int WAIT_TIME = 10;

    static WebDriver driver;

    static {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    public void waitFor(int seconds){
        try{Thread.sleep(seconds * 1000L);}catch (InterruptedException exception){System.out.println(exception.getMessage());}
    }
}
