FROM openjdk:11

ARG JAR_DIR=target
COPY ${JAR_DIR}/store-0.0.1.jar /app/store-0.0.1.jar

EXPOSE 3001

ENTRYPOINT ["java",\
"-jar",\
"/app/store-0.0.1.jar"]