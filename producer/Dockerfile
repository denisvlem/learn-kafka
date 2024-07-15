FROM bellsoft/liberica-openjdk-centos:21-cds

ENV LANG=C.UTF-8
EXPOSE 8080
WORKDIR /var/app
COPY ./target/producer-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]