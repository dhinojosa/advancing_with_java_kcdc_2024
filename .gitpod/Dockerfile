# Use Gitpod's base image
FROM gitpod/workspace-full:latest

# Install OpenJDK 21
RUN sudo apt-get update && \
    sudo apt-get install -y openjdk-21-jdk

# Install Maven 3.8.6
RUN sudo apt-get update && \
    sudo apt-get install -y wget && \
    wget https://archive.apache.org/dist/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz && \
    sudo tar -xzf apache-maven-3.8.6-bin.tar.gz -C /opt && \
    sudo ln -s /opt/apache-maven-3.8.6 /opt/maven && \
    sudo ln -s /opt/maven/bin/mvn /usr/bin/mvn && \
    rm apache-maven-3.8.6-bin.tar.gz

# Set Maven environment variables
ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH
