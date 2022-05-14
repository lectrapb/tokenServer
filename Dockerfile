# Build stage
FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR usr/src/app
COPY . ./
RUN  mvn clean package -DskipTests

# Package stage
FROM openjdk:11-jre-slim
ARG JAR_NAME="authServer-0.0.1"
WORKDIR /usr/src/app
EXPOSE ${HTTP_PORT}
COPY --from=build /usr/src/app/target/${JAR_NAME}.jar ./spring-boot-backend-chat.jar
CMD ["java","-jar", "./spring-boot-backend-chat.jar"]