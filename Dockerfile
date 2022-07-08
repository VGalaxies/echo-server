FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} echo-server.jar
ENTRYPOINT ["java","-jar","/echo-server.jar"]