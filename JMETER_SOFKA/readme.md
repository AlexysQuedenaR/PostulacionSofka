Creación de prueba de rendimiento Ejercio 1
===========================================
1. Clonar o copiar el archivo LOGIN_SOFKA.jmx a la PC donde se tiene el proyecto de JMETER
2. Crear una carpeta File con el archivo usuarios.csv
3. En configuración del Data CSV Data Set agregar la ruta del archivo usuarios (...\files\usuarios.csv)
4. En Grupo de Hilos configurar Número de Hilos = 10, Periodo de subida = 2 y contador bucle = 60 (periodo de tiempo de la prueba)
5. En sumary report agregar la ruta con Nombre del archivo para guardar los resultado (...\files\textSummary.txt)
6. En reporte Transactions per seconds agregar la ruta Nombre de archivo para guardar los resultados (...\files\TPS_SOFKA.csv)

Resultado esperado
------------------
7. Debe haber un imcremento minimo de 20 tps
8. Total peticiones = Número de hilos × Contador de bucle / Total peticiones = 10 × 60 = 600 peticiones

Analisis de resultado del Ejercio 2
===================================
Estado de las transacciones
---------------------------
1. El mensaje inicial indica que la respuesta de App Transaction Balance fue OK.
2. El 97.55 % de las verificaciones fueron exitosas (checks), lo que significa que un 2.44 % falló.

Datos enviado
-------------
3. Datos recibidos: 842 MB totales a una media de 223 kB/s.
4. Datos enviados: 588 MB totales a una media de 156 kB/s.

Errores y fallos
----------------
5. Tasa de fallo: 2.44 % de las solicitudes (failed_request).

Errores por código HTTP:
------------------------
6. HTTP 4xx (cliente): 769 en la etapa 1.
7. HTTP 5xx (servidor): 5987 en la etapa 1 y 2 en la etapa 2.

Tiempos de respuesta (latencia)
-------------------------------
8. Duración HTTP promedio: 861 ms (máx ≈ 29.93 s).

Carga concurrente
-------------------
9. Usuarios virtuales (vus): mínimo 2, máximo 140.

