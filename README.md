# Ostrov
This is a simple adventure text game written in Java. The player is shipwrecked on a deserted island and their goal is to repair a radio nad call for help. The game uses command pattern and object-oriented design.

## Game functions
* Walking in directions (North, South, East, West)
* Inventory system (picking up and dropping items)
* Interacting with NPC characters
* Using items

## Game commands
### Movement
* jdi sever: moves the player to the north 
* jdi jih: moves the player to the south
* jdi vychod: moves the player to the east
* jdi zapad: moves th player to the west
### Inventory
* vezmi [item]: adds the item to the inventory
* poloz [item]: removes the item from the inventory
### Item usage
* pouzij [item]: uses a specific item
### Character interactions
* mluv: interacts with the character in the current room
### Explore locations
* prozkoumej: gives an information about all items and characters in the current room
### Aditional commands
* pomoc: gives a list of all possible commands
* napoveda: gives a hint to the player
* konec: ends the game immediately

## Game features
* Radio repair: the player have to repair the radio in order to win the game
* Characters interactions: characters can give hints, block a specific location or give an item after a some conditions are met 
* Unlocking locations: by using specific items the player can unlock new locations 

## Data loading
* The game world (rooms, items, character) is loaded from a file using Gson library

## How to run
1. Create a folder
2. Put .jar file and resources in the folder
3. Open Windows terminal
4. Write: cd [folder-path]
5. Run the program by entering: java -jar [.jar file-name]

## Program requirements
* Java 17 or greater