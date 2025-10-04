FROM eclipse-temurin:17-jre

WORKDIR /app

COPY ../../../../Desktop/doevida-back-end/target/doevida-back-end-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]