(ns stocks.service.not-found-test
  (:require [clojure.test :refer :all]
            [stocks.web :refer :all]
            [ring.mock.request :as mock]))



(deftest not-found
  (is (= (app (mock/request :get "/*"))
         {:status  404
          :headers {"Content-Type" "application/octet-stream"}
          :body    "These aren't the droids you're looking for.\n"})))

