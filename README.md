# 26b-10142 Unit Testing Assignment

## Team Members
* Yuval Dahan
* Itay Felzot

---

## Purpose
This repository contains App.java (utility methods) and a JUnit 5 test suite (app/src/test/java/org/example/AppTest.java) that exercises those methods. The tests were added to satisfy the course assignment requirements for unit testing with Gradle.

## Prerequisites
- JDK 11 or newer installed and JAVA_HOME set.
- No global Gradle install required — the project includes the Gradle wrapper (./gradlew).

## Clone the repository
```bash
git clone https://github.com/Afeka-DevTools/26b-10142-unittesting-itay-and-yuval.git
cd 26b-10142-unittesting-itay-and-yuval
```

## Run all tests
Unix / macOS:
```bash
./gradlew test
```
Windows (PowerShell / cmd):
```powershell
gradlew.bat test
```

Run only the app module tests:
```bash
./gradlew :app:test
```

## Test reports
- Standard test report (JUnit): app/build/reports/tests/test/index.html
- If you add JaCoCo to the build, the coverage report will appear at: app/build/reports/jacoco/test/html/index.html

## What was added for the assignment
- app/src/test/java/org/example/AppTest.java — JUnit 5 test suite covering App.java functions and edge cases.
- logs/md.LEARNING.md — converted learning/chat logs (LLM learning conversation).
- logs/md.COPILOT.md — converted Copilot chat log.
- logs/this_conversation.md — transcript of the conversation that produced these changes (this includes the commit request).

## Notes and grading checklist (for your convenience)
- Tests use JUnit 5 (JUnit Jupiter) and standard assertions (assertEquals, assertTrue, assertThrows, etc.).
- Edge cases covered include negative inputs for factorial/fibonacci, empty arrays for average, and basic invalid inputs.
- Make sure to verify the logs/md files and README requirements from the assignment prompt (team list, chats in `chats/` and `logs/`).

If you want, I can also (only upon request):
- Add JaCoCo configuration to the Gradle build so a coverage report is generated automatically.
- Add a short CI workflow to run tests on push.

Good luck — let me know if you want me to make any wording changes in the README or add additional run examples.
