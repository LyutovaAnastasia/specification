FROM openjdk:16-alpine3.13
ADD target/specification-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]