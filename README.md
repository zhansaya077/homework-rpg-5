# Homework 5: RPG Dungeon Run - Decorator + Facade


## Project Structure
```text
homework-rpg-5/
├── src/
│   └── com/
│       └── narxoz/
│           └── rpg/
│               ├── Main.java
│               ├── decorator/
│               ├── facade/
│               ├── hero/
│               ├── enemy/
│               └── hints/
├── ASSIGNMENT.md
├── QUICKSTART.md
├── FAQ.md
├── STUDENT_CHECKLIST.mdclassDiagram
    class AttackAction {
        <<interface>>
        +getActionName() String
        +getDamage() int
    }
    class BasicAttack {
        +getActionName() String
        +getDamage() int
    }
    class ActionDecorator {
        <<abstract>>
        -wrappedAction AttackAction
        +getActionName() String
        +getDamage() int
    }
    class FireRuneDecorator
    class PoisonCoatingDecorator
    class CriticalFocusDecorator

    AttackAction <|.. BasicAttack
    AttackAction <|.. ActionDecorator
    ActionDecorator o-- AttackAction : wraps
    ActionDecorator <|-- FireRuneDecorator
    ActionDecorator <|-- PoisonCoatingDecorator
    ActionDecorator <|-- CriticalFocusDecorator
└── README.md
```

## Deliverables
- Completed Java code
- UML diagrams (2)
- Clear console demo

Read `ASSIGNMENT.md` before you start coding.
