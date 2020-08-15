(ns stocks.controller.stock
  (:require [ring.util.http-response :as resp]
            [stocks.logic.stock-info :as logic]
            [clojure.java.shell :refer [sh]]))




(defn stock-page [stock-id]
  (let [result (sh "curl" (logic/query stock-id))]
    (if (= 0 (:exit result))
      result
      (throw (RuntimeException.
              (str "shell-cmd: clojure.java.shell/sh failed. \n"
                   "exit status:" (:exit result) "\n"
                   "stderr:"      (:err  result) "\n"
                   "result:"      (:out  result) "\n"
                   ))))))


(defn bad-request []
  (resp/bad-request "I find your lack of stock code disturbing.\n"))


(defn stock-info [stock-id]
  (let [page (stock-page stock-id)]
    (if (logic/stock-not-found page)
      (resp/not-found "Lost a stock Master Obi-Wan has. How embarrassing.")
      (resp/ok {:price (logic/stock-price page)
                :max (logic/day-max page)
                :min (logic/day-min page)
                :variation (logic/variation page)
                :stock-id stock-id
                }))))
