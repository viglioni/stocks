(ns stocks.logic.stock-info
  (:require [clojure.string :refer [replace]]))


(def number-base "[0-9]+,[0-9]{2}")
(def signed-number-with-per (str "-?" number-base "%"))
(def day-max-pattern #"id=[\\\"]*maximo[\\\"]*>[0-9]+,[0-9]{2}</strong>")
(def day-min-pattern #"id=[\\\"]*minimo[\\\"]*>[0-9]+,[0-9]{2}</strong>")
(def not-found-pattern #"Não foram encontrados ativos para sua busca")



(defn formated-value [string]
  (replace (replace (or string "") #"[^0-9\,\-]" "") #"\," "."))

(defn query [stock-id]
  (str "https://www.itaucorretora.com.br/Finder/Finder?stock=" stock-id))

(defn stock-price [html]
  (formated-value (re-find (re-pattern number-base) (str html)) ))

(defn variation [html]
  (formated-value (re-find (re-pattern signed-number-with-per) (str html))))

(defn day-max [html]
  (formated-value (re-find day-max-pattern (str html))))

(defn day-min [html]
  (formated-value (re-find day-min-pattern (str html))))

(defn stock-not-found [html]
  (let [not-found-text (re-find not-found-pattern (str html))]
    (if not-found-text true nil)))
