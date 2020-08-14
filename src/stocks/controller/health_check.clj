(ns stocks.controller.health-check
  (:require [ring.util.http-response :refer [ok]]))


(defn date-and-time []
  (java.util.TimeZone/setDefault
   (java.util.TimeZone/getTimeZone "America/Sao_Paulo"))
  (.toString (java.util.Date.)))

(defn health-check []
  (ok (str "It's working! It's working!\n" (date-and-time) "\n")))
