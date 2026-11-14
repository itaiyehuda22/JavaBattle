## Running Examples

This is a conosle example of a run containing all the new fetuares.

the mark input: means this line was written in the Console.

**Added a name for your charectar**

```text
Player's name: #input: OrangeDragon
```

**you can choose your action from the following menu**

```text
HP: 100 Resources: 5 Enemey HP: 30
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 1
```

**The attack reduces enemy HP by 10**

```text
OrangeDragon attacked Enemy. Enemy's HP: 20
```

**Enemy is attacking back**

```text
Enemy attacked OrangeDragon. OrangeDragon's HP: 90
```

**After both characters have played it's your turn again**

```text
HP: 90 Resources: 5 Enemey HP: 20
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 2
```

**You can defend the next enemy attack reducing it's hp by half**

```text
OrangeDragon is defending the next attack.
OrangeDragon defended Enemy's attack reducing half the damage.

HP: 85 Resources: 5 Enemey HP: 20
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 3
```

**You have a special attack that deals 15 damage but takes 3 resources to use**

```text
OrangeDragon used a special attack on Enemy. Enemy's HP: 5
Enemy attacked OrangeDragon. OrangeDragon's HP: 75
HP: 75 Resources: 2 Enemey HP: 5
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 4
```

**You can recover resources 3 at a time but to a maximum of 10**

```text
OrangeDragon recover'd resources
Enemy attacked OrangeDragon. OrangeDragon's HP: 65
HP: 65 Resources: 5 Enemey HP: 5
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 3

OrangeDragon used a special attack on Enemy. Enemy's HP: -10
```

**Enemy has been knocked you have won**

```text
You have won the battle with 65 health and 2 resources left congrats!
```
## reward
**After winning your first encouter you can choose a reward**
```text
You have won the battle with 80 HP and 5 resources left
Choose your reward for winning the battle
1) Recover 25 HP to the maximum of 100
2) Upgrade attack damage by 2
```
**you can choose either to restore HP or Upgrade attack damage**
```text
input: 1
OrangeDragon Restored 25 HP
SECOND BATTLE
HP: 100 Resources: 5 Enemey HP: 45

OR:
input: 2
Changed OrangeDragon attack's damage to 12
SECOND BATTLE
HP: 80 Resources: 5 Enemey HP: 45
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 1
OrangeDragon attacked enemy2. enemy2's HP: 33 //damage is 12 now
```

**Healing doesn't go past max HP**
```text
You have won the battle with 80 HP and 5 resources left
Choose your reward for winning the battle
1) Recover 25 HP to the maximum of 100
2) Upgrade attack damage by 2
input: 1
OrangeDragon Restored 25 HP
SECOND BATTLE
HP: 100 Resources: 5 Enemey HP: 45
```

**Changing attack damage does not change the special damage**
```text
Changed OrangeDragon attack's damage to 12
SECOND BATTLE
HP: 80 Resources: 5 Enemey HP: 45
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 3
OrangeDragon used a special attack on enemy2. enemy2's HP: 30 //dealt 15 HP and not 12 or 17
```

**Choosing an invalid reward makes you repick**
```text
Choose your reward for winning the battle
1) Recover 25 HP to the maximum of 100
2) Upgrade attack damage by 2
input: asd
Invalid option please choose again:
input: 3
Invalid option please choose again:
input: 1
OrangeDragon Restored 25 HP
```
## edge cases

**If you don't have enough resources you can't use a special attack and will need to choose a diffrent action**

```text
HP: 90 Resources: 2 Enemey HP: 15
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 3
OrangeDragon does not have enough resources for a special attack.
HP: 90 Resources: 2 Enemey HP: 15
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
```

**resources don't go past 10**

```text
HP: 90 Resources: 8 Enemey HP: 30
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 4
OrangeDragon recover'd resources
Enemy attacked OrangeDragon. OrangeDragon's HP: 80
HP: 80 Resources: 10 Enemey HP: 30
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
```

**If an invalid action is made you will need to choose a diffrent one**

```text
HP: 100 Resources: 5 Enemey HP: 30
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 0
Invalid action must be a number 1 - 4
HP: 100 Resources: 5 Enemey HP: 30
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: asd
Invalid action must be a number 1 - 4
HP: 100 Resources: 5 Enemey HP: 30
Choose your action:
1) Attack
2) Defend
3) Special
4) Recover resources
input: 1
OrangeDragon attacked Enemy. Enemy's HP: 20
```
