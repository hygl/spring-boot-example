FROM openjdk:8
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN ./mvnw clean package -DskipTests=true
EXPOSE 8080
USER 1001
CMD ["/bin/bash", "-c", "find -type f -name 'demo*.jar' | xargs java -jar"]
