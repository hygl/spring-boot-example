FROM ubuntu:latest AS dev
LABEL location="/"
RUN apt-get update && apt-get install -y --no-install-recommends openjdk-11-jdk maven && rm -rf /var/lib/apt/lists/*
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package -DskipTests=true 

FROM ubuntu:latest
RUN apt-get update && apt-get install -y --no-install-recommends openjdk-11-jre-headless && rm -rf /var/lib/apt/lists/*
LABEL location="/"
COPY --from=dev /usr/src/app/target/*.jar /usr/src/app/app.jar
WORKDIR /usr/src/app
ENV SERVER_PORT 8080
EXPOSE 8080
USER 1001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
