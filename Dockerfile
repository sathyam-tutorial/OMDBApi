FROM dockiran/kubuntu
RUN mkdir $HOME/simple-mobile-app
RUN ls -ltr $HOME/simple-mobile-app
RUN pwd
RUN cp ./build/libs/simple-mobile-app.jar $HOME/simple-mobile-app/
RUN apt-get -y update
RUN \
  apt-get -y update && \
  apt-get -y install default-jre && \
  apt-get -y install default-jdk && \
  ln -s /usr/lib/jvm/java-11-openjdk-amd64 /usr/src/java7 && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer && \
  java -version

ENV JAVA_HOME /usr/src/java7
RUN echo "Listing $HOME/simple-mobile-app"
RUN ls -ltr $HOME/simple-mobile-app/simple-mobile-app.jar
RUN java -cp $HOME/simple-mobile-app/simple-mobile-app.jar mobile.customers.data.mobileProject