(ns todo-list.view
  (:use [hiccup.core :only [html escape-html]]
        [hiccup.form-helpers :only [form-to label text-area text-field submit-button]])
  (:require [todo-list.layout :as layout]))

(defn note-display
  [note]
  [:h2 {:class "note"} (escape-html (:content note))])

(defn home
  [notes]
  (layout/common 
    "TodoList"
    [:div
     (map note-display notes)]))


