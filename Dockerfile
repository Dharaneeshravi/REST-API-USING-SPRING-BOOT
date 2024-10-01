FROM openjdk:21
ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} REST-API.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/REST-API.jar"]