(ns stocks.service.ibov
  (:require [compojure.core :refer [context GET]]
            [stocks.controller.ibov :as controller]))

(def ibov
  (context
   "/ibov" []
   (GET "/" [] (controller/bad-request))
   (GET "/:stock-id" [stock-id]
        (controller/stock-info stock-id))
   ))
