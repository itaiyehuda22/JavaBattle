## Design
An architectural decision I made was to keep each character’s data and actions inside a separate Character class. This class stores the character’s health points, resources, name, and defense state.
It also contains methods for attacking, defending, using a special attack, and recovering resources.
Each character object has its own values, so we can have many diffrent character's each with it's own stats.

By using a class that saves the character's data and has all of it's action functions inside of it I have the ability to directly change or use the data of the character becuase everything is in the same class.
For example in the special attack the program check's the character's resources and changes it just by using this.resources which makes the code cleaner.

I also added a create character function which makes creating characters more simple and clean.

The main class starts the game, create the characters, and handle the turns and actions with the battle loop while the characters class handles the characters data and actions.

Also There is a specific class for choosing a reward between encounters. The class uses an enum to make sure the user chooses a valid reward in the console and gives it to him.
