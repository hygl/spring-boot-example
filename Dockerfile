FROM eclipse-temurin:17
RUN mkdir -p /opt/app
COPY target/demo.jar /opt/app/demo.jar
CMD ["java", "-jar", "/opt/app/demo.jar"]