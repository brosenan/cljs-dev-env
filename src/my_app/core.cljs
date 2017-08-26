(ns my-app.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(defn plus [x y]
  (+ x y))

(defn app []
  [:p "I did my part. Now it's your turn..."])

(defn render []
  (let [c (js/document.getElementById "app")]
    (prn c)
    (r/render [app] c)))
(render)
