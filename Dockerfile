# Use an Amazon Corretto 17 base image
FROM amazoncorretto:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container at the working directory
COPY target/authentication-service-1.0.0.jar /app/authentication-service-1.0.0.jar

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "authentication-service-1.0.0.jar"]
