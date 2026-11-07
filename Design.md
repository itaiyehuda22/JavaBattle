## Design
An architectural decision I made was to keep each character’s data and actions inside a separate Character class And also make another class that manages each encounter. The character class stores the character’s health points, resources, name, and defense state. while the encounter class manages the turns and actions of the battle loop.

The character class contains methods for attacking, defending, using a special attack, and recovering resources.
Each character object has its own values, so we can have many diffrent character's each with it's own stats.

By using a class that saves the character's data and has all of it's action functions inside of it I have the ability to directly change or use the data of the character becuase everything is in the same class.

For example in the special attack the program check's the character's resources and changes it just by using this.resources which makes the code cleaner.

The encounter class can create a new encounter given two character's and run a battle loop between them until one character is knocked out.

the main class creates the character's and calls the encounters function while the encounter function manages the characters actions and turns using the characters class.
