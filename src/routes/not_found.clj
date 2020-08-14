(ns routes.not-found)

(defn not-found []
  {:status 404
   :headers {"Content-Type" "text/plain"}
   :body "These aren't the droids you're looking for."})
