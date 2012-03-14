(ns todo-list.models.note
  (:use [todo-list.models.base :only (db)])
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/with-connection db
    (sql/with-query-results results
      ["select * from note order by id desc"]
      (into [] results))))

(defn create
  [content]
  (print (str "create note , content:" content))
  (sql/with-connection db
    (sql/insert-values :note [:content] [content])))

(defn finish
  [id]
  (sql/with-connection
    db
    (sql/delete-rows :note
      ["id=?" id])))

