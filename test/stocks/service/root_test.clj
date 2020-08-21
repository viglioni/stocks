(ns stocks.service.root-test
  (:require [clojure.test :refer :all]
            [stocks.web :refer :all]
            [ring.mock.request :as mock]))

(deftest hello-world
  (is (= (app (mock/request :get "/"))
         {:status  200
          :headers {"Content-Type" "application/octet-stream"}
          :body    "Hello There\n"})))

