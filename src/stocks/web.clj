(ns stocks.web
  (:require [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [stocks.service.routes :refer [app-routes]])
  (:gen-class))


(defn run-dev []
  (let [port (Integer. (or (env :port) 5000))]
    (println (str "Running server in dev mode on port " port))
    (jetty/run-jetty
     (wrap-defaults
      (wrap-reload
       (wrap-json-response #'app-routes))
      site-defaults)
     {:port port :join? false})))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (println (str "Running server on port " port))
    (jetty/run-jetty
     (wrap-defaults (wrap-json-response #'app-routes) site-defaults)
     {:port port :join? false})))


