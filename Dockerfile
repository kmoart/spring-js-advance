FROM openjdk:25-ea-1-jdk-oracle

WORKDIR /app

COPY "./target/spring-js-advance-0.0.1-SNAPSHOT.jar" "spring-js-advance.jar"

EXPOSE 8080

ENTRYPOINT ["java","-jar","spring-js-advance.jar","--spring.profiles.active=docker"]