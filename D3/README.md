# Eternity Calculator — sinh(x)

A small Java application that computes **sinh(x)** from first principles (Taylor series) without using `Math.sinh()`. Includes a Swing GUI, exception handling, accessibility labels, coding-style compliance with **Google Java Style (Checkstyle)**, and **JUnit tests**.

## Features
- Taylor-series implementation of `sinh(x)` (no Math library for sinh)
- Swing GUI with basic accessibility descriptions
- Custom exception for invalid inputs
- Google Java Style compliance (Checkstyle)
- Debugging proof via JDB
- Unit tests with JUnit

## How to Run
```bash
# Compile
javac SinhCalculator.java SinhGui.java InvalidInputException.java

# Run
java SinhGui
```

## Debugging with JDB (evidence steps)
```bash
javac -g SinhCalculator.java SinhGui.java InvalidInputException.java
jdb SinhGui
# in jdb
stop in SinhGui.parseInput
stop in SinhCalculator.computeSinh
run
# then step/print as shown in the report
```

## Static Analysis
- Use **SonarLint** in your IDE (IntelliJ/Eclipse/VS Code) and capture screenshots, or
- Use **PMD** (CLI):
  ```bash
  pmd -d . -R category/java/bestpractices.xml -f text
  ```

## Tests (JUnit 5 from command line)
1. Download the JUnit 5 **Console Launcher** JAR (e.g., `junit-platform-console-standalone-1.10.2.jar`).
2. Compile sources and tests:
   ```bash
   javac -cp junit-platform-console-standalone-1.10.2.jar;. SinhCalculator.java InvalidInputException.java SinhCalculatorTest.java
   ```
3. Run tests:
   ```bash
   java -jar junit-platform-console-standalone-1.10.2.jar -cp . --scan-class-path
   ```

## Versioning
See `VERSION.txt`. GUI title shows the current version.

## Repository Checklist (Problem 8)
- Public GitHub repository
- High-quality commit messages
- Include: source `.java`, `VERSION.txt`, `README.md`, screenshots (Checkstyle, JDB, SonarLint/PMD, tests)
