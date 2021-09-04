FROM gradle:7.2.0-jdk8
WORKDIR /app
ADD --chown=gradle:gradle . /app
ENTRYPOINT ./gradlew bootRun