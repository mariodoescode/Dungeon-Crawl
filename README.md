# Dungeon Crawl - Read Me

## Description

Welcome to Dungeon Crawl, an exciting tile-based roguelike game that will challenge your skills and courage. In this game, you'll step into the shoes of a valiant knight, ready to face a variety of challenges, from spooky skeletons to formidable bosses like snakes, wizards, and spirits. Conquer your fears and guide your hero through the treacherous dungeon to reach the light of the outside world once again.

## Technologies Used

- **IDE:** IntelliJ IDEA
- **Project Management Build Tool:** Maven
- **Programming Language:** Java
- **Special Libraries:** JavaFX
- **Database:** PostgreSQL
- **Version Control:** Git & GitHub

## Installation

Follow these steps to get Dungeon Crawl up and running on your local machine. The instructions are optimized for IntelliJ IDEA, but you can adapt them to your chosen IDE.

1. Download the project onto your local machine.
2. Open the project in IntelliJ IDEA. To do this, open the `pom.xml` file, as this is a Maven project.
3. Connect a PostgreSQL database.
4. Since the project uses JavaFX, you'll need to utilize the JavaFX Maven plugin to build and run the program:
   - Build the project using `mvn javafx:compile`.
   - Run the game using `mvn javafx:run`.

## Controls and Gameplay

Get ready to dive into the world of Dungeon Crawl with these essential gameplay mechanics:

1. Use the arrow keys to navigate your knight through the dungeon's challenges.
2. Equip items scattered across the map by moving over them and pressing the "Pick up" button on the right side of your screen.
3. To be able to defeat skeletons, ensure you pick up the sword when starting the game.
4. After defeating a boss, a key will drop. Pick up this key to advance to the next stage.
5. Progress through the dungeon by walking through the corridor at the end of the first part, leading to a portal. The portal transports you to the opposite side of the map.
6. Collect every item on your journey as defeating bosses and completing the game requires their cumulative strength.
7. Confront the final boss to unlock the door to the ladder, which takes you outside the dungeon and into the outer world.
8. You can save your progress at any time by using `CTRL + S`, and you can load it later using `CTRL + L`.

## Implementation

The game's implementation files and assets can be accessed through the following links:

- [[Game Implementation Part 1](https://drive.google.com/file/d/13XbGIw-0EWTKxaR_lKaM3qPr8jEijfWA/view?usp=drive_link)](https://drive.google.com/uc?id=13XbGIw-0EWTKxaR_lKaM3qPr8jEijfWA)
- [Game Implementation Part 2](https://drive.google.com/file/d/1Lmk-KzuS-LJnPXI6-ckOFPaliHWeWt6q/view?usp=drive_link)
- [Game Implementation Part 3](https://drive.google.com/file/d/1cWf7WMxWzSF7nYbsCFhZgrrcYOcCXVKf/view?usp=drive_link)
- [Game Implementation Part 4](https://drive.google.com/file/d/1wGH_GIq-nMsDx2x0nSMRLMt2upf2rcT4/view?usp=drive_link)

## Ideas for Further Development

The world of Dungeon Crawl has endless possibilities for expansion and improvement. Here are a few ideas to consider for future development:

- Expand the map or create entirely new maps with different stages, each with unique challenges.
- Introduce more items with diverse effects to enhance the player's strategies and choices.
- Provide the option for players to choose from a variety of characters, each with their own abilities and strengths.

Feel free to explore these ideas and contribute to the growth of Dungeon Crawl. Enjoy your journey through the depths of the dungeon and beyond!
