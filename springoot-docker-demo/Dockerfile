FROM eclipse-temurin:17

LABEL mentainer="heltsu@localhost.com"

WORKDIR /app

COPY target/springoot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
