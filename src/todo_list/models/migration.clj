(ns todo-list.models.migration
  (:use [todo-list.models.base :only (db)])
  (:require [clojure.java.jdbc :as sql]))

(defn create-note-table
  []
  (sql/with-connection
    db
    (sql/create-table :note
                    [:id :serial "PRIMARY KEY"]
                    [:content :varchar "NOT NULL"]
                    [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))


(defn -main []
  (print "Migrating database...") (flush)
  (create-note-table)
  (println " done"))