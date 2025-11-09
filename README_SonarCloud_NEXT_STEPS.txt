Maven-ready version of your project.

What I changed:
- Moved all .java files into `src/main/java/` (kept package hierarchy if present).
- Added a `pom.xml` configured for Java 17.
- Added `.github/workflows/sonarcloud.yml` for GitHub Actions + SonarCloud.

Detected Java files moved: 12
Example moved files (first 20):
[
  "src/main/java/quiz/app/Main.java",
  "src/main/java/quiz/app/controller/EQTestController.java",
  "src/main/java/quiz/app/controller/ScoreController.java",
  "src/main/java/quiz/app/controller/SessionController.java",
  "src/main/java/quiz/app/model/FileStorage.java",
  "src/main/java/quiz/app/model/PersonalityTrait.java",
  "src/main/java/quiz/app/model/Question.java",
  "src/main/java/quiz/app/model/QuestionBank.java",
  "src/main/java/quiz/app/model/Result.java",
  "src/main/java/quiz/app/view/EQTestView.java",
  "src/main/java/quiz/app/view/ScoreView.java",
  "src/main/java/quiz/app/view/SessionStarterView.java"
]

Detected packages: ["quiz.app", "quiz.app.controller", "quiz.app.model", "quiz.app.view"]

Next steps for you:
1. Inspect the project locally: `cd` into the project and run:
   mvn -B clean compile
   mvn -B test       (if you have tests)
2. Commit & push to GitHub:
   git init
   git add .
   git commit -m "Convert project to Maven and add SonarCloud workflow"
   git branch -M main
   git remote add origin <your-github-repo-url>
   git push -u origin main
3. On SonarCloud:
   - Sign in with GitHub and import your repository.
   - Generate a SONAR_TOKEN in SonarCloud (Account → Security → Generate Token).
   - In GitHub repo settings → Secrets → Actions → New repository secret:
       Name: SONAR_TOKEN
       Value: <paste-token-here>
4. After pushing, GitHub Actions will run and SonarCloud analysis will be triggered.

If you want, I can create the final ZIP with these changes so you can download it and push to GitHub.
