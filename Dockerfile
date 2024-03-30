# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
# Copy the project files to the container
COPY . .
# Build the application
RUN mvn clean package

# Stage 2: Setup the runtime environment
FROM openjdk:17
WORKDIR /app
# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/simple-calculator-1.0-SNAPSHOT.jar ./app.jar
# Expose the port the app runs on
EXPOSE 8081
# Command to run the application
CMD ["java", "-jar", "app.jar"]