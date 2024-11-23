### Documentación del Proyecto Spring Boot

### **Resumen**
El proyecto está estructurado de manera modular, separando responsabilidades como configuración, controladores, excepciones, modelos, repositorios y servicios. La configuración de la base de datos se maneja a través de un archivo `.env` cargado por la clase `EnvConfig`. Este enfoque facilita el mantenimiento, escalabilidad y seguridad del proyecto.

---

#### **Estructura del Proyecto**
El proyecto tiene la siguiente estructura básica:

```
.mvn/
.vscode/
src/
  main/
    java/com/api/app/rest/
      config/
      controller/
      exception/
      model/
      repository/
      service/
    resources/
      static/
      templates/
      application.properties
      application.yml
.env
.gitignore
```

A continuación, se detalla la funcionalidad de cada carpeta y archivo:

---

#### **1. `.mvn/`**
Contiene archivos relacionados con Maven, como configuraciones específicas del proyecto y del entorno de desarrollo.

#### **2. `.vscode/`**
Carpeta con configuraciones específicas de Visual Studio Code, como extensiones recomendadas y ajustes para facilitar el desarrollo del proyecto.

#### **3. `src/main/java/com/api/app/rest/`**
Este es el paquete base de la aplicación. Contiene todos los archivos fuente organizados en subpaquetes según sus responsabilidades:

- **`config/`**
  - Contiene clases relacionadas con la configuración del proyecto.
  - Ejemplo:
    - **`EnvConfig.java`**: Carga las variables de entorno desde el archivo `.env` y las establece como propiedades del sistema. También valida que las variables necesarias estén presentes.

- **`controller/`**
  - Contiene los controladores REST que manejan las solicitudes HTTP.
  - Ejemplo:
    - **`UserController.java`**: Define los endpoints relacionados con la gestión de usuarios.

- **`exception/`**
  - Contiene clases personalizadas para el manejo de excepciones.
  - Ejemplo:
    - **`ResourceNotFoundException.java`**: Excepción lanzada cuando no se encuentra un recurso solicitado.

- **`model/`**
  - Contiene las clases que representan las entidades de la base de datos.
  - Ejemplo:
    - **`User.java`**: Clase que mapea la entidad `User` con sus atributos.

- **`repository/`**
  - Contiene interfaces de repositorios JPA para interactuar con la base de datos.
  - Ejemplo:
    - **`UserRepository.java`**: Proporciona métodos para realizar operaciones CRUD en la tabla de usuarios.

- **`service/`**
  - Contiene la lógica de negocio y servicios.
  - Ejemplo:
    - **`UserService.java`**: Interfaz para las operaciones de usuario.
    - **`UserServiceImpl.java`**: Implementación de los métodos definidos en la interfaz `UserService`.

---

#### **4. `src/main/resources/`**
Contiene recursos estáticos y archivos de configuración:

- **`static/`**
  - Carpeta para archivos estáticos como imágenes, CSS o JavaScript.

- **`templates/`**
  - Carpeta destinada a archivos de plantillas (HTML o Thymeleaf) si se usa un motor de plantillas.

- **`application.properties`** y **`application.yml`**
  - Archivos de configuración de Spring Boot. En este proyecto, se utiliza `application.yml` para definir propiedades como la conexión a la base de datos.

---

#### **5. `.env`**
Archivo que contiene las variables de entorno utilizadas para la configuración del proyecto. Estas variables son cargadas por `EnvConfig.java`. Es útil para mantener datos sensibles, como credenciales, fuera del código fuente.

---

#### **6. `.gitignore`**
Archivo que lista los archivos y carpetas que deben ser ignorados por Git, como `target/` y configuraciones locales.

---

### **Configuración Inicial**

#### **Requisitos**
#### **Requisitos**
- **Java**: Versión 21 o superior.
- **Maven**: Instalado y configurado.
- **Base de Datos MySQL**: En funcionamiento.
- **Crear un archivo `.env`**: En la raíz del proyecto.

#### **Dependencias**
1. **`spring-boot-starter-data-jpa`**: Para trabajar con JPA y persistencia de datos.
2. **`spring-boot-starter-web`**: Para desarrollar APIs RESTful.
3. **`dotenv-java`**: Maneja variables de entorno desde un archivo `.env`.
4. **`mysql-connector-j`**: Proporciona el conector para interactuar con bases de datos MySQL.
5. **`lombok`**: Reduce el código repetitivo, como getters, setters y constructores.
6. **`spring-boot-starter-test`**: Incluye herramientas para realizar pruebas en el proyecto.

#### **Variables del Archivo `.env`**
El archivo `.env` debe incluir las siguientes variables para la conexión a la base de datos:

```env
DB_URL=jdbc:mysql://localhost:3306/exampledb
DB_USERNAME=root
DB_PASSWORD=root
```

#### **Pasos para Configuración**
1. Crear la base de datos `userdb` en MySQL.
   ```sql
   CREATE DATABASE userdb;
   ```
2. Configurar las variables en `.env` con las credenciales correctas.
3. Verificar que `EnvConfig.java` esté cargando y validando las variables correctamente al inicio del proyecto.
4. Ejecutar el proyecto con:
   ```bash
   mvn spring-boot:run
   ```

---

### **Validación de la Configuración**
Al iniciar la aplicación, verifica en la consola un mensaje como:

```
✅ Conexión configurada correctamente desde el archivo .env
```

Si faltan variables, deberías ver un error:

```
❌ Faltan variables de conexión en el archivo .env
```

---

