# Choonz v2

Choonz version 2 contains improvements from the [original](https://github.com/bulbicx/SDET-finalproj-team3) group project. It is a Music Library Web Application that it has been tasked to create for the final project of the SDET course. 
The project aims at viewing different artists, albums, genres, tracks and playlists. Registered users are able to create, update and delete a playlist. Authenticated admins are able do any of the CRUD functionality for artists, albums, genres and tracks. 
The purpose of this project was not only to demonstrate abilities at creating a full stack web application from scratch, but to also at demonstrating abilities to different type of testing.
In particular the application has been tested with Unit testing, Integration testing, User Acceptance testing and non-functional testing.
This application uses MySQL as data storage, Spring-Boot framework for the Backend and a combination of HTML, CSS and JavaScript for the Frontend. Testing makes use of selenium web driver, cucumber and jmeter.

## Original Work

The Choonz website allows a visitor to read all of the entities. It allows logged in users to CRUD their own playlists and an admin user to CRUD all the entities.
Although the original project was working under all aspects, there were some little adjustments and fixes to make, which for the time frame we were given, they
could not have been applied to the original project.

## Improved Work

The Choonz v2 has been improved under various aspects. In particular:

- Login and Signup have been redesigned
- Playlist detail page had fixes:
    - add track - dropdown list takes all available tracks but not the already added tracks on playlist(originally also tracks inside the playlist were shown).
    - remove a track - dropdown list displays only tracks from the list(originally all existing tracks were displayed)
- Cards with details have been redesigned with a new hover effect
- Artist page now takes uploaded image(originally was static as uploaded image was not working)
- Home page now displays cover images for playlists, genres, artists, tracks and albums(originally cover images had static URL image)
- Search function has been added to Artist, Album, Playlist and Genre pages so it is easier for the user to find what they are looking for.
- Testing coverage improvements(originally it was set at 72%)
- All testing succeed(originally there were some tests that failed due to last minute changes on the front-end) 

### Client Requirements

#### General
- Multiple users can sign up to the system
- The styling of the entire site should be consistent 
- Users can browse the system without logging in, but won’t be able to CRUD
- It would be nice to be able to search for a specific track, album, or artist
#### User Home Screen
- Users can CRUD albums, artists, tracks and genres
- Users should see cards for each playlist on their home screen
#### Albums
- Users should view each album on its own page
- The album should contain a list of songs
- The albums page should contain a link to the artist page
- Each track should link to a track page
#### Artists
- Users should view each artist on its own page
- The artist should contain a list of albums
- Each album should link to an album page
#### Tracks
- Users should view each track on its own page
- The track page should show the name, lyrics, and genre
- The track page should contain links to the relevant album and artist
#### Genres
- Users should view each genre on its own page
- The genre should contain a list of tracks
- Each track should link to a track page
#### Playlists
- A user can CRUD as many playlists as they like on their home screen
- Users should CRUD their own playlists either by song id, name, or genre
#### Non-Functional Testing
- Response times should be < 10 milliseconds
- Latency should be < 2 seconds at 10000 concurrent users 
- Throughput rate should be > 300/s 
- RAM allocation should be minimal, with few (if any) memory leaks
- The application should be spike-, load-, stress-, and soak-tested

## Prerequisites:

To use this application you will need:
- Java Verison 11 (or newer)
- Eclipse or IntelliJ IDE installed
- MySQL Server 8.0+
- Visual Studio Code
- Spring Boot and Maven installed locally

For testing purposes:
- JMeter installed locally 

## Getting Started

Given that you achieve the prerequisites, to set up development you will need to:
1. Clone this repository into an IDE of your choice, preferably Eclipse.
2. Convert the project into a Maven Project (optional depending on how you cloned the repository).
3. Run the project as a Spring Boot Application.
4. The application is hosted as 'localhost:8082/' OR can be run as a live server from any HTML page using Visual Studio Code.

## Running the Tests

The tests can be run on Eclipse, this can be done by right-clicking on the project and running it as a JUnit test. User Acceptance Tests can be run individually by using tags or run them all without their use (Default).
Non-functional testing is covered in the **src/test/resouces/jmeter**. The .jmx files can be opened and ran inside JMeter.

## Test Coverage

![TestCoverage](https://user-images.githubusercontent.com/85874648/132004138-bbb20be7-4b2a-40fe-ba08-ce216a66623a.PNG)

## Authors

### Training Team

- **Client** - [**Angelica Charry**](https://github.com/acharry) - **Software Delivery Manager**
- **Product Owner** - [**Nick Johnson**](https://github.com/nickrstewarttds) - **Initial work (backend & frontend development, specification)**
- **Product Owner** - [**Edward Reynolds**](https://github.com/Edrz-96) - **Initial work (testing, specification)**
- [**Jordan Harrison**](https://github.com/JHarry444) - **General Java wizardry**
- [**Alan Davies**](https://github.com/MorickClive)
- [**Savannah Vaithilingham**](https://github.com/savannahvaith)
- [**Vinesh Ghela**](https://github.com/vineshghela)
- [**Piers Barber**](https://github.com/PCMBarber)

### Original Development Team

- [**Leaf Cooper**](https://github.com/leaf-cooper-qa)
- [**Marco Castellana**](https://github.com/bulbicx)
- [**Niall Duggan**](https://github.com/nduggan-dev)
- [**David Indiongco**](https://github.com/dindiongco) 

### Improvements Development Team

- [**Marco Castellana**](https://github.com/bulbicx)