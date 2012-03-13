(defproject todo-list "1.0.0-SNAPSHOT"
  :description "A simple blog comments system"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [postgresql/postgresql "9.0-801.jdbc4"]
                 [org.clojure/java.jdbc "0.0.3"]
                 [ring/ring-jetty-adapter "0.3.10"]
                 [compojure "0.6.4"]
                 [hiccup "0.3.6"]]
  :dev-dependencies [[ring-serve "0.1.0"]])