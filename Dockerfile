# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/calcola-stipendio-netto.jar app.jar

# Expose the application port (modify if needed)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
