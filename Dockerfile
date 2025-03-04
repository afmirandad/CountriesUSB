FROM openjdk:17

WORKDIR /app

COPY target/CountriesUSB-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8282

ENTRYPOINT ["java", "-jar", "app.jar"]