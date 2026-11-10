import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Ejercicio2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/radio-button");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement impressiveLabel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='impressiveRadio']")));

            impressiveLabel.click();

            WebElement textoConfirmacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));
            String mensaje = textoConfirmacion.getText();

            if (mensaje.equalsIgnoreCase("Impressive")) {
                System.out.println("PRUEBA EXITOSA (Ejercicio 2): La página reconoce la selección y muestra el mensaje confirmando 'Impressive'.");
            } else {
                System.out.println("PRUEBA FALLIDA (Ejercicio 2): El mensaje obtenido no coincide. Texto actual: " + mensaje);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error en la ejecución: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}