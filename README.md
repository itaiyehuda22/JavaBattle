# JavaBattle

JavaBattle is a turn-based Java console game. The player fights an enemy by attacking, defending, using special attacks, and recovering resources.

## Requirements

- JDK 25
- Apache Maven for compiling and running automated tests

Run all commands from the project folder containing `pom.xml`.

## Compile

```powershell
mvn compile
```

## Run

After compiling, run:

```powershell
java -cp target/classes edu.starter.Main
```

Enter your name, then choose an action:

- `1`: Attack for 10 damage.
- `2`: Defend to half the damage from the next enemy attack.
- `3`: Use a special attack for 15 damage, costing 3 resources.
- `4`: Recover 3 resources, up to a maximum of 10.

The battle ends when either character's HP reaches zero or below.

## Compile and Run Without Maven

With JDK 25 installed, run these commands in PowerShell:

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build src/main/java/edu/starter/*.java
java -cp build edu.starter.Main
```

This method runs the game but does not run the automated tests.

## Automated Tests

Run:

```powershell
mvn test
```

The tests in `src/test/java/edu/starter/StarterTest.java` verify:

- `Checks.within()` keeps a value within the specified bounds.
- `ConsoleChoice.read()` rejects nonnumeric input.

These tests check utility methods, not the battle rules.

## Manual Test

Run the game and enter these inputs separately when prompted:

1. Enter `Alex` as the player's name.
2. Enter `1`. The enemy's HP becomes 20 and the player's HP becomes 90.
3. Enter `1`. The enemy's HP becomes 10 and the player's HP becomes 80.
4. Enter `1`. The enemy's HP becomes 0 and the player wins.

Expected final output:

```text
You have won the battle with 80 health and 5 resources left congrats!
```
