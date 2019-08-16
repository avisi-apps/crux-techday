# Crux techday

We hope you enjoyed the presentation.

During the hands-on we'll get you started with Crux.

Feel free to contact Michel, Timo or Fatih if you have any questions during the hands-on.

## Prerequisites
- Java 8 or higher
- IntelliJ (Use something else at your own risk, we highly recommend IntelliJ for ease of use and based the tutorial on IntelliJ)
- Cursive plugin for IntelliJ (The only IntelliJ Clojure plugin you'll need)

## Lets get started

1. Clone this repo `git clone git@github.com:avisi-apps/crux-techday.git` or using https `git clone https://github.com/avisi-apps/crux-techday.git`
2. Import project in IntelliJ.
3. Select `Import project from external model` and select `Leiningen` and click `Next`.
4. In the `Root directory` screen the defaults should be oke, so click `Next`.
5. In the `Select Leiningen project to import` screen the defaults should be oke, click `Next`.
6. In the `Please select project SDK` screen. Make sure to select a project SDK version of 8 or higher and click `Next`.
7. Run `make run-config` in your terminal which copies the run configuration needed to start a Clojure REPL
8. Click on `Add configuration` in IntelliJ somewhere on the top right corner and select `Clojure REPL -> Techday REPL` and click `Ok`
9. Now we can run our repl by clicking on the green play button next to `Techday REPL`. Now you got a REPL.
10. Open `tutorial.clj` in `src/avisi_apps/tutorial.clj`

# Troubleshooting
If you get errors that symbols are not resolving try to invalidate caches and restart IntelliJ by: `File -> Invalidate Caches / Restart -> Invalidate and Restart`
