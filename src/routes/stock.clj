(ns routes.stock
  (:require [ring.util.http-response :refer [ok]]))

(defn stock-info [stock-id]
  (ok (str "stock " stock-id "\n")))
