README - Ejecución ejercicio 1: CompraTest.java
===============================================

Descripción:
------------
Esta clase `CompraTest` es un script automatizado en Java que simula el flujo de compra en el sitio de demostración
OpenCart (http://opencart.abstracta.us/) utilizando Selenium WebDriver y WebDriverManager.

Requisitos previos:
-------------------
1. Tener instalado Java JDK 8 o superior.
2. Tener instalado Apache Maven (opcional pero recomendado para manejo de dependencias).
3. Tener acceso a Internet para que WebDriverManager pueda descargar automáticamente el ChromeDriver.
4. Tener instalado Google Chrome.

Dependencias necesarias (pom.xml si usas Maven):
------------------------------------------------
<dependencies>
    <!-- Selenium Java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.21.0</version>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.9.2</version>
    </dependency>
</dependencies>

Ejecución:
----------
1. Clonar o copiar el código en un proyecto Java.
2. Agregar las dependencias mencionadas en el `pom.xml` (si se usa Maven).
3. Ejecutar la clase `CompraTest` desde el IDE o con Maven:
   mvn exec:java -Dexec.mainClass="compra.CompraTest"
4. El campo "input-payment-email" linea 69 se debe modificar en cada ejecución (email del usuario) porque la web valida que se encuentra reegistrado y se va por otro flujo que no esta automatizado.

Flujo que automatiza:
----------------------
1. Abre el sitio de OpenCart.
2. Agrega primer producto un MacBook y un
3. Agregar segundo producto iPhone al carrito.
4. Accede al carrito
5. y procede al checkout.
6. Selecciona el registro como usuario invitado o registro directo.
7. Llena el formulario con datos ficticios.
8. Registra compra
9. Selecciona el método de pago y confirma la compra.
10. Confirma compra
11. Verifica que aparezca el mensaje de confirmación: "Your order has been placed!".

Notas importantes:
-------------------
- Si la página muestra un mensaje de conexión insegura, el script lo maneja haciendo clic en "Avanzado" y luego "Proceder". caso contrario comentar lineas de la 45 al 47
- El código está adaptado para un flujo de ejemplo; si la página cambia, los selectores podrían necesitar ajustes.
- Se puede realizar mejoras usando el patron de diseño The Page Object Model (POM) y agregando repositorio de datos (excel,BD, etc) de donde se obtenga y valide la información que se envia o se muestra en los formularios.


Ejecución de ejercicio 2: Karate API Testing (PetStore)
=======================================================

Descripción:
------------
Pruebas de API REST usando Karate para la documentación de la PetStore:
- Crear usuario
- Buscar usuario
- Actualizar usuario
- Buscar usuario actualizado
- Eliminar usuario

Requisitos
-----------

- Java 11 o superior
- Maven instalado y configurado
- IntelliJ IDEA
- Conexión a Internet

Estructura de Archivos
-----------------------

src/test/java/
  └── petstore/
       └── KarateRunner.java
    └── resources
            └── petstore_usuario
pom.xml

Dependencias Maven
----------------------
<dependencies>
    <!-- Karate -->
    <dependency>
        <groupId>com.intuit.karate</groupId>
        <artifactId>karate-junit5</artifactId>
        <version>1.4.0</version>
        <scope>test</scope>
    </dependency>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.9.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.9.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>

Ejecución en IntelliJ
---------------------

1. Clonar el repositorio.
2. Importar como proyecto Maven.
3. Colocar `petstore_usuario.feature` en `src/test/resources/petstore`.
4. Asegurarse que exista `KarateRunner.java` 
5. Hacer clic derecho sobre `KarateRunner.java` → `Run`.

Nota importantes:
------------------
Los resultados se pueden visualizar a traves del archivo karate-summary.html que se genera en la carpeta del proyecto "...\target\karate-reports"
