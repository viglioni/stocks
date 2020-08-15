(ns stocks.controller.health-check
  (:require [ring.util.http-response :refer [ok internal-server-error]]
            [stocks.controller.curl :refer [curl]]
            [stocks.controller.time :refer [date-and-time-hr]]))




(defn health-check []
  (try
    (curl "https://www.itaucorretora.com.br/Finder/Finder?stock=usim5")
    (ok (str "It's working! It's working!\n" (date-and-time-hr) "\n"))
    (catch Exception e
      (println (.getMessage e))
      (internal-server-error
       (str "I don't think the system works.\n" (date-and-time-hr) "\n")))))
