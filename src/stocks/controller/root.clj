(ns stocks.controller.root
  (:require [ring.util.http-response :refer [ok]]))

(defn hello-world []
  (ok "Hello There\n"))
