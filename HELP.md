# People Flow

### Reference Documentation

### Guides

The following guides illustrate how to use some features concretely:

* [Swagger json file](http://localhost:8087/people-flow/v2/api-docs)
* [Swagger web](http://localhost:8087/people-flow/swagger-ui.html#/)

## build docker image
* command -> ./mvnw spring-boot:build-image
* image name -> peopleflow:0.0.1-SNAPSHOT
* run image -> docker run -it -p8087:8087 peopleflow:0.0.1-SNAPSHOT
* after Docker container run you can test swagger