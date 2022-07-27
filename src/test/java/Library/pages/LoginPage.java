package Library.pages;

import Library.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);


    }


    @FindBy(xpath ="//label[@for=\"inputEmail\"]")
    public WebElement username;

    @FindBy(xpath ="//button[@type=\"submit\"]")
    public WebElement password;

    @FindBy(xpath ="//button[@type=\"submit\"]")
    public WebElement submit;




}
