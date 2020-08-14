(ns stocks.service.health-check
  (:require [compojure.core :refer [GET context]]
            [stocks.controller.health-check :as controller]))

(def health-check
  (context
   "/health-check" []
   (GET "/" [] (controller/health-check))))

