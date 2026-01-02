# 🏗️ Software Design Principles & Patterns

A comprehensive collection of essential software design principles, architectural patterns, and best practices implemented in Java. This repository serves as a guide for building scalable, maintainable, and robust software systems.

---

## 🚀 Purpose
The goal of this repository is to demonstrate how to transition from "code that just works" to "code that is engineered for change." By following these industry-standard principles, we reduce technical debt and make our systems easier to understand and test.

---

## 🧩 Principles Covered

### 1. SOLID Principles
The five basic principles of object-oriented design and programming.

| Principle | Description | Link |
| :--- | :--- | :--- |
| **S**RP | **Single Responsibility Principle**: A class should have one reason to change. | [View](./SOLID/SRP.md) |
| **O**CP | **Open/Closed Principle**: Open for extension, closed for modification. | [View](./SOLID/OCP.md) |
| **L**SP | **Liskov Substitution Principle**: Subclasses must be substitutable for their base classes. | [View](./SOLID/LSP.md) |
| **I**SP | **Interface Segregation Principle**: Don't force clients to depend on methods they don't use. | [View](./SOLID/ISP.md) |
| **D**IP | **Dependency Inversion Principle**: Depend on abstractions, not concretions. | [View](./SOLID/DIP.md) |



### 2. Core Development Principles
Beyond SOLID, these principles guide the day-to-day logic and simplicity of the system.

* **DRY (Don't Repeat Yourself):** Avoid logic duplication by abstracting common functionality into a single source of truth.
* **KISS (Keep It Simple, Stupid):** Avoid unnecessary complexity. Most systems work best if they are kept simple rather than made complicated.
* **YAGNI (You Ain't Gonna Need It):** Do not add functionality until it is actually necessary. Resist the urge to "over-engineer" for future scenarios that may never happen.

---

## 📂 Repository Structure
```text
.
├── SOLID/
│   ├── SRP/          # Single Responsibility Principle
│   ├── OCP/          # Open/Closed Principle
│   └── ...
├── DRY/              # Don't Repeat Yourself
├── KISS/             # Keep It Simple, Stupid
└── YAGNI/            # You Ain't Gonna Need It