# Java Threads Exercises (Talkative & Parallel Sum)

![Language](https://img.shields.io/badge/language-Java-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Build](https://img.shields.io/github/actions/workflow/status/your-username/your-repo/ci.yml?label=CI)

Two concise examples to illustrate **multithreading in Java**:

- **Ex 1 — Talkative**: 10 threads print their ID 100 times each to show interleaved output.
- **Ex 2 — ParallelSum**: parallel sum of an int array using a fixed thread pool and `Callable` + `Future`.

> Main source: `ThreadsExercises.java` (contains `Talkative`, `TalkativeDemo`, `Sommeur`, `ParallelSum`).

---

## 🎯 What you’ll see (Ex 1)
```
[T-1] 1
[T-7] 7
[T-3] 3
[T-1] 1
...
Observation : sorties entrelacées, ordre non déterministe.
```

## 🚀 Run locally
```bash
# Compile
javac ThreadsExercises.java

# Run Exercise 1
java TalkativeDemo

# Run Exercise 2
java ParallelSum
```

> Requires JDK 11+ (JDK 17 recommended).

---

## 🧠 Concepts covered
- Creating threads with `Runnable`
- Thread scheduling and interleaved output (non-deterministic order)
- Using `ExecutorService` / thread pools (`newFixedThreadPool`)
- Partitioning work & aggregating results with `Callable` and `Future`

---

## 📁 Project layout
```
.
├── ThreadsExercises.java
├── README.md
├── LICENSE
└── .github/
    └── workflows/
        └── ci.yml
```

---

## ✅ CI (GitHub Actions)
This repository includes a minimal CI workflow that **compiles** the Java file on every push & PR.  
Badge above will work after you replace `your-username/your-repo` with your actual repo path in `README.md`.

See `.github/workflows/ci.yml`.

---

## 📸 Add a GIF in the README (optional)
1. Record a tiny terminal demo (e.g., OBS/ScreenToGif).
2. Save it as `demo.gif` in the repo root.
3. Add this line to the README:
   ```md
   ![Demo](demo.gif)
   ```

---

## 💾 How to upload on GitHub (website)
1. Create a new repository on GitHub (or open an existing one).
2. Click **Add file → Upload files**.
3. Upload: `ThreadsExercises.java`, `README.md`, `.gitignore`, `LICENSE`.
4. Create folders **.github/workflows/** and add `ci.yml` inside.
5. Commit changes.

**Commit message suggestion:**
```
feat: add Java threads exercises with README and CI
```

---

## 🧰 How to push from your computer (CLI)
```bash
git init
git add ThreadsExercises.java README.md .gitignore LICENSE
mkdir -p .github/workflows && mv ci.yml .github/workflows/ci.yml
git add .github/workflows/ci.yml
git commit -m "feat: add Java threads exercises with README and CI"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```

---

## 📜 License
MIT — see [LICENSE](LICENSE).
