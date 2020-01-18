FROM dockiran/kubuntu
ARG VERSION='1.0-SNAPSHOT'
ARG APPNAME='simple-mobile-app'

RUN mkdir -p $HOME/${APPNAME}
COPY runMobileApp.sh /root/simple-mobile-app/
RUN chmod u+x $HOME/${APPNAME}/runMobileApp.sh
RUN ls -ltr $HOME/${APPNAME}
RUN \
  apt -y update && \
  apt -y upgrade && \
  apt -y install curl
RUN curl --version
RUN curl -u username:pwd \
http://docker.for.mac.localhost:8081/artifactory/gradle-dev-local/mobile/customers/data/${APPNAME}/${VERSION}/${APPNAME}-${VERSION}.jar \
--output $HOME/${APPNAME}/${APPNAME}-${VERSION}.jar
RUN apt-get -y update
RUN \
  apt-get -y update && \
  apt-get -y install default-jre && \
  apt-get -y install default-jdk && \
  ln -s /usr/lib/jvm/java-11-openjdk-amd64 /usr/src/java7 && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer && \
  java -version

ENV JAVA_HOME /usr/bin/java
ENV VERSION ${VERSION}
ENV APPNAME ${APPNAME}

RUN echo "Listing $HOME/${APPNAME}"
RUN ls -ltr $HOME/${APPNAME}/${APPNAME}-${VERSION}.jar

ENTRYPOINT $HOME/${APPNAME}/runMobileApp.sh