FROM openjdk:8-jre-alpine
ENV APP_FILE integration-service-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 9002
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]