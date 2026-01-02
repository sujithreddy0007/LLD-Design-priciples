# Liskov Substitution Principle (LSP)

## 📖 Definition
The **Liskov Substitution Principle** is the third principle of SOLID. It states that:
> *"Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program."*

In simpler terms, if class **B** is a subtype of class **A**, then we should be able to replace **A** with **B** without the program breaking or behaving unexpectedly.



---

## 💡 The Intuition
Think of a **Remote Control Battery**:

* **The Problem:** You have a remote that requires a standard AA battery. You buy a specific brand of rechargeable AA battery.
* **The Solution:** Because the rechargeable battery (Subtype) follows the exact physical and electrical specifications of a standard AA battery (Supertype), the remote works perfectly. 
* **The Violation:** If the rechargeable battery was slightly larger or provided a different voltage, it wouldn't be a true substitute, and the remote would fail.

In software, if a `Square` claims to be a `Rectangle` but changes how `setWidth()` works in a way that breaks the Area calculation logic, it violates LSP.

---

## 🌍 Real-World Example: The Shape Dilemma
A classic mathematical "truth" is that a Square is a Rectangle. However, in software design, this often leads to bugs.

### The Violation (Rectangle -> Square Inheritance)
If `Square` inherits from `Rectangle`, and you change the `width`, the `height` must also change to keep it a square. If a method expects a `Rectangle` and sets the width to 5 and height to 10, it expects the area to be 50. If it receives a `Square` instead, the area would unexpectedly become 100. This **breaks the caller's expectations**.

### The Solution (Interface Abstraction)
Instead of forcing a Square to "be" a Rectangle, we make both implement a common `Shape` interface. This way, we only guarantee that they can both calculate an `Area`. We don't make false promises about how their sides behave.



---

## 🛠️ Implementation Logic
To follow LSP, you must ensure that a subclass doesn't change the "contract" of the parent:

1.  **Avoid "Broken" Inheritance:** Don't inherit just to reuse code. Only inherit if the child can truly fulfill every promise the parent makes.
2.  **Extract Interfaces:** If two classes share a behavior (like `getArea`) but have different internal rules, move that behavior to a common interface.
3.  **Expectations:** The calling code should get the same logical result regardless of which implementation of the interface it receives.

---

## ✅ Benefits of this Implementation
* **Predictability:** The `Client` can treat all `Shape` objects the same way without needing `if (shape instanceof Square)` checks.
* **Robustness:** You avoid side effects where changing one property (width) accidentally changes another (height) in certain subclasses.
* **Flexibility:** You can introduce new shapes like `Circle` or `Triangle` easily. As long as they provide a `getArea()` method, the `Client` code remains valid and stable.

---