FROM openjdk:17-alpine
COPY ./target/Issue_ticket_tracker-*-SNAPSHOT.jar service.jar
CMD java -jar service.jar