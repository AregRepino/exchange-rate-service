FROM openjdk:11.0.8-jdk-slim
ADD build/libs/*.jar ./
EXPOSE 9009
ENTRYPOINT [ "java" ]
CMD [ "-jar", "exchange-rate-service-1.0-SNAPSHOT.jar" ]