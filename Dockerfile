FROM java:8
VOLUME /tmp
ADD producer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Denvironment=**{$HOST_IP,$SERVER_CITY_NAME}**"]

