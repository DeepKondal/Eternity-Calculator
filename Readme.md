# Eternity Calculator — sinh(x)

A Java project that computes **sinh(x)** from first principles (Taylor series) without using `Math.sinh()`.  
Includes a Swing GUI, custom exceptions, accessibility improvements, Google Java Style (Checkstyle), JDB debugging, SonarCloud static analysis, and JUnit 5 tests.

---

## Quick Start (Windows / PowerShell)

```powershell
# 1) Go to D3
cd D3

# 2) Compile sources to a clean output folder
mkdir out
javac -d out src\*.java

# 3) Run the app
java -cp out SinhGui
```

### Run tests (JUnit 5 Console Launcher)
```powershell
# Compile tests into a separate output folder (depends on app classes in out/)
mkdir out_tests
javac -cp ".;tools\junit-platform-console-standalone-1.10.2.jar;out" -d out_tests tests\SinhCalculatorTest.java

# Execute tests
java -jar tools\junit-platform-console-standalone-1.10.2.jar execute -cp "out;out_tests" --scan-class-path
```

> Tip (macOS/Linux): replace `;` with `:` in classpaths and use `/` instead of `\` paths.

---

## Project Structure

```
D1/                         # Context of use, requirements, mind map (slides/docs)
D2/                         # Persona + earlier GUI implementation (archived)
D3/
  src/                      # Java sources (SinhCalculator, SinhGui, InvalidInputException)
  tests/                    # JUnit 5 tests (SinhCalculatorTest)
  tools/                    # Local tools (Checkstyle jar, JUnit console jar) — not committed
  docs/
    screenshots/            # Checkstyle, JDB, SonarCloud, Tests screenshots
  README.md                 # D3-specific instructions
  VERSION.txt               # v1.0.0
  sonar-project.properties  # SonarCloud CLI config
LICENSE
README.md                   # (this file)
```

---

## Features
- **Taylor-series** implementation of `sinh(x)` (no `Math.sinh()`).
- **Swing GUI** with clear labels, resizable window, default button.
- **Accessibility**: accessible descriptions, `setLabelFor`, mnemonic on Compute.
- **Exception handling** via `InvalidInputException` with helpful messages.
- **Google Java Style** (Checkstyle) — clean.
- **Debugger proof** using JDB (breakpoints, step, print).
- **Static analysis** via SonarCloud.
- **Unit tests** (JUnit 5) with symmetry/edge cases.

---

## Code Style (Checkstyle — Google)
```powershell
# From D3/
java -jar tools\checkstyle-11.0.0-all.jar -c tools\google_checks.xml src
```

---

## Debugging (JDB)
```powershell
# From D3/
javac -g -d out src\*.java
jdb -classpath out SinhGui
# In jdb:
# stop in SinhGui.parseInput
# stop in SinhCalculator.computeSinh
# run
# step / next / print x / print sum / where
```

---

## Static Analysis (SonarCloud CLI)
1. Set SONAR token (don’t store tokens in files):
   ```powershell
   $env:SONAR_TOKEN="paste-your-token"
   ```
2. Run scanner from `D3/`:
   ```powershell
   Remove-Item -Recurse -Force .scannerwork -ErrorAction SilentlyContinue
   'path_to_solar_scanner_file'\sonar-scanner.bat
   ```
3. Open your SonarCloud project dashboard and capture screenshots (overview + issues list).

> `sonar-project.properties` is configured for the `out/` and `out_tests/` layout.

---

## Versioning & Releases (SemVer)
We use **Semantic Versioning**: `MAJOR.MINOR.PATCH`.

Planned tags:
- **v1.0.0 (D3)** – Final: style (Checkstyle), JDB, SonarCloud, accessibility, JUnit tests.
- **v0.5.0 (D2)** – GUI from scratch + exceptions + persona.
- **v0.1.0 (D1)** – Context of use, requirements, mind map.

> See the **Releases** page for downloadable snapshots and the poster/screenshots.

---

## How it works (short)
`sinh(x) = Σ_{n=0..N-1} x^{2n+1} / (2n+1)!` using custom `power` and `factorial`.  
We use ~15 terms by default for practical accuracy within the allowed input range.

---

## License
MIT (see `LICENSE`).

---

## Acknowledgments
- Google Java Style Guide
- JUnit 5, Checkstyle, SonarCloud
