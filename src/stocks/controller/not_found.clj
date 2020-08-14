(ns stocks.controller.not-found
  (:require [ring.util.http-response :as resp]))

(defn not-found []
  (resp/not-found "These aren't the droids you're looking for.\n"))
