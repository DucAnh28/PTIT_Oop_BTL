FROM gradle:8.4-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon
FROM azul/zulu-openjdk:17-latest
LABEL authors="ducanh"
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]