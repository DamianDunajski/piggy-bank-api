FROM ghcr.io/graalvm/jdk:22

WORKDIR /opt

COPY target/spring-boot-demo-0.0.1-SNAPSHOT.jar /opt/application.jar

CMD ["java", "-jar", "/opt/application.jar"]

EXPOSE 8080
