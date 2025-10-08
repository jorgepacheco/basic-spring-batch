# Basic Spring Batch

Este es un proceso batch simple desarrollado con Spring Batch y Maven que recibe un nombre y un número como parámetros y muestra un mensaje por consola.

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/batch/
│   │       ├── BatchApplication.java          # Clase principal de la aplicación
│   │       ├── config/
│   │       │   └── BatchConfig.java          # Configuración del job de Spring Batch
│   │       └── processor/
│   │           └── SaludoProcessor.java      # Processor que muestra el mensaje
│   └── resources/
│       └── application.properties            # Configuración de la aplicación
└── test/
```

## Requisitos

- Java 21 o superior
- Maven 3.6 o superior

## Compilación

Para compilar el proyecto:

```bash
mvn clean compile
```

## Ejecución

### Ejecución Local con Maven

Para ejecutar el proceso batch siguiendo las mejores prácticas de Spring Batch:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="nombre=Juan numero=30"
```

### Ejecución con Docker

#### Construir la imagen Docker

```bash
mvn clean package -DskipTests
docker build -t basic-spring-batch:1.0.0 .
```

#### Ejecutar el contenedor

```bash
# Con parámetros por defecto
docker run --rm basic-spring-batch:1.0.0

# Con parámetros personalizados
docker run --rm basic-spring-batch:1.0.0 nombre=Ana numero=25
```

#### Usar Docker Compose

```bash
# Ejecutar con parámetros por defecto
docker-compose up

# Ejecutar con parámetros personalizados
docker-compose --profile custom up
```

## Ejemplos de Uso

1. **Con parámetros personalizados:**
   ```bash
   mvn spring-boot:run -Dspring-boot.run.arguments="nombre=Mundo numero=42"
   # O con Docker:
   docker run --rm basic-spring-batch:1.0.0 nombre=Mundo numero=42
   ```
   Salida: `hola Mundo tiene 42 annos`

2. **Con otros parámetros:**
   ```bash
   mvn spring-boot:run -Dspring-boot.run.arguments="nombre=Ana numero=25"
   # O con Docker:
   docker run --rm basic-spring-batch:1.0.0 nombre=Ana numero=25
   ```
   Salida: `hola Ana tiene 25 annos`

## Parámetros

- **nombre**: Nombre de la persona (formato: `nombre=Valor`)
- **numero**: Edad de la persona (formato: `numero=Valor`)

Los parámetros deben pasarse en formato `clave=valor` separados por espacios.

## Tecnologías Utilizadas

- Spring Boot 2.7.14
- Spring Batch 4.3.8
- H2 Database (en memoria)
- Maven
- Java 21
- Docker
- Docker Compose
