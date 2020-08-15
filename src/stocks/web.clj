(ns stocks.web
  (:require [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [stocks.service.routes :refer [app-routes]]))


(defn run-dev []
  (println "Running serer in dev mode!")
  (jetty/run-jetty
   (wrap-defaults
    (wrap-reload
     (wrap-json-response #'app-routes))
    site-defaults)
   {:port (Integer. (or (env :port) 5000)) :join? false}))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty
     (wrap-defaults (wrap-json-response #'app-routes) site-defaults)
     {:port port :join? false})))


