(ns routes.hello-world
  (:require [ring.util.http-response :refer [ok]]))

(defn hello-world []
  (ok "Hello There\n"))
 
