FROM openjdk:17
WORKDIR /usr/src/app
COPY target/simple-calculator-1.0-SNAPSHOT.jar /usr/src/app
EXPOSE 8080
CMD [ "java", "-jar", "simple-calculator-1.0-SNAPSHOT.jar" ]