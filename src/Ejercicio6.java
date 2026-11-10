import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class Ejercicio6 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement revealBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal")));
            revealBtn.click();

            WebElement revealedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

            String textoPrueba = "Prueba Selenium ADSO";
            revealedInput.sendKeys(textoPrueba);

            String valorActual = revealedInput.getDomProperty("value");

            if (valorActual.equals(textoPrueba)) {
                System.out.println("PRUEBA EXITOSA (Ejercicio 6): El texto ingresado es correcto (" + valorActual + ").");
            } else {
                System.out.println("PRUEBA FALLIDA (Ejercicio 6): El texto no coincide. Valor actual: " + valorActual);
            }

            File archivoCaptura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia_selenium.png");
            FileHandler.copy(archivoCaptura, destino);

            System.out.println("Evidencia guardada con éxito en la raíz del proyecto como: evidencia_selenium.png");

        } catch (Exception e) {
            System.out.println("Ocurrió un error en la ejecución: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}