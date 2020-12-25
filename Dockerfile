FROM openjdk:15

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring