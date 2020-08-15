(ns stocks.service.stock
  (:require [compojure.core :refer [context GET]]
            [stocks.controller.stock :as controller]))

(def stock
  (context
   "/stock" []
   (GET "/" [] (controller/bad-request))
   (GET "/:stock-id" [stock-id]
        (controller/stock-info stock-id))))
