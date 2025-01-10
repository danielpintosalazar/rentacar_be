# rentacar_be

**Descripción:** Microservicio backend para una plataforma de alquiler de vehículos.

**Estructura:**

* **car-service:** Gestión de vehículos.
* **eureka-service:** Registro y descubrimiento de servicios.
* **gateway-service:** Puerta de entrada a la API.
* **person-service:** Gestión de usuarios.
* **rental-service:** Gestión de alquileres.

**Tecnologías:**

* Java 21
* Spring Boot
* Spring Cloud

**Ejecución:**

1. **Clonar:** `git clone https://github.com/danielpintosalazar/rentacar_be.git`
2. **Construir:** `cd car-service && mvn clean package` (repetir para cada servicio)
3. **Iniciar:**
   * `cd eureka-service && java -jar target/eureka-service.jar`
   * `cd gateway-service && java -jar target/gateway-service.jar`

**Contribuciones:**

* Forkea el repositorio.
* Crea una nueva rama.
* Realiza cambios y haz commit.
* Envía un pull request.

**Agradecimientos:** 
@danielpintosalazar
@cybergomez
@Omar-Usb
