(ns avisi-apps.tutorial
  (:require [crux.api :as api]))
;; 1. The above is called a Clojure form.
;;    Stand anywhere on the previous form
;;    with your cursor and execute this line
;;    with the key binding alt + shift + p (shift + cmd + p for mac)
;;    This will execute this statement and require this namespace in your REPL.
;;    This should first print the form in your REPL and afterwards return => nil
;;    This means that the execution of the form returns nil which is good in this case.

(comment

  (+ 1 1)
  ;; 2. Execute the above form and you should see => 2

  (calculation 2)
  ;; 3. Execute the above form and you should see an error because this function doesn't exist yet.

  (defn calculation [x]
    (* 5 (+ 3 x)))
  ;; 4. Execute this form and afterwards the calculation from 3 again
  ;;    Every time you change a function definition you have to execute it again.
  ;;    After redefining a function your REPL will know the new definition.

  (defonce node (api/start-standalone-node {:db-dir "target/db"
                                            :kv-backend "crux.kv.rocksdb.RocksKv"
                                            :event-log-dir "target/event-log"}))
  ;; 5. Execute this form and you will have a crux node.

  ;; 6. Experiment! You can use this crux node to query to your heart's desire.

  ;; Where to go from here?
  ;; You can take a look at `crux.clj` which Mitchel used during his demo in his presentation.

  ;; Documentation
  ;; https://juxt.pro/crux/docs/index.html

  ;; EDN reference
  ;; see the file `example.edn` or https://juxt.pro/crux/docs/tutorials.html#_essential_edn

  ;; Our ideas for the hands-on

    ;; Crux tutorial (Good place to start)
    ;; https://juxt.pro/crux/docs/tutorials.html#_space_adventure
    ;; or
    ;; https://juxt.pro/crux/docs/tutorials.html#_a_bitemporal_tale

    ;; Model your domain

    ;; Java API (Good luck)
    ;; https://juxt.pro/crux/docs/api.html#_javadocs

  ;; Pro tip: If you want to know which key bindings are available to work with your REPL
  ;;          right click anywhere in this file and see all options under REPL

  ;; IdeaVim pro tip: https://github.com/fatihict/.ideavimrc/blob/master/.ideavimrc
)
