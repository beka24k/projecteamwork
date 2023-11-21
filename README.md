# RPG Game Project
![hello](https://media.tenor.com/kvXMS__Bkd8AAAAC/hello-hi.gif)

![RPG Logo](img_1.png)

## 📋Overview

This RPG (Role-Playing Game) project is a Java-based game with a character creation system, various character types, abilities, and a database system to store character information. Dive into a world of fantasy, where characters with unique skills await your command!

---
## Table of Contents
- [Project Structure](#project-structure)
- [Features](#features)
- [Technologies Used](#-technologies-used)
- [Installation](#installation)
- [Screenshots](#-screenshots)
- [Developers' Notes](#developers-notes)
- [Contribution Guidelines](#-contribution-guidelines)

## 📁 Project Structure

### Ability
- CharacterAbility.java: Interface defining character abilities.
- FireMagick.java: Implementation of fire magic ability for characters.

### Builder
- CharacterBuilder.java: Interface for building character attributes.
- ConcreteCharacterBuilder.java: Implementation of character building process.

### Squad
- Barbarian.java, Mage.java, Priest.java, Warrior.java: Specific character classes inheriting from the base Character class.

### Characters

<div style="display:flex; justify-content:center; align-items:center;">
    <div style="margin-right:20px;">
        <img src="img_2.png" alt="Priest" width="300" height="230"/>
        <center><h3>Priest</h3></center>
    </div>
    <div style="margin-right:20px;">
        <img src="img_3.png" alt="Magician" width="300" height="230"/>
        <center><h3>Magician</h3></center>
    </div>
<div style="margin-right:20px;">
        <img src="img_4.png" alt="Barbarian" width="300" height="230"/>
        <center><h3>Barbarian</h3></center>
</div>
 <div>
        <img src="img_5.png" alt="Warrior" width="300" height="230"/>

<center><h3>Warrior</h3></center>
    </div>
</div>

### Command
- AttackCommand.java: Command class for character attacks.
- CharacterCommand.java: Interface defining character commands.

### Database
- dbConnect.java: Handles database connections, character table creation, and data insertion.

### Factory
- BarbarianFactory.java, MageFactory.java, PriestFactory.java, WarriorFactory.java: Factories creating specific character types.
- CharacterFactory.java: Abstract factory interface for character creation.

### Main
- Character.java: Defines the base character class with states and abilities.
- GameWorld.java: Main class for game interactions and character creation.

### Observer
- CharacterObserver.java: Interface for character observers.

### State
- AliveState.java: Defines the alive state for characters.
- GameGUI.java: GUI implementation for the game interface.
---
## 🎮 Features

- Character Creation: Choose from Warrior, Mage, Barbarian, and Priest.
- Abilities: Engage in battles using unique abilities like Sword Attack and Fire Magick.
- Database Integration: Store character data in PostgreSQL for persistence.
- Graphical User Interface (GUI): Interactive interface for seamless gaming.
---
## 💻 Technologies Used

- Java: Core programming language.
- Swing: Building the GUI for user interaction.
- PostgreSQL: Database for storing character data.
- Design Patterns: Implemented for better code structure.

---
## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK)
- PostgreSQL database installed

### 🛠️Installation

1. Clone the repository: git clone https://github.com/your-username/rpg-game.git
2. Set up the database: Execute dbConnect.createCharacterTable().
3. Run the game: Compile and execute GameWorld.java.

### 📚 Usage

- Launch the game and follow on-screen instructions.
- Create characters, perform actions, and explore their abilities.
---
## 📸 Screenshots

![Code Screen](img_7.png)
*Screenshot: Code Screen*

![Database Structure](img_6.png)
*Screenshot: Database Structure (ER Diagram)*

# 📝Developers' Notes

## Design Patterns Used
### State Pattern
**Role:

## Installation
IntelliJ IDEA 2022.3.1
## Contributing
Bug reports and\or pull requests are 
![gif](https://img.wattpad.com/6c151ba821ca2c749493262d427fb9d0324ec0fc/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f6147354e6948476d6c62704b50673d3d2d3636303937343137322e313537323431383735386537393136303532343031303939363231302e676966)

![bye](https://media.tenor.com/5DcYGrosKfQAAAAC/bye-see-you.gif)
