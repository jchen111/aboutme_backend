FROM java:8
MAINTAINER Jiaqi Chen <jackychen901010@gmail.com>
VOLUME /tmp
ADD aboutmebackend-0.1.0.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
