import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Ejercicio3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement textInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-text")));
            textInput.sendKeys("Prueba ADSO");

            WebElement passwordInput = driver.findElement(By.name("my-password"));
            passwordInput.sendKeys("Sena2026");

            WebElement textarea = driver.findElement(By.name("my-textarea"));
            textarea.sendKeys("Automatización con Selenium");


            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            submitBtn.click();

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "Received!"));

            WebElement mensajeConfirmacion = driver.findElement(By.id("message"));
            String textoMensaje = mensajeConfirmacion.getText();

            if (textoMensaje.contains("Received!")) {
                System.out.println("PRUEBA EXITOSA (Ejercicio 3): El formulario se envió correctamente y presenta el mensaje Received!.");
            } else {
                System.out.println("PRUEBA FALLIDA (Ejercicio 3): No se encontró el texto de confirmación esperado. Texto actual: " + textoMensaje);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error en la ejecución: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}