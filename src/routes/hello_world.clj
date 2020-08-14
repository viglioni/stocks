(ns routes.hello-world)

(defn hello-world []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello There"})
