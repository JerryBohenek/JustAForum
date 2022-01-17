package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestConfig {

    @Before
    public void setUp() {
        String url = "http://localhost:8080/";

        WebDriver driver = WebDriverSingleton.getInstance();

        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quit();
    }
}
