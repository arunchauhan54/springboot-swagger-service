FROM anapsix/alpine-java
EXPOSE 8080
RUN mkdir -p /app/
ADD  build/libs/exercise-0.0.1-SNAPSHOT.jar /app/exercise-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/exercise-0.0.1-SNAPSHOT.jar"]