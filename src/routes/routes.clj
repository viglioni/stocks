(ns routes.routes
  (:require [compojure.core :refer [defroutes GET ANY context]]
            [compojure.route :as route]
            [routes.hello-world :refer [hello-world]]
            [routes.not-found :refer [not-found]]
            [routes.health-check :refer [health-check]]
            [routes.stock :refer [stock-info]]))


(defroutes app-routes
  (GET "/" []
       (hello-world))
(GET "/health-check" []
       (health-check))
  (GET "/stock/:stock-id" [stock-id]
       (stock-info stock-id))
  (ANY "*" []
       (route/not-found (not-found))))

