FROM ubuntu
EXPOSE 8087
MAINTAINER peopleflow
ARG JAR_FILE=target/people-flow.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]