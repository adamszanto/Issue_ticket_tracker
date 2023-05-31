FROM openjdk:17-alpine

RUN apk --no-cache add curl

COPY ./target/Issue_ticket_tracker*.jar App.jar

CMD ["java","-jar","App.jar"]