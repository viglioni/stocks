(ns stocks.service.routes
  (:require [compojure.core :refer [defroutes]]
            [stocks.service.root :refer [root]]
            [stocks.service.health-check :refer [health-check]]
            [stocks.service.not-found :refer [not-found]]))

(defroutes app-routes
  root
  health-check
  not-found)

