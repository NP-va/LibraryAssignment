package Library.stepDefination;

import Library.Utilities.ConfigurationReader;
import Library.Utilities.Driver;
import Library.pages.BookPage;
import Library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class addBook {
   WebDriver driver = Driver.getDriver();
   BookPage bookPage = new BookPage();
   LoginPage loginPage = new LoginPage();

    @Given("Librarian is on the loginPage")
    public void librarian_is_on_the_login_page() {

        driver.get(ConfigurationReader.getProperty("url"));

    }
    @Given("Librarian enters valid {string} and {string} and click sign in.")
    public void librarian_enters_valid_and_and_click_sign_in(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();

    }
    @When("Librarian clicks Books module")
    public void librarian_clicks_books_module() {
    bookPage.book.click();

    }
    @When("Librarian click “+ Add Book\" button")
    public void librarian_click_add_book_button() {
    bookPage.Addbook.click();

    }
    @When("Librarian enter bookName , ISBN , Year, Author and Description")
    public void librarian_enter_book_name_isbn_year_author_and_description() {
    bookPage.bookName.sendKeys(ConfigurationReader.getProperty("bookname"));
    bookPage.ISBN.sendKeys(ConfigurationReader.getProperty("isbn"));
    bookPage.Year.sendKeys(ConfigurationReader.getProperty("year"));
    bookPage.Author.sendKeys(ConfigurationReader.getProperty("author"));
        Select bookCategory = new Select(driver.findElement(By.xpath("//select[@id=\"book_group_id\"]")));
        bookCategory.selectByVisibleText(ConfigurationReader.getProperty("bookcategory"));
    bookPage.Description.sendKeys(ConfigurationReader.getProperty("description"));

    }
    @When("librarian click save changes")
    public void librarian_click_save_changes() {
    bookPage.SaveChanges.click();
    }
    @Then("verify a new book is added")
    public void verify_a_new_book_is_added() {
    bookPage.Search.sendKeys(ConfigurationReader.getProperty("bookname"));
        ArrayList<WebElement>bookList= new ArrayList<>();
        Dimension size = (bookPage.Search.getSize());
        System.out.println(size);
        for(int i =0;i<(bookPage.Search.getSize());i++)

        for (WebElement each: bookList)
        {
            if(each.equals(ConfigurationReader.getProperty("bookname"))){
                System.out.println("the Book is in the list");
            } else {
                System.out.println("The book is not in the list");
            }
        }
    }

}
