package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPostsPage {

    @FindBy(css = "a[href='/new-post']")
    private WebElement newPostButton;

    
}
