(ns routes.health-check
  (:require [ring.util.http-response :refer [ok]]))

(defn health-check []
  (ok "It's working! It's working!\n"))
