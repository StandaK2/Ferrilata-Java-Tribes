# Tribes - Spring Backend

## Description

The purpose of this project is to create backend part of a strategy game based on the logic of [Travian](http://travian.com/). The application user will be an owner of a kingdom after the registration. The user has gold and food resources to feed the army, and to build a Farm, an Academy or a Mine. All the generation are time based, creating troops, buildings or upgrading them takes time based on levels. Users can attack, and occupy each others kingdom. There is a leaderboard where the users can monitor their progress.

#### See also:
 - [game rules description](docs/rules.md)
 - [model specification](docs/models.md)
 - [API specification](docs/api-spec.md)

## Technologies

In this project the apprentices basically are using SpringBoot Framework. First they build the basics of the application and create connection with MySQL database. They use Flyway for the database migration, and make the authentication and authorization flow based on Spring Security with JWT. After implementing the game logic,they test the whole service layer, deploy the API, and make the connection with the frontend.

- SpringBoot
- Gradle
- JPA
- MySQL
- Flyway for database migration
- JWT Authentication
- Mockito mock framework for unit testing
- MockMVC for integration testing
- CI/CD
	- CricleCI
	- Heroku
