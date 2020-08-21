(ns test-dev
  (:require [clojure.java.shell :refer [sh]]))



(defn test-files [] (list (:out (sh "find" "test" "-name" "*test.clj"))))



(println (map identity (test-files)))

