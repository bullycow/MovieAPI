# Movie REST API

This is a simple Spring based API on a H2 Database, packaged by Maven.This API is meant to represent a Movie type that contains the attributes id (Long), title (String), releaseDate(Timestamp), rating(float), revenue(long).

## Install

    mvn compile

    mvn package

## Run the app

    java -jar target/movie-api-0.0.1-SNAPSHOT.jar


# REST API

The REST API to the example app is described below.

## Get all Movies

Returns a list with all of the movies, stored in the database.

### Request

`GET /movies`

    curl -i -H 'Accept: application/json' http://localhost:8080/movies

### Response

    HTTP/1.1 200 OK
    Date: Wed, 23 Nov 2022 17:52:43 GMT
    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 2

    [
        {
            "id": 1,
            "title": "teste",
            "releaseDate": "2016-10-09T22:17:18.734+00:00",
            "rating": 7.9,
            "revenue": 800000
        }
    ]

## Get Movie by ID

Returns the Movie with the specified id if it exists.

### Request

`GET /movies/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/movies/1

### Response

    HTTP/1.1 200 OK
    Date: Wed, 23 Nov 2022 17:52:43 GMT
    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 2

    {
        "id": 1,
        "title": "teste",
        "releaseDate": "2016-10-09T22:17:18.734+00:00",
        "rating": 7.9,
        "revenue": 800000
    }

## Get Movies Sorted By Release Date

Returns a list with all of the movies sorted, by either ascending or descending order by release date, a for ascending orde, d for descending order.

### Request

`GET /movies/release/{dir}`

    curl -i -H 'Accept: application/json' http://localhost:8080/movies/release/a

    curl -i -H 'Accept: application/json' http://localhost:8080/movies/release/d

### Response

    HTTP/1.1 200 OK
    Date: Wed, 23 Nov 2022 17:52:43 GMT
    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 2

    [
        {
            "id": 1,
            "title": "teste",
            "releaseDate": "2016-10-09T22:17:18.734+00:00",
            "rating": 7.9,
            "revenue": 800000
        }
    ]

## Create a new Movie

Creates a movie in the database.

### Request

`POST /movies`

    curl --header "Content-Type: Application/json" --request POST --data "{\"title\": \"teste3\",\"releaseDate\": \"2016-10-09T22:17:18.734Z\",\"rating\": \"7.9\",\"revenue\": \"800000\"}" http://localhost:8080/movies

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36

    {
        "id": 1,
        "title": "teste3",
        "releaseDate": "2016-10-09T22:17:18.734+00:00",
        "rating": 7.9,
        "revenue": 800000
    }

## Update a Movie

Updates a movie entry with the provided object.

### Request

`PUT /movies/{id}`

    curl --header "Content-type: Application/json" --request PUT --data "{\"title\": \"testeupdt\",\"releaseDate\": \"2016-10-09T22:17:18.734Z\",\"rating\": \"7.9\",\"revenue\": \"800000\"}" http://localhost:8080/movies/1

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:31 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 40

## Delete a Movie

Deletes the Movie entry with the id provided.

### Request

`DELETE /movies/delete/id`

    curl --request DELETE http://localhost:8080/movies/delete/1

### Response

    HTTP/1.1 204 No Content
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 204 No Content
    Connection: close





