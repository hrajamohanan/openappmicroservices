FROM maven:alpine 
MAINTAINER Ranajit Jana <ranajit.jana@wipro.com> 
EXPOSE 8888 
COPY . /opt/spring-cloud-config-server/
WORKDIR /opt/spring-cloud-config-server/
RUN mvn package
ARG SPRING_CLOUD_CONFIG_SERVER_GIT_URI
WORKDIR /
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar",\
            "/opt/spring-cloud-config-server/target/spring-cloud-config-server.jar",\
            "--spring.cloud.config.server.git.uri==$SPRING_CLOUD_CONFIG_SERVER_GIT_URI", \
            "--server.port=8888",\
            "--spring.config.name=application"]