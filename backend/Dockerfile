# --Stage 1: Build (Compilación)--
from maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
# Copiamos pom.xml y descargamos las dependencias
COPY pom.xml .
# Esto es para descargar las dependencias sin compilar todo el proyecto
RUN mvn dependency:go-offline 
# Copiamos el código fuente y compilamos la aplicación
COPY src ./src
# esto es para compilar sin tests
RUN mvn package -DskipTests 

# --Stage 2: Run (Ejecución)--
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copiamos el JAR compilado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]  