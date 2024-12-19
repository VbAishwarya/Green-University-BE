# Use an official JDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/LNDC_HACK_PROJ-1.0-SNAPSHOT.jar app.jar

# Expose the port your app runs on (replace 8080 if different)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
