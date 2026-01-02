# Open/Closed Principle (OCP)

## 📖 Definition
The **Open/Closed Principle** is the second principle of SOLID. It states that software entities (classes, modules, functions, etc.) should be **open for extension, but closed for modification**.

* **Open for extension:** You should be able to add new functionality or behaviors to the system.
* **Closed for modification:** You should be able to add that new functionality without changing the existing, source code that is already tested and working.



---

## 💡 The Intuition
Think of a **Universal Serial Bus (USB) port** on your laptop:

* **The Problem:** If you want to add a mouse, a keyboard, or a printer to your computer, you shouldn't have to open up the laptop and solder new wires to the motherboard every time. 
* **The Solution:** The laptop provides a standard interface (the USB port). Any device that follows the USB "contract" can be plugged in. The laptop is **closed for modification** (the internal hardware remains the same) but **open for extension** (you can add any peripheral you want).

In software, your interfaces or abstract classes act as that "USB port."

---

## 🌍 Real-World Example: Area Calculator
Imagine you are building a graphic design tool that calculates the total area of various shapes on a canvas.

### Without OCP (The "If-Else" Nightmare)
You might have a single class with a method that checks the type of shape manually:
`if (shape == CIRCLE) { ... } else if (shape == RECTANGLE) { ... }`
Every time you want to add a `Triangle` or a `Pentagon`, you have to **modify** that existing method. This is risky because you might accidentally break the logic for circles while trying to add triangles.

### With OCP (The Interface Approach)
By creating a `Shape` interface with a `calculateArea()` method, the `Client` code doesn't need to know the specific details of the shape. It just calls the method. To add a new shape, you simply create a new class that implements `Shape`.



---

## 🛠️ Implementation Logic
To implement OCP effectively, we rely on **Abstractions**:

1.  **Define a Contract:** Create an interface (like `Shape`) that defines the behavior every new component must follow.
2.  **Implement the Contract:** Create concrete classes (like `Circle`, `Rectangle`, `Triangle`) that provide their own specific logic for that behavior.
3.  **Depend on Abstraction:** The "Client" or "Main" code interacts only with the interface. This makes the system "pluggable"—you can swap or add components without the main logic ever knowing the difference.

---

## ✅ Benefits of this Implementation
* **Reduced Risk of Regressions:** Since you aren't touching existing, working code to add a new feature, you cannot introduce bugs into the parts of the system that are already stable.
* **Scalability:** You can add hundreds of different shapes (Hexagon, Star, etc.) by just creating new classes. The `Client` code remains exactly the same.
* **Cleaner Testing:** You only need to write unit tests for the new class you added, rather than re-testing a giant "manager" class that handles every shape.

---