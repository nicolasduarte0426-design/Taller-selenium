import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Ejercicio1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/text-box");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement nombreInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            nombreInput.sendKeys("Laura Martínez");

            WebElement emailInput = driver.findElement(By.id("userEmail"));
            emailInput.sendKeys("laura@gmail.com");

            WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
            currentAddressInput.sendKeys("Calle 25 # 10-20");

            WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
            permanentAddressInput.sendKeys("Carrera 15 # 30-40");

            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            submitBtn.click();

            WebElement outputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            WebElement outputEmail = driver.findElement(By.id("email"));

            String textoNombre = outputName.getText();
            String textoEmail = outputEmail.getText();

            if (textoNombre.contains("Laura Martínez") && textoEmail.contains("laura@gmail.com")) {
                System.out.println("PRUEBA EXITOSA (Ejercicio 1): La información ingresada se muestra correctamente en la pantalla.");
            } else {
                System.out.println("PRUEBA FALLIDA (Ejercicio 1): Los datos mostrados no coinciden con los esperados.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error en la ejecución: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}