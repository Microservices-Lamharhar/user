
FROM openjdk:17
WORKDIR /app
ADD target/user-0.0.1-SNAPSHOT.jar user.jar 
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "user.jar"]
