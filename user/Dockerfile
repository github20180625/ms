FROM openjdk:11

ARG JAR_DIR=target
COPY ${JAR_DIR}/user-0.0.1.jar /app/user-0.0.1.jar

EXPOSE 2001

ENTRYPOINT ["java",\
"-jar",\
"/app/user-0.0.1.jar"]