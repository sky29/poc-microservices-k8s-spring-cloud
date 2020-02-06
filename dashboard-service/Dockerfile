FROM openjdk:8-jre-alpine
ENV APP_FILE dashboard-service-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 9001
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]