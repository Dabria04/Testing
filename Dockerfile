FROM openjdk:24
COPY ./target/DB_Test-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DB_Test-1.0-SNAPSHOT-jar-with-dependencies.jar"]