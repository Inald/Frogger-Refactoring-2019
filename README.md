# **_Frogger Software Maintenance_**

This Program is based on an Arcade game called "Frogger", Although its similar to the orignal game they are not exactly the same as you will find different additions to this game.

## Getting Started

These instructions will ensure that the program can get up and running on your local machine for development and tests.

#### Running the game
~~~~
load the project into the IDE, and set the correct configurations.
This can be done by setting the Main class to com.mainPack.Main in
the "Edit Configurations" next to the run button and add a maven goal
in the build. Enter "clean compile test" and it allows for automated testing
by pressing apply.
~~~~

![Frogger](src/main/resources/editConfigs.PNG)
## Extensions

### Highscores
Two type of Highscores were implemented one for the overall score of the level being played and also one for each round that is displayed to a user in a sorted fashion (Descending)
![Frogger](src/main/resources/highScoreDisplay.PNG)

### Further Levels
Further level implementation was allowed once the main class was refactored to put the level being played into an abstract class that could be overridden to alter the game
![Frogger](src/main/resources/Furtherlevels.PNG)
### JUnit
Twenty Eight JUnit Tests added, For example:
~~~~
1) Keypad pressed tested to see frogger moves properly
2) Checks whether objects in the game have been set properly and move
3) Checks whether images have been set properly for the objects
4) Tests whether points are set, added and removed appropriately

~~~~
### Start Menu
![Frogger](src/main/resources/StartScreenReadMe.PNG)
## Refactoring
### Maven
Maven build was added to allow for 
### Design Patterns
##### Singletons:
~~~~
1) Singleton added for the BackgroundImage class
2) Singleton added for the HighScoreRW class to read and write highscores
3) Singleton added for the StartMenu class as only created once and called when
   the game ends
~~~~
##### Factories:
~~~~
1) Factory added for Levels in the game
2) Factory added for objects moving in the game e.g. Logs, Turtles etc...
~~~~
### Bug Fixes
Bug fixes include the following:
~~~~
1) Moving into the same end that has already been activated - frogger is
   no longer allowed.
2) allowing speed of logs or turtles to speed up and not have the frogger
   not slip off but stay on the log with the new speed
3) 