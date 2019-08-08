(ns avisi-apps.crux
  (:require [crux.api :as api]))

(defonce crux-node (api/start-standalone-node {:db-dir "target/db"
                                               :kv-backend "crux.kv.rocksdb.RocksKv"
                                               :event-log-dir "target/event-log"}))

(comment
  ;(.close crux-node)

  (api/submit-tx crux-node                                  ; The Crux instance
                 [[:crux.tx/put {:crux.db/id :person/mitchel ; The Transaction
                                 :person/os "Linux"
                                 :person/editor ["Intellij" "Emacs"]
                                 :person/name "Mitchel Kuijpers"}]
                  [:crux.tx/put {:crux.db/id :person/fatih
                                 :person/os "Linux"
                                 :person/editor ["NeoVim" "Intellij"]
                                 :person/name "Fatih Demir"}]
                  [:crux.tx/put {:crux.db/id :person/timo
                                 :person/os "OSX"
                                 :person/editor "Intellij"
                                 :person/name "Timo van der Kamp"}]

                  [:crux.tx/put {:crux.db/id :person/geert
                                 :person/os "OSX"
                                 :person/editor "Intellij"
                                 :person/teams #{:team/aa :team/liet}
                                 :person/name "Geert Liet"}]

                  [:crux.tx/put {:crux.db/id :team/aa
                                 :team/name "Avisi Apps"
                                 :team/members #{:person/fatih
                                                 :person/mitchel
                                                 :person/timo}}]])

 (let [db (api/db crux-node)]
   (api/entity db :person/mitchel))

  ;; Find all persons
  (api/q
   (api/db crux-node)
   '{:find [?person-name] ; datalog's find is like SELECT in SQL
     :where [[_ :person/name ?person-name]]})

  ;; Find all team members of a team
  (api/q
   (api/db crux-node)
   '{:find [?member-name ?member]
     :where [[:team/aa :team/members ?member]
             [?member :person/name ?member-name]]})

  ;; Find all persons without a team
  (api/q
   (api/db crux-node)
   '{:find [?person-name]
     :where [[?person :person/name ?person-name]
             (not [_ :team/members ?person])]})

  ;; Find all team members of a team who use Linux
  (api/q
   (api/db crux-node)
   '{:find [?member]
     :where [[:team/aa :team/members ?member]
             [?member :person/name _]
             [?member :person/os "Linux"]]})

  ;; Find the team-name by a user
  (api/q
   (api/db crux-node)
   '{:find [?team-name]
     :where [[?team :team/members :person/mitchel]
             [?team :team/name ?team-name]]})

  ;; Find which editors are getting used with which os
  (api/q
   (api/db crux-node)
   '{:find [?editor ?os]
     :where [[?e :person/editor ?editor]
             [?e :person/os ?os]]})

  (api/history crux-node :person/fatih)

  (map
   (fn [tx]
     {:valid-time (:crux.db/valid-time tx)
      :tx-time (:crux.tx/tx-time tx)
      :document (:person/editor (api/document crux-node (:crux.db/content-hash tx)))})
   (api/history crux-node :person/fatih))

  (api/submit-tx
   crux-node
   [[:crux.tx/put {:crux.db/id :person/fatih
                   :person/os "Linux"
                   :person/editor "Vim"
                   :person/name "Fatih Demir"}
     #inst "2017-01-01"]
    [:crux.tx/put {:crux.db/id :person/fatih
                   :person/os "Linux"
                   :person/editor "Emacs"
                   :person/name "Fatih Demir"}
     #inst "2018-01-01"]
    [:crux.tx/put {:crux.db/id :person/fatih
                   :person/os "Linux"
                   :person/editor "NeoVim"
                   :person/name "Fatih Demir"}
     #inst "2019-01-01"]])

  (map
   (fn [tx]
     {:valid-time (:crux.db/valid-time tx)
      :tx-time (:crux.tx/tx-time tx)
      :editor (:person/editor (api/document crux-node (:crux.db/content-hash tx)))})
   (api/history crux-node :person/fatih))

  (api/entity (api/db crux-node #inst "2018-12-01") :person/fatih)
  )
