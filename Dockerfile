# **Bước 1: Dùng Gradle để build JAR**
FROM gradle:8.4-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon

# **Bước 2: Chạy ứng dụng với JDK nhẹ**
FROM azul/zulu-openjdk:17-latest
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
