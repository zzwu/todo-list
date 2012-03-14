(ns todo-list.controller
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as str]
            [ring.util.response :as response]
            [todo-list.view :as view]
            [todo-list.models.note :as note]))

(defn home
  []
  (view/home (note/all)))

(defn delete-note
  [id]
  (note/finish (Integer/parseInt id))
  (response/redirect "/home"))

(defn create-note
  []
  (view/create))

(defn create-note!
  [params]
  (note/create (:content params))
  (response/redirect "/home"))

(defroutes routes
  (GET "/" [] (response/redirect "/home"))

  (GET "/home" [] (home))
  (GET "/delete/:id" [id] (delete-note id))
  (GET "/create" [] (create-note))
  (POST "/create-note" {params :params} (create-note! params)))

