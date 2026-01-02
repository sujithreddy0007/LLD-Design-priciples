# Single Responsibility Principle (SRP)

## 📖 Definition
The **Single Responsibility Principle (SRP)** is the first of the five SOLID principles. It states that:
> *"A class should have one, and only one, reason to change."*

This means a class should be specialized and focused on a single piece of functionality. If a class has multiple responsibilities, those responsibilities become **coupled**. A change to one responsibility may unexpectedly break or affect the other, leading to fragile code.



---

## 💡 The Intuition
The best way to understand SRP is through the **"Swiss Army Knife vs. Specialized Tool"** analogy:

* **The Problem:** A Swiss Army Knife tries to be a knife, a saw, a bottle opener, and scissors. If the hinge for the scissors breaks, you might have to send the entire tool back for repair, losing the use of your knife and saw in the process.
* **The Solution:** In a professional kitchen, a chef uses a dedicated chef's knife for cutting, a dedicated opener for bottles, and dedicated shears for snipping. If the shears get dull, the chef can still use the knife.

In software, SRP ensures that your "tools" (classes) are specialized. If the business logic for *Tax Calculation* changes, you shouldn't have to touch the code that *Generates PDF Reports*.

---

## 🌍 Real-World Example: The Bakery System
Imagine you are building a system to manage a local bakery.

### Without SRP (The "God Object" Approach)
You might have a single `BakeryManager` class that handles:
* Baking recipes
* Inventory tracking
* Customer payments
* Cleaning schedules
* Supply orders

If you decide to change your payment provider, you have to modify this massive class, risking a bug that might accidentally delete your bread recipes or break the inventory logic.

### With SRP (The Modular Approach)
You divide the labor into specific roles:
* **BreadBaker:** Handles only the ratios and timing for baking.
* **InventoryManager:** Tracks how many bags of flour are left.
* **CustomerService:** Manages the front-of-house interactions.
* **SupplyOrder:** Handles the logistics of buying new ingredients.
* **BakeryCleaner:** Manages the sanitation protocols.



---

## 🛠️ Implementation Logic
To implement SRP, follow the process of **Decomposition**:

1.  **Identify Responsibilities:** Look at a class and list everything it does. If you use the word **"and"** (e.g., "this class saves data *and* formats it for the UI"), you have found multiple responsibilities.
2.  **Extract Classes:** Move the secondary responsibilities into their own new, specialized classes.
3.  **Delegation:** Let an orchestrator (like your `main` method or a controller) call these specialized classes to perform their specific tasks.

---

## ✅ Benefits of this Implementation
* **Encapsulation:** The internal logic of how to clean a bakery is hidden inside `BakeryCleaner`. No other class needs to know about vacuuming or mopping.
* **Isolation:** If the `SupplyOrder` logic needs to be updated to support an API instead of a manual log, only the `SupplyOrder` class changes. The `BreadBaker` remains untouched and stable.
* **Organization:** Each class is small, readable, and does exactly what its name suggests.
* **Testability:** You can test the `BreadBaker` without needing to set up a database for `InventoryManager`.

---