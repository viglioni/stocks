(ns stocks.service.root
  (:require [compojure.core :refer [GET context]]
            [stocks.controller.root :as controller]))

(def root
  (context
   "/" []
   (GET "/" [] (controller/hello-world))))
