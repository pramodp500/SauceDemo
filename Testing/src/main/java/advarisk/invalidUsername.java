package advarisk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class invalidUsername {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Pramod\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Login scenario
        loginTest(driver);

      // Close the browser
        driver.quit();
    }

    public static void loginTest(WebDriver driver) {
        // Enter valid username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("Pramod");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Patil");

        // Click on the Login button
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        // Verify successful login
        WebElement LoginError = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"));
        if (LoginError.getText().equals("Epic sadface: Username and password do not match any user in this service")) {
            System.out.println("Invalid Username Login Error test passed");
        } else {
            System.out.println("Invalid Username Login Error test failed");
        }
    }
}
