# Usar OpenJDK 21 como imagen base
FROM openjdk:21-jdk-slim

# Información del mantenedor
LABEL maintainer="jorgepacheco@example.com"
LABEL description="Spring Batch Application - Basic Greeting Process"

# Crear directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de la aplicación
COPY target/basic-spring-batch-1.0.0.jar app.jar

# Configurar variables de entorno
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SPRING_PROFILES_ACTIVE=""

# Comando de entrada por defecto
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar \"$@\"", "--"]

# Argumentos por defecto para el proceso batch
CMD ["nombre=Mundo", "numero=42"]
