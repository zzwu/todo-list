(ns todo-list.controller
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as str]
            [ring.util.response :as response]
            [todo-list.view :as view]
            [todo-list.models.note :as note]))

(defn home
  []
  (view/home (note/all)))

(defroutes routes
  (GET "/" [] (response/redirect "/home"))

  (GET "/home" [] (home)))

