FROM ghcr.io/graalvm/jdk:22

WORKDIR /opt

COPY target/piggy-bank-api-1.0.0-SNAPSHOT.jar /opt/application.jar

CMD ["java", "-jar", "/opt/application.jar"]

EXPOSE 8080
