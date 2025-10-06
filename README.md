# Google Scholar API Integration with Spring Boot

This project is a Spring Boot application that integrates with SerpAPI to fetch author information and related articles from Google Scholar. The main goal is to query authors, retrieve their articles, and store the results in a JSON format.

## Features
### Article
- Fetches data from Google Scholar using SerpAPI.
- Stores retrieved articles with the following attributes:
- id: unique identifier
- title: article title
- authors: list of authors, separated by commas
- publication_date: date when the article was published
- link: direct link to the article
- cited_by: number of citations (if available)
### Author
- author_Id: unique identifier
- name: name of the author
- email: email of the author
- website: website of the author
- totalCitations: Total citations for all articles
- interests: list of interests, separated by commas

## Architecture

The project follows the MVC (Model–View–Controller) design pattern to ensure separation of concerns:

- Model: Defines the data structure for authors and articles.
- View: Provides a simple interface to display the queried results.
- Controller: Handles user requests, interacts with the services, and returns responses.
- Services: Responsible for parsing JSON from SerpAPI, converting it, and storing it in the database.

## Documentation & Testing

- The code is documented with clear explanations of classes and methods.
- Includes unit tests to validate functionality.

## Database Integration

The application creates and maintains a database to store article information. Data is automatically inserted after queries to SerpAPI. A dedicated table is used to store articles with all required fields.

Technology Stack

- Spring Boot (backend framework)
- Java (language)
- SerpAPI (to fetch Google Scholar data)
- JPA / Hibernate (ORM for database interaction)
- Postman (for testing)

# Use
You need to create application.properties file to setup the following configurations

spring.application.name=demo
spring.datasource.url=jdbc:postgresql://localhost:5432/serpapi
spring.datasource.username=postgres
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
serpapi.api.key="YOUR_API_KEY"