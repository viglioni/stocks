(ns stocks.controller.stock
  (:require [ring.util.http-response :as resp]))



(defn stock-info [stock-id]
  (resp/ok {:a 1})
)

(defn bad-request []
  (resp/bad-request "I find your lack of stock code disturbing.\n"))
