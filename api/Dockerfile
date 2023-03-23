FROM maven:3.8-jdk-17-slim AS build
WORKDIR /api
COPY src /api/src
COPY pom.xml /api
COPY mvnw /api
RUN mvn -f /api/pom.xml clean package

FROM openjdk:17-jre-slim
COPY --from=build app/target/dac-0.0.1-SNAPSHOT.jar /app/dac-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/dac-0.0.1.jar"]