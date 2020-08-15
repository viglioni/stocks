(ns stocks.logic.stock-info
  (:require [clojure.string :refer [replace]]))


(defn formated-value [string]
  (replace (replace (or string "") #"[^0-9\,\-]" "") #"\," "."))

(defn stock-price [html]
  (formated-value (re-find #"[0-9]+,[0-9]+" (str html)) ))

(defn variation [html]
  (formated-value (re-find #"-?[0-9]+,[0-9]{2}\%" (str html))))

(defn day-max [html]
  (formated-value (re-find #"id=[\\\"]*maximo[\\\"]*>[0-9]+\,[0-9]{2}</strong>" (str html))))

(defn day-min [html]
  (formated-value (re-find #"id=[\\\"]*minimo[\\\"]*>[0-9]+\,[0-9]{2}</strong>" (str html))))

(defn stock-not-found [html]
  (let [not-found-text (re-find #"Não foram encontrados ativos para sua busca" (str html))]
    (if not-found-text true nil)))
