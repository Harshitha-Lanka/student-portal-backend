# Build Stage
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Set working directory inside the image
WORKDIR /app

# Copy source code into the image
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Run Stage
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/student-management-portal-0.0.1-SNAPSHOT.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
