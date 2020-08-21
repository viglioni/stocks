(ns stocks.web
  (:require [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [stocks.service.routes :refer [app-routes]])
  (:gen-class))


(def app
  (-> app-routes
      (wrap-json-response)
      (wrap-content-type)
      (wrap-defaults api-defaults)))

(defn run-dev [& [custom-port]]
  (let [port (Integer. (or custom-port (env :port) 5000))]
    (println (str "\n\nRunning server in dev mode on port " port "\n\n"))
    (jetty/run-jetty (wrap-reload app) {:port port :join? false})))

(defn -main [& [custom-port]]
  (let [port (Integer. (or custom-port (env :port) 5000))]
    (println (str "\n\nRunning server in dev mode on port " port "\n\n"))
    (jetty/run-jetty app {:port port :join? false})))


