# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.5/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.5/reference/web/servlet.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Docker

To build the Docker image, you can use the following command:

```bash
mvn spring-boot:build-image "-Dspring-boot.build-image.imageName=smoothiemx/sb-ecommerce-course
```

### Running the Application
To run the application, you can use the following command:

```bash
docker run -p 8080:8080 smoothiemx/sb-ecommerce-course
```

### Essentials Docker Commands

There are some essential Docker commands that you might find useful:

* `docker pull <image_name>` - Pull a Docker image from a registry
* `docker push <image_name>` - Push a Docker image to a registry
* `docker run -it -d -p <host-port>:<container-port> --name <container-name> <image-name>` - Run a Docker container in detached mode with port mapping
* `docker start <container-id>` - Start a stopped Docker container
* `docker rm <container-id/container-name>` - Remove a Docker container
* `docker rmi <image-id/image-name>` - Remove a Docker image
* `docker ps` - List running containers
* `docker ps -a` - List all containers (including stopped ones)
* `docker images` - List all Docker images
* `docker exec -it <container-name/container-id> bash` - Execute a shell inside a running Docker container
* `docker build -t <username/image-id> .` - Build a Docker image from the current directory
* `docker logs <container-name/container-id>` - View logs of a Docker container
* `docker inspect <container-name/container-id>` - Inspect a Docker container for detailed information
* `docker stop <container-name/container-id>` - Stop a running Docker container
* `docker restart <container-name/container-id>` - Restart a running Docker container
