package compra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompraTest {

    public static void main(String[] args) {
        // Configurar ChromeDriver automáticamente
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        try {
            // 1. Abrir la página
            driver.manage().window().maximize();
            driver.get("http://opencart.abstracta.us/");
            System.out.println("Página abierta: " + driver.getTitle());

            // 2. Agregar primer producto
            driver.findElement(By.linkText("MacBook")).click();
            driver.findElement(By.id("button-cart")).click();
            driver.navigate().back();

            // 3. Agregar segundo producto
            driver.findElement(By.linkText("iPhone")).click();
            driver.findElement(By.id("button-cart")).click();

            // 4. Ver carrito
            driver.findElement(By.id("cart")).click();
            driver.findElement(By.linkText("View Cart")).click();

            // 5. Ir a Checkout
            driver.findElement(By.linkText("Checkout")).click();

            // 6. Seleccionar Guest Checkout
            driver.findElement(By.xpath("//input[@value='guest']")).click();
            driver.findElement(By.id("button-account")).click();

            // 7. Llenar formulario
            driver.findElement(By.id("input-payment-firstname")).sendKeys("Juan");
            driver.findElement(By.id("input-payment-lastname")).sendKeys("Pérez");
            driver.findElement(By.id("input-payment-email")).sendKeys("juan@test.com");
            driver.findElement(By.id("input-payment-telephone")).sendKeys("999888777");
            driver.findElement(By.id("input-payment-address-1")).sendKeys("Av. Siempre Viva 123");
            driver.findElement(By.id("input-payment-city")).sendKeys("Lima");
            driver.findElement(By.id("input-payment-postcode")).sendKeys("15000");
            driver.findElement(By.id("input-payment-country")).sendKeys("Peru");
            driver.findElement(By.id("input-payment-zone")).sendKeys("Lima");
            driver.findElement(By.id("button-guest")).click();

            // 8. Confirmar compra
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.id("button-payment-method")).click();
            driver.findElement(By.id("button-confirm")).click();

            // 9. Verificar mensaje final
            WebElement mensaje = driver.findElement(By.xpath("//h1[contains(text(),'Your order has been placed!')]"));
            if (mensaje.isDisplayed()) {
                System.out.println("✅ Compra realizada con éxito");
            } else {
                System.out.println("❌ No se pudo confirmar la compra");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 10. Cerrar navegador
            driver.quit();
        }
    }
}
