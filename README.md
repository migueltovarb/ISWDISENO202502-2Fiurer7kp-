# Instrucciones de compilación y ejecución — Backend Gestión de Talleres y Seminarios (Spring Boot)

## ⚙️ Requisitos previos

- Java 17 o superior (JDK)
- Apache Maven 3.6+
- (Opcional) IDE recomendado: IntelliJ IDEA o VS Code

---

## 🚀 Compilación y ejecución

### 1. Clonar el proyecto o descargar archivos

```bash
git clone <REPO_URL>
cd talleres-backend
```
O copia la estructura generada al directorio de trabajo.

### 2. Compilar el proyecto

```bash
mvn clean install
```

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```
ó

```bash
java -jar target/talleres-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Acceso a la API REST

- El backend se expone por defecto en:  
  `http://localhost:8080/api/`

- Ejemplo de endpoints disponibles:
  - `GET /api/eventos`
  - `POST /api/eventos`
  - `GET /api/inscripciones`
  - `POST /api/inscripciones`
  - etc.

---

## 💾 Base de Datos

- Por defecto utiliza **H2 en memoria** (sólo para desarrollo y pruebas).
- Para acceder a la consola H2:
  
  - Ingresa en tu navegador: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  - JDBC url: `jdbc:h2:mem:talleresdb`
  - Usuario: `sa`
  - Password: _(dejar vacío)_

---

## 📝 Cambiar a base de datos PostgreSQL (modo producción)

1. Modifica `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/talleresdb
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
   ```
2. Agrega el driver PostgreSQL en `pom.xml` (descomenta la dependencia).

3. Crea la base de datos `talleresdb` en tu servidor PostgreSQL.

---

## 🧪 Probar la API

Puedes usar [Postman](https://www.postman.com/) o [curl](https://curl.se/):

```bash
curl -X GET http://localhost:8080/api/eventos
```

---

## 👨‍💻 Otros comandos útiles

- **Compilar (sin ejecutar):**
  ```bash
  mvn clean package
  ```
- **Ejecutar pruebas automáticas:**
  ```bash
  mvn test
  ```

---

**¡Listo! Tu backend estará corriendo y disponible en localhost:8080 🚦**