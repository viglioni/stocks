(ns stocks.logic.itau
  (:require [clojure.string :refer [replace]]))


(def url-base  "https://www.itaucorretora.com.br/Finder/Finder?stock=")
(def number-base "[0-9\\.]+,[0-9]{2}")
(def signed-number-with-per (str "-?" number-base "%"))
(def stock-found-pattern #"id=\\\"dados-ativo\\\"")
(defn day-var-pattern [x]
  (str #"id=[\\\"]*" x #"[\\\"]*>" number-base "</strong>"))
(def day-max-pattern (day-var-pattern "maximo"))
(def day-min-pattern (day-var-pattern "minimo"))



(defn formated-value
  "Formats a value to be money formated number"
  [string]
  (replace (replace (or string "") #"[^0-9\,\-]" "") #"\," "."))

(defn regex-qry
  "Generic function to get info from a html file using a regex pattern"
  [rexp html]
  (formated-value (re-find (re-pattern rexp) (str html))))

(defn query
  "Mounts the url to be used in a curl call"
  [stock-id]
  (str url-base stock-id))

(defn stock-not-found
  "Checks if the stock given is valid"
  [html]
  (let [stock-found-text (re-find (re-pattern stock-found-pattern) (str html))]
    (if stock-found-text nil true)))

;;
;; Applying regex-qry to get all the info the endpoint needs
;;

(defn stock-price [html]
  (regex-qry number-base html))

(defn variation [html]
  (regex-qry signed-number-with-per html))

(defn day-max [html]
  (regex-qry day-max-pattern html))

(defn day-min [html]
  (regex-qry day-min-pattern html))

