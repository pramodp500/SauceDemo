package advarisk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SauceDemoAutomation {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Pramod\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Login scenario
        loginTest(driver);

        // Cart scenario
        cartTest(driver);

        // Checkout scenario
        checkoutTest(driver);

        // Close the browser
        driver.quit();
    }

    public static void loginTest(WebDriver driver) {
        // Enter valid username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click on the Login button
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        // Verify successful login
        WebElement productsTitle = driver.findElement(By.className("title"));
        if (productsTitle.getText().equals("Products")) {
            System.out.println("Login test passed");
        } else {
            System.out.println("Login test failed");
        }
    }

    public static void cartTest(WebDriver driver) {
        // Add items to the cart
        WebElement addToCartButton1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartButton1.click();

        WebElement addToCartButton2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        addToCartButton2.click();

        // Navigate to the cart
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        // Verify items in the cart
        WebElement cartItem1 = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']"));
        WebElement cartItem2 = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']"));
        if (cartItem1.isDisplayed() && cartItem2.isDisplayed()) {
            System.out.println("Cart test passed");
        } else {
            System.out.println("Cart test failed");
        }
    }

    public static void checkoutTest(WebDriver driver) {
        // Navigate to the cart
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        // Click on the Checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();

        // Enter user information
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("Pramod");

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Patil");

        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("411052");

        // Click on the Continue button
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        // Verify successful checkout
        WebElement checkoutOverviewTitle = driver.findElement(By.className("title"));
        if (checkoutOverviewTitle.getText().equals("Checkout: Overview")) {
            System.out.println("Checkout test passed");
        } else {
            System.out.println("Checkout test failed");
        }
        // Check out Overview and finish Page
        WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));
        finishButton.click();
        
        WebElement orderPlaced = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
        if( orderPlaced.getText().equals("Thank you for your order!")) {
        	System.out.println("Order Placed Test passed");
        }
        	else {
        		System.out.println("Order Placed Test Failed");
        	}
        	}
        
    }