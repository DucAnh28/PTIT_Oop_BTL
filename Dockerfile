FROM azul/zulu-openjdk:17-latest
LABEL authors="ducanh"
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]