(ns stocks.service.not-found
  (:require [compojure.core :refer [ANY]]
            [stocks.controller.not-found :as controller]
            [compojure.route :as route]))


(def not-found
  (ANY "*" [] (controller/not-found)))
