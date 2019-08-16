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
  ;; 5. Execute this form and you will have a crux-node.

  ;; 6. Experiment! You can look at `crux.clj` which Mitchel used during his demo in his presentation.
  ;;    Take a look at the documentation https://juxt.pro/crux/docs/get_started.html#_transacting
  ;;    And build something awesome!
)
