FROM adoptopenjdk:11-jre-hotspot

VOLUME /app
EXPOSE 8080

ARG JAR_FILE=./build/libs/micasa-api-1.0.jar
ARG POSTGRESS_DATABASE_URL=postgres://postgres:admin@postgres:5432/micasa

ENV DATABASE_URL=$POSTGRESS_DATABASE_URL
ADD ${JAR_FILE} micasa-api.jar

ENTRYPOINT ["java","-jar","/micasa-api.jar"]