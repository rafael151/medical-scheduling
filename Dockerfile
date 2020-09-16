FROM openjdk:11

ENV APP=/home/app/

WORKDIR $APP

COPY target/medical-scheduling-0.0.1-SNAPSHOT.jar  $APP/app.jar

CMD ["java", "-jar", "app.jar"]
