./mvnw spring-boot:build-image
# image name peopleflow:0.0.1-SNAPSHOT
docker run -it -p8087:8087 peopleflow:0.0.1-SNAPSHOT
