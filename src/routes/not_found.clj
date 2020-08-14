(ns routes.not-found
  (:require [ring.util.response :as resp]))

(defn not-found []
  (resp/not-found "These aren't the droids you're looking for.\n"))
