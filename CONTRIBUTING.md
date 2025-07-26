# Contributing to Kotlin Code Collection

Thanks for your interest in contributing!

This project is open to all kinds of contributions - from adding new code examples, reviewing PRs, proposing a cleanup, testing, or documentation.

---

## 🧩 Issues

We use issues to manage:
- Tasks or examples that need to be implemented
- Bug reports or broken tests
- Suggestions for new recipes, snippets, or patterns


You’re also welcome to open new issues if you:
- Found something broken or unclear
- Noticed a missing example or snippet
- Have an idea for a useful addition

---

## 💬 Submitting a Contribution

1. Fork this repo
2. Create a new branch (`git checkout -b my-example`)
3. Add your `.kt` file(s) and test(s)
4. Update the relevant package’s `README.md`
5. Open a Pull Request with a short, clear description. Link it to relevant issue.

---

## 📁 Where Does My Code Go?

Each code example belongs in a specific package, based on its purpose. This helps keep the project organized and easier to navigate.

When working on an issue, a `type:` label helps you to match the target package.

| Package           | What belongs there                                                            |
|-------------------|-------------------------------------------------------------------------------|
| `snippets/`       | small, standalone functions (e.g., format date, read file, string operations) |
| `algorithms/`     | classic CS problems (e.g., binary search, DP)                                 |
| `patterns/`       | design patterns in Kotlin (e.g., singleton, builder)                          |
| `kotlinfeatures/` | Kotlin-specific syntax or concepts (e.g., sealed)                             |

Each package has its own `README.md` with examples - follow its format when adding new content.

---

## ✍️ Code Style

- Keep it **idiomatic Kotlin** - use modern features like `val`, extension functions, smart casts, etc.
- Name your file clearly (`CamelCase.kt`)
- Avoid Java-style code 
- No unnecessary boilerplate

## 🧹 Formatting & Linting
  This project uses ktlint to enforce consistent Kotlin style.

Before submitting a pull request, run:
```
./gradlew ktlintCheck 
    or
./gradlew build
```
To auto-fix formatting issues, run:
```
./gradlew ktlintFormat
```

---

## 🧪 Tests

- Every `.kt` file should have a matching test
- Use kotlin.test
- Keep tests minimal but meaningful
- File name should mirror the source file

---

## 🙏 Thanks for contributing!
