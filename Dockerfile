FROM openjdk:17-jdk-alpine

ADD target/product-review-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8094

ENTRYPOINT ["java", "-jar","app.jar"]