# Student Management System

A console-based Java application that manages student records, calculates grades, GPA, and applies scholarship discounts on semester fees based on academic performance.

---

## Sample Output

<img width="877" height="767" alt="Sample console output" src="https://github.com/user-attachments/assets/5c301166-244d-4193-9aeb-607bf46cdb64" />

---

## Features

- **Multi-student & multi-subject** support
- **Input validation** — marks enforced between 0 and 100
- **Auto calculation** — total, average, grade and GPA per student
- **Scholarship logic** — up to 30% fee discount based on GPA
- **Formatted result sheet** — clean aligned table output
- **Class average** — calculated across all students

---

## Scholarship Breakdown

| GPA | Grade | Scholarship |
|-----|-------|-------------|
| 4.0 | A     | 30% off     |
| 3.0 | B     | 20% off     |
| 2.0 | C     | 10% off     |
| 1.0 | D     | No discount |
| 0.0 | F     | No discount |

---

## Tech & Concepts Used

| Concept | Applied |
|--------|---------|
| Java Fundamentals | Variables, loops, conditionals |
| 2D Arrays | Storing marks for multiple students |
| Functions / Methods | Modular code structure |
| Input Validation | Do-while loops + Scanner |
| String Formatting | Aligned result sheet with printf |
| Switch Statement | Grade to GPA conversion |

---

## How to Run

**Step 1 — Install Java (one time only)**
1. Go to [java.com/en/download](https://www.java.com/en/download/)
2. Click **Download Java**
3. Install it like any normal program (Next → Next → Finish)
4. Restart your computer after installing

**Step 2 — Download the project**

Open Command Prompt (search CMD in Windows search bar) and run:
```bash
git clone https://github.com/mahnoor-shahbaz-se/student-management-system-java.git
```

**Step 3 — Go into the project folder**
```bash
cd student-management-system-java
```

**Step 4 — Compile the program**
```bash
javac StudentManagementSystem.java
```
No output means it worked — that's expected.

**Step 5 — Run the program**
```bash
java StudentManagementSystem
```
Follow the on-screen instructions to enter student data.

---

## Future Improvements

- [ ] File handling to save and load student records
- [ ] Search and sort students by name or grade
- [ ] GUI version using Java Swing
- [ ] Database integration for persistent storage

---

## Author

**Mahnoor Shahbaz**
[LinkedIn](https://www.linkedin.com/in/mahnoor-shahbaz-se/) &nbsp;|&nbsp; [Email](mailto:mahnoorshahbaz86@gmail.com)
