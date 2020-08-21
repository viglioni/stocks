(ns stocks.service.health-check-test
  (:require [clojure.test :refer :all]
            [stocks.web :refer :all]
            [ring.mock.request :as mock]))


(deftest health-check
  (let [res (app (mock/request :get "/health-check"))
        {status :status headers :headers body :body} res
        message (re-find #"It's working!" body)]
    (are [x y] (= x y)
      status 200
      headers {"Content-Type" "application/octet-stream"}
      message "It's working!")))
