(ns routes.health-check)

(defn health-check []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "It's working! It's working!"})
