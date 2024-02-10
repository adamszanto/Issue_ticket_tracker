FROM openjdk:17-alpine
COPY ./target/Issue_ticket_tracker-*-SNAPSHOT.jar service.jar
#EXPOSE 8080 2 docker container egymás közötti kommunikációhoz port expose kell. Az expose = Egy másik container számára nyitja meg adott portot
CMD java -jar service.jar