(ns routes.routes
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [routes.hello-world :refer [hello-world]]
            [routes.not-found :refer [not-found]]
            [routes.health-check :refer [health-check]]))

(defroutes app-routes
  (GET "/" []
       (hello-world))
  (GET "/health-check" []
       (health-check))
  (ANY "*" []
       (route/not-found (not-found))))

