FROM maven:3.6.3-jdk-8 as builder
COPY ./ ./
RUN mvn package
FROM adoptopenjdk/openjdk8:latest
COPY --from=builder /target/dai.jar /opt/dai.jar
ENTRYPOINT ["java","-jar","-Dserver.port=9090","/opt/dai.jar"]