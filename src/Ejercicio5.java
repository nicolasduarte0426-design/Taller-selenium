import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Ejercicio5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/webtables");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
            addBtn.click();

            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
            firstNameInput.sendKeys("Carlos");

            driver.findElement(By.id("lastName")).sendKeys("Ramirez");
            driver.findElement(By.id("userEmail")).sendKeys("carlos@gmail.com");
            driver.findElement(By.id("age")).sendKeys("25");
            driver.findElement(By.id("salary")).sendKeys("2500000");
            driver.findElement(By.id("department")).sendKeys("Sistemas");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            submitBtn.click();

            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
            searchBox.sendKeys("Carlos");

            WebElement resultadoTabla = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'rt-tr-group')]//div[text()='Carlos']")));

            String filaTexto = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[contains(@class, 'rt-tr')]//div[text()='Carlos']/parent::div/parent::div")).getText();

            if (filaTexto.contains("Carlos") && filaTexto.contains("Ramirez")) {
                System.out.println("PRUEBA EXITOSA (Ejercicio 5): El nuevo registro (Carlos Ramírez) aparece y se encuentra correctamente mediante la búsqueda.");
            } else {
                System.out.println("PRUEBA FALLIDA (Ejercicio 5): El registro no coincide o no se encontró en la tabla.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error en la ejecución: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
