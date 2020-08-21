(ns stocks.controller.ibov
  (:require [ring.util.http-response :as resp]
            [stocks.logic.itau :as logic]
            [stocks.controller.curl :refer [curl]]
            [stocks.controller.time :refer [date-and-time-js]]))

(defn stock-page
  "Gets a html page about the stock"
  [stock-id]
  (curl (logic/query stock-id)))


(defn bad-request []
  (resp/bad-request "I find your lack of stock code disturbing.\n"))


(defn stock-info [stock-id]
  (try
    (let [page (stock-page stock-id)]
      (if (logic/stock-not-found page)
        (resp/not-found "Lost a stock Master Obi-Wan has. How embarrassing.\n")
        (resp/ok {:price (logic/stock-price page)
                  :max (logic/day-max page)
                  :min (logic/day-min page)
                  :variation (logic/variation page)
                  :stock-id stock-id
                  :currency "brl"
                  :time (date-and-time-js)})))
    (catch Exception e
      ;; (println (str "caught exception: " (.getMessage e)))
      (resp/internal-server-error "The dark side clouds everything. Impossible to see this stock is."))))

