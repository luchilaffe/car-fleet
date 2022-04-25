FROM openjdk:11

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/car-fleet-0.0.1-SNAPSHOT.jar"]