package compra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            Thread.sleep(5000);


            //WebElement mensajeConexion = driver.findElement(By.xpath("//h1[contains(text(),'La conexión no es privada')]"));
            //if (mensajeConexion.isDisplayed()) {

                driver.findElement(By.id("details-button")).click();
                driver.findElement(By.id("proceed-link")).click();
                Thread.sleep(3000);

            //}
            //else {

            // 6. Seleccionar Guest Checkout
                //driver.findElement(By.id("button-account")).click();
                //Thread.sleep(5000);
                //}


            // 6. Seleccionar Guest Checkout
            driver.findElement(By.id("button-account")).click();
            Thread.sleep(5000);

            // 7. Llenar formulario
            driver.findElement(By.id("newsletter")).click();

            driver.findElement(By.name("agree")).click();

            driver.findElement(By.id("input-payment-firstname")).sendKeys("Juan");
            driver.findElement(By.id("input-payment-lastname")).sendKeys("Pérez");
            driver.findElement(By.id("input-payment-email")).sendKeys("alexys8@test.com");
            driver.findElement(By.id("input-payment-telephone")).sendKeys("999888777");
            driver.findElement(By.id("input-payment-address-1")).sendKeys("Av. Siempre Viva 123");
            driver.findElement(By.id("input-payment-city")).sendKeys("Lima");
            driver.findElement(By.id("input-payment-postcode")).sendKeys("15000");
            //driver.findElement(By.id("input-payment-country")).sendKeys("Peru");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[6]/select/option[178]")).click();
            //driver.findElement(By.id("input-payment-zone")).sendKeys("Lima");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[7]/select/option[16]")).click();
            driver.findElement(By.id("input-payment-password")).sendKeys("A1234$$q");
            driver.findElement(By.id("input-payment-confirm")).sendKeys("A1234$$q");


            // 8. Registrar compra
            driver.findElement(By.id("button-register")).click();
            Thread.sleep(3000);

            //9. Metodo de pago
            //driver.findElement(By.name("agree")).click();
            driver.findElement(By.id("button-shipping-address")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("button-shipping-method")).click();
            Thread.sleep(3000);

            //10. Confirmar compra
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.id("button-payment-method")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("button-confirm")).click();
            Thread.sleep(3000);

            // 11. Verificar mensaje final
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
