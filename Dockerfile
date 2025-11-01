# Use an official Maven image with OpenJDK 21 for building
FROM openjdk:21-jdk-slim AS builder

# Set the working directory
WORKDIR /app

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Copy the pom.xml and source code
COPY pom.xml ./
COPY src ./src


# Package the application
RUN mvn clean package -DskipTests

# Use a lightweight Java runtime image to run the application
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
