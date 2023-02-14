FROM amazoncorreto:11-alpine-jdk
MAINTAINER JorgeO
COPY target/jomc-0.0.1-SNAPSHOT.jar jor-app.jar
ENTRYPOINT ["java","-jar","/jor-app.jar"]
