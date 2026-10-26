# Student Grade Tracker

A console-based Java program to input and manage student grades. Built as Task 1 of the Code Alpha Java Programming Internship.

## Features

- Add students with their grades (0-100)
- Update the grade of an existing student
- Remove a student
- View a summary report with:
  - List of all students and grades
  - Average score
  - Highest score
  - Lowest score
- Input validation for invalid numbers and out-of-range grades

## Concepts Used

- Object-Oriented Programming (`Student` class with private fields, getters and setter)
- `ArrayList` to store and manage data
- Loops, `switch` statement and methods
- Exception handling (`NumberFormatException`)
- `Scanner` for console input

## Project Structure

```
StudentGradeTracker/
├── Student.java
├── StudentGradeTracker.java
└── README.md
```

## How to Run

1. Make sure Java (JDK 8 or newer) is installed.
2. Download or clone this repository.
3. Open a terminal in the project folder and run:

```
javac Student.java StudentGradeTracker.java
java StudentGradeTracker
```

You can also open the project in IntelliJ IDEA and run the `main` method in `StudentGradeTracker`.

## Sample Output

```
===== STUDENT GRADE TRACKER =====
1. Add student
2. Update student grade
3. Remove student
4. View summary report
5. Exit

----------- SUMMARY REPORT -----------
No.   Name                 Grade
--------------------------------------
1     Asha                 85.00
2     Rahul                72.50
3     Meena                93.00
--------------------------------------
Total students : 3
Average score  : 83.50
Highest score  : 93.00 (Meena)
Lowest score   : 72.50 (Rahul)
```

## Author

Versha Singh
