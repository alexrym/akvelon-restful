FROM openjdk:11
ARG JAR_FILE=target/app.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
CMD ["java","-jar","app.jar"]