# Crux techday

We hope you enjoyed the presentation.

During the hands-on we'll get you started with Crux.

Feel free to contact Mitchel or Fatih if you have any questions during the hands-on.

## Prerequisites
- Java 8 or higher
- IntelliJ (Use something else at your own risk, we highly recommend IntelliJ for ease of use and based the tutorial on IntelliJ)

## Lets get started

1. Download and install Cursive in IntelliJ.
2. Clone this repo `git clone git@github.com:avisi-apps/crux-techday.git` or using https `git clone https://github.com/avisi-apps/crux-techday.git`.
3. Import the project in IntelliJ.
4. Select `Import project from external model` and select `Leiningen` and click `Next`.
5. In the `Root directory` screen the defaults should be oke, so click `Next`.
6. In the `Select Leiningen project to import` screen the defaults should be oke, click `Next`.
7. In the `Please select project SDK` screen. Make sure to select a project SDK version of 8 or higher and click `Next`.
8. Finish by accepting the default name or changing the name of this project.
9. In a terminal cd into this project's repo and run `cp -R runConfigurations .idea` which copies the run configuration needed to start a Clojure REPL.
10. Click on `Add configuration` in IntelliJ somewhere on the top right bar and select `Clojure REPL -> Techday REPL` and click `Ok`.
11. Now we can run our REPL by clicking on the green play button next to `Techday REPL`. Now you got a REPL.
You should see the following output in the REPL output:
```
Starting nREPL server...
/opt/jdk1.8.0_192/bin/java ...
Connecting to local nREPL server...
Clojure 1.10.1
nREPL server started on port 33115 on host 127.0.0.1 - nrepl://127.0.0.1:33115
```
12. Open `tutorial.clj` in `src/avisi_apps/tutorial.clj`.

# Troubleshooting
Make sure that your project's SDK is correct in `File -> Project Structure... -> Project Settings -> Project`. Should be JDK 8 or higher.

If you get errors that symbols are not resolving try to invalidate caches and restart IntelliJ by: `File -> Invalidate Caches / Restart -> Invalidate and Restart`

If you can't clone using ssh, use https to clone this repo.

We also included bin/lein script in case you want to run leiningen in your terminal
