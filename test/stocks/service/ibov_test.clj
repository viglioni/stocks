(ns stocks.service.ibov-test
  (:require [clojure.test :refer :all]
            [stocks.web :refer :all]
            [ring.mock.request :as mock]
            [clojure.data.json :as json]))

(defn none-empty [strings]
  (reduce
   (fn [acc val] (if (> (count val) 0) acc false))
   true
   strings))


(deftest valid-stock
  (let [res (app (mock/request :get "/ibov/usim5"))
        {status :status headers :headers } res
        body (json/read-str (:body res))
        body-keys (keys body)
        body-values (vals body)]
    (are [x y] (= x y)
      status 200
      headers {"Content-Type" "application/json; charset=utf-8"}
      body-keys ["price" "max" "min" "variation" "stock-id" "currency" "time"]
      (none-empty body-values) true)))


(deftest invalid-stock
  (is (= (app (mock/request :get "/ibov/invalid"))
         {:status 404
          :headers {"Content-Type" "application/octet-stream"}
          :body "Lost a stock Master Obi-Wan has. How embarrassing.\n"})))

(deftest stockless
  (is (= (app (mock/request :get "/ibov"))
         {:status 400
          :headers {"Content-Type" "application/octet-stream"}
          :body "I find your lack of stock code disturbing.\n"})))
