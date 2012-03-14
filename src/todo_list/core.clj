(ns todo-list.core
  (:use [compojure.core :only [defroutes]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]
            [todo-list.controller]))

(defroutes reoutes
  todo-list.controller/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def app (hanlder/site routes))

(defn start [port]
  (ring/run-jetty (var app) {:port (or port 8080) :join false }))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))


