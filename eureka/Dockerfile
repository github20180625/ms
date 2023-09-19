FROM openjdk:11

ARG JAR_DIR=target
COPY ${JAR_DIR}/eureka-server-0.0.1.jar /app/eureka-server-0.0.1.jar

#EXPOSE 8761

ENTRYPOINT ["java",\
"-jar",\
"/app/eureka-server-0.0.1.jar"]