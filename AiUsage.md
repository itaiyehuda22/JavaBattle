## Usage of AI

While working on the project I had many uncleared syntax of java that I could simply learn by asking an LLM what's the correct syntax. For example I didn't know the correct syntax of methods so I asked codex what's the correct one and now I know how to create methods in java.

A suggestion that was given to me by codex was adding names to the characters so the console output could use this.name for the character that is making the action and enemy.name for the character being attacked.
I added this change and changed the output lines accordingly and after I ran the program I saw that the character's names in the printed messages works correctly and as intended.


While working on multiple encouters AI suggested to move the print lines from the big Action method to the specific action method (from Action() to attack() for example) which simplifies the Action() function and also makes the code cleaner.

codex has also suggested to remove the defence at the end of each encouter but it is not needed since if you defened the enemy will counter attack which removes the defending state.

Ai has tested whether the player keeps his resources and HP after each encounter which he found that it does work.
