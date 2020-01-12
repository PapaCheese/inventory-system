FROM openjdk:8
ADD target/swaggerDemo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "swaggerDemo-0.0.1-SNAPSHOT.jar"]