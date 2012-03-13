(ns todo-list.models.base
  (:require [clojure.string :as str]
            [clojure.java.jdbc :as sql])
  (:import (java.net URI)))

(defn database-resource 
  ([] (database-resource (System/getenv "DATABASE_URL")))
  ([database_url] 
    (let [url (URI. database_url)
        host (.getHost url)
        port (if (pos? (.getPort url)) (.getPort url) 5432)
        path (.getPath url)]
    (merge
      {:subname (str "//" host ":" port path)}
      (if-let [user-info (.getUserInfo url)]
        {:user (first (str/split user-info #":"))
         :password (second (str/split user-info #":"))})))))

(def db
  (merge
    {:classname "org.postgresql.Driver"
     :subprotocol "postgresql"}
    (database-resource)))

(def hjd-db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//192.168.0.111:5432/ios_data"
   :user "zyh"
   :password "123456"})