# Issue Ticket Tracker

Ticket Management System
This is a Spring Boot REST application designed to manage tickets. It allows users to add, update, and delete tickets, as well as modify their details such as title, detail, status, events, and priorities.

Features
Add Ticket: Users can create a new ticket by providing the title, detail, status, events, and priorities. The ticket will be added to the list of existing tickets.

Update Ticket: Users can update the details of an existing ticket, including the title, detail, status, events, and priorities. The changes will be saved and reflected in the ticket.

Delete Ticket: Users can delete a ticket from the system. Once deleted, the ticket will be removed from the list of tickets.

Technologies Used
Java: The application is built using the Java programming language.
Spring Boot: It is a framework used to develop Java applications quickly and easily, providing features like auto-configuration and embedded servers.
REST: The application follows the REST architectural style to expose the functionality as a set of web services.
Hibernate: It is used as an ORM (Object-Relational Mapping) tool to simplify database operations.
MySQL: The data is stored in a MySQL database.

API Endpoints
The following API endpoints are available:

GET /tickets: Retrieve all tickets.
POST /tickets: Create a new ticket.
GET /tickets/{id}: Retrieve a specific ticket by ID.
PUT /tickets/{id}: Update the details of a specific ticket.
DELETE /tickets/{id}: Delete a specific ticket.
