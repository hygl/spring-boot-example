FROM maven:3-jdk-11 as BUILD

COPY . /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jre-slim
ENV SERVER_PORT 4357
EXPOSE 4357
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target

CMD ["/bin/bash", "-c", "find -type f -name 'demo*.jar' | xargs java -jar"]
