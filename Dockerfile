FROM azul/zulu-openjdk:17-latest
LABEL authors="ducanh"
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]