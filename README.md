# RPG Game Project
![hello](https://media.tenor.com/kvXMS__Bkd8AAAAC/hello-hi.gif)

![RPG Logo](https://github.com/beka24k/projecteamwork/blob/master/tesst/photo_2023-11-22_10-43-51.jpg)

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
        <img src="https://github.com/beka24k/projecteamwork/blob/master/tesst/priest.jpg" alt="Priest" width="250" height="300">
        <center><h3>Priest</h3></center>
    </div>
    <div style="margin-right:20px;">
        <img src="https://github.com/beka24k/projecteamwork/blob/master/tesst/mage.jpg" alt="Magician" width="250" height="300">
        <center><h3>Magician</h3></center>
    </div>
<div style="margin-right:20px;">
        <img src="https://github.com/beka24k/projecteamwork/blob/master/tesst/barbarian.jpg" alt= "Barbarian" width="250" height="300">
        <center><h3>Barbarian</h3></center>
</div>
 <div>
        <img src="https://github.com/beka24k/projecteamwork/blob/master/tesst/warrior.jpg" alt="Warrior" width="250" height="300">

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



### 📚 Usage

- Launch the game and follow on-screen instructions.
- Create characters, perform actions, and explore their abilities.
---
## 📸 Screenshots

![Code Screen](https://github.com/beka24k/projecteamwork/blob/master/tesst/code.png)


![Database Structure](https://github.com/beka24k/projecteamwork/blob/master/tesst/photo_2023-11-22_10-50-23.jpg)


# 📝Developers' Notes

## Design Patterns Used
### State Pattern
Role: Aids in character attacks. It encapsulates various attack states, enabling characters to perform different attacks based on their state.

### Factory Pattern
Role: Responsible for creating new characters. It abstracts the creation process, allowing the creation of different character types through specialized factories.

### Command Pattern
Role: Facilitates character attacks by encapsulating the request to attack within a command object, enabling flexible execution of attack commands.

### Observer Pattern
Role: Alters the camp of all characters to the same state. It establishes a one-to-many relationship, notifying multiple characters about camp changes.

### Strategy Pattern
Role: Enables the selection of a character by defining interchangeable character strategies without altering their structure, allowing dynamic character selection.

### Builder Pattern
Role: Assists in character creation by separating the construction of a character object from its representation, allowing the same construction process to create different representations.

### Singleton Pattern
Role: Not directly associated with any class in this project. It includes a private constructor to restrict instantiation, ensuring only one instance of a class exists globally.


## Code Modularity
The project is designed with a focus on modularity, allowing for easy extension and addition of new character types or abilities. Each class encapsulates specific functionalities to ensure code coherence.

## Abstraction and Interfaces
Use of interfaces such as CharacterAbility, CharacterBuilder, and CharacterCommand promotes abstraction and helps in decoupling components, facilitating flexibility and easy swapping of implementations.

## 📊Database Integration
The dbConnect class manages PostgreSQL database connections, schema creation, and data insertion for character details. Tables and queries are structured for scalability and future expansion.

## 🖥️GUI Implementation
The GameGUI class offers a graphical interface for user interaction. GUI elements are designed for intuitive gameplay and seamless character creation.

## Improvements and Future Work
- Enhance character abilities and add new spells or attacks.
- Implement additional GUI features for better user experience.
- Expand database functionalities for storing more character details and game progress.
- Refactor code for better readability and maintainability.

## Dependencies
- Java 11 or higher
- PostgreSQL database

## 🧑‍💻 Contribution Guidelines
We welcome contributions through pull requests. Please adhere to the project's coding standards and guidelines.
- Begarys Kanat 
- Nargiza Sailaubaeva 
- Merei Shakirova

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### 🛠️Installation
GitHub: https://github.com/beka24k/projecteamwork.git
IntelliJ IDEA 2022.3.1

## Contributing
Bug reports and\or pull requests are 
![gif](https://img.wattpad.com/6c151ba821ca2c749493262d427fb9d0324ec0fc/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f6147354e6948476d6c62704b50673d3d2d3636303937343137322e313537323431383735386537393136303532343031303939363231302e676966)

![bye](https://media.tenor.com/5DcYGrosKfQAAAAC/bye-see-you.gif)
