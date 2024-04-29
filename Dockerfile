# Use a slim OpenJDK 21 image with Alpine Linux for the build stage
FROM maven:latest AS build

# Set the working directory in the container
WORKDIR /app

# Copy only required Maven files (remove wrapper/mvnw.cmd)
COPY mvnw .mvn

# Copy the project source code and resources
COPY pom.xml .
COPY src src

# Build the application using PowerShell (Windows)
RUN mvn clean package -DskipTests

# Create a new stage based on openjdk:11-jre-slim for the final runtime stage
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the compiled app from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]