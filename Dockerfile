FROM openjdk:14-alpine
COPY build/libs/mn-data-example-*-all.jar mn-data-example.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "mn-data-example.jar"]