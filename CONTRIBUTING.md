# Contributing

## Picking an Issue

1. Start with **Issues #1–3** (🟢 Easy) — they are independent and follow the existing pattern closely
2. Move to **Issue #4** (🟡 Medium) once you're comfortable — it introduces more business logic
3. **Issues #5–6** (🟡 Medium) can be done in parallel by different people
4. **Issues #7–8** (🟠 Challenging) depend on earlier issues and require deeper thinking

## Workflow

1. **Assign yourself** to the issue so others know it's taken
2. **Create a feature branch** from `main`:
   ```bash
   git checkout main
   git pull
   git checkout -b feature/issue-1-port-crud
   ```
3. **Do your work** — follow the patterns in `FreightOrderController`
4. **Run checks before pushing:**
   ```bash
   mvn clean install   # builds + runs tests
   mvn fmt:check       # verifies Google code style
   ```
5. **Push and open a PR:**
   ```bash
   git push origin feature/issue-1-port-crud
   ```
6. **PR title format:** `#1 — Add Port CRUD controller`
7. **Request a review** and address feedback

## Branch Naming

| Type    | Pattern                          | Example                              |
|---------|----------------------------------|--------------------------------------|
| Feature | `feature/issue-N-short-name`     | `feature/issue-4-voyage-controller`  |
| Bugfix  | `fix/issue-N-short-name`         | `fix/issue-8-double-booking`         |
| Chore   | `chore/short-name`               | `chore/update-readme`                |

## Commit Messages

Keep them short and descriptive. Prefix with the issue number:

```
#1 add CreatePortRequest DTO and validation
#1 add PortService and PortController
#1 add PortControllerTest
```

## Code Style

This project enforces [Google Java Format](https://github.com/google/google-java-format). The build auto-formats your code, but you can also run it manually:

```bash
mvn fmt:format    # auto-format
mvn fmt:check     # check without changing
```

Set up your IDE plugin so you don't have to think about it:
- **IntelliJ:** Install the "google-java-format" plugin → Settings → Enable
- **VS Code:** Install the "Google Java Format" extension

## What Makes a Good PR

- **One issue per PR** — don't bundle unrelated changes
- **Tests included** — follow `FreightOrderControllerTest` as a template
- **DTO layer respected** — never expose JPA entities directly in responses
- **Formatting clean** — `mvn fmt:check` must pass
- **Small and reviewable** — if it's getting big, break it up
