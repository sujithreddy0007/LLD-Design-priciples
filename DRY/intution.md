# DRY (Don't Repeat Yourself)

## 📖 Definition
**DRY** stands for **Don't Repeat Yourself**. It is a principle of software development aimed at reducing the repetition of software patterns by replacing them with abstractions or using data normalization.

The core idea is: 
> "Every piece of knowledge must have a single, unambiguous, authoritative representation within a system."



---

## 💡 The Intuition
Think of a **Centralized Address Book**:

* **The Problem (WET - Write Everything Twice):** Imagine you have your best friend's phone number saved in your phone, written in your paper diary, and saved in your email contacts. If your friend changes their number, you have to update it in three different places. If you forget one, you have inconsistent and "broken" data.
* **The Solution (DRY):** You save the number in a cloud-synced account. All your devices (phone, laptop, tablet) pull from that **single source of truth**. You update it once, and it works everywhere.

In code, the "phone number" is your **logic** (like validation), and the "devices" are your **methods** (like create or update).

---

## 🌍 Real-World Example: User Validation
In most applications, you need to validate user input at multiple stages—when creating a profile, when updating it, or when performing administrative changes.

### Without DRY (WET Code)
You would copy and paste the `if (name == null || name.length() < 3)` logic into both the `createUser` and `updateUser` methods. If the business requirement changes later (e.g., names must be at least 5 characters), you might update it in `createUser` but forget to update it in `updateUser`, leading to inconsistent bugs.

### With DRY (Centralized Logic)
You extract the validation rules into a dedicated `UserValidator`. Now, both the creation and update processes "ask" the validator to check the name. There is only one place to change the rule.

---

## 🛠️ Implementation Logic
To implement DRY, follow these steps:

1.  **Identify Duplication:** Look for blocks of code that perform the same logic in different places.
2.  **Extract to a Method/Class:** Move that shared logic into a single method (e.g., `validateName`) or a utility class (e.g., `UserValidator`).
3.  **Call the Abstraction:** Replace the duplicated code blocks with a call to your new single source of truth.



---

## ✅ Benefits of this Implementation
* **Maintainability:** If the validation rules change, you only need to modify one method in `UserValidator`.
* **Consistency:** You guarantee that the validation logic is identical across the entire application.
* **Readability:** High-level service methods (like `createUser`) become cleaner and more focused on their primary task rather than getting cluttered with low-level checks.
* **Reduced Testing Effort:** You can write a comprehensive unit test for `UserValidator` once, rather than testing the same logic across every service method.

---