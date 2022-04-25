#Car Fleet Manager

#The specification

Write a REST-based API service that helps to manage car fleet. Users should be able to:
* Add a new car to the fleet. Cars have brands, models, and years of production (of course, you do NOT need to verify if those values make sense!) as well as a Boolean flag that indicates whether the car is on the road (true) or in a garage (false).
* Delete the car from the fleet.
* Return list of all cars in the fleet.
* Change the status of the car (in the road vs. in the garage)

##Additional requirements

* A format of all HTTP POST payloads and returned body should be JSON, encoded as UTF-8.
* The car fleet should be persisted and survive a restart of the service. You can use any persistence method you would like.
* User authentication should rely on HTTP header `Authorization` in the simplest way possible (each unique value of the header is separated fleet).
* You can use any language you have experience with, i.e., mentioned in your CV or LinkedIn.
* You can use any library as a dependency as long as you know how the library works and can justify the choice during discussion.

#Assumptions
* The exercise is implemented in Java with Spring Framework.
* There is only one car fleet.
* Only authenticated users can manage the fleet.
* Can be executed with H2 memory DB or with PostgreSQL (2 environments)
* Users should be add by REST without security
* Users should be authenticated to get the Bearer token to use the Cars API.

#Enviroment
You can configure which environment you want to use in the file  __src/main/resources/application.properties__ . The value can be set to *dev* or *test*

In the file of the environment selected you can set the properties of the DB connection and the JWT key. If you want to persist data in PostgreSQL you should specify the connection attributes.

The server port set in the environment's properties is 8088.

#Endpoints

##Users

Add a user to DB

	* POST /users
		* User entity

Authenticate user to get a token

	* POST /users/authenticate
		* User entity

## Cars

Add a car to the fleet

	POST /cars 
		* Car Entity

Delete a car from the fleet
	
	DELETE /cars/{id}

Get the cars of the fleet
	
	GET /cars

Modify the "on road" status of the car

	PATCH /cars/{id}


## Entities

### User
```json
{
	"user": "admin",
	"pass": "admin"
}
```


### Car
```json
{
	brands: String,
	models: String,
	years: Integer,
	onRoad: Boolean
}
```

##Testing
No test have been develop due to lack of time.

##Possible improvements
* There could be different user roles.
* Different fleets could be managed.
* Tests should be done.
* Request by list of cars on the road or in the garage.
* Search by model, brand or year of the cars.
