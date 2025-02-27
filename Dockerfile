FROM azul/zulu-openjdk:17-latest
LABEL authors="ducanh"
VOLUME https://docs.railway.com/reference/volumes
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]