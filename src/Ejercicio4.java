import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Ejercicio4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/buttons");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement btnDoubleClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));

            Actions actions = new Actions(driver);
            actions.doubleClick(btnDoubleClick).perform();

            WebElement mensajeConfirmacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
            String textoMensaje = mensajeConfirmacion.getText();

            if (textoMensaje.contains("You have done a double click")) {
                System.out.println("PRUEBA EXITOSA (Ejercicio 4): La página confirma que se efectuó el doble clic correctamente.");
            } else {
                System.out.println("PRUEBA FALLIDA (Ejercicio 4): El mensaje de confirmación no es el esperado. Texto actual: " + textoMensaje);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error en la ejecución: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}