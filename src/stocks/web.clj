(ns stocks.web
  (:require [compojure.handler :refer [site]]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [ring.middleware.reload :refer [wrap-reload]]
            [routes.routes :refer [app-routes]]))


(defn run-dev []
  (println "Running serer in dev mode!")
  (jetty/run-jetty (wrap-reload #'app-routes)
                   {:port (Integer. (or (env :port) 5000)) :join? false}))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (wrap-reload #'app-routes) {:port port :join? false})))


