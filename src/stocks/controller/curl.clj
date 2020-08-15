(ns stocks.controller.curl
  (:require [clojure.java.shell :refer [sh]]))

(defn curl
  "Executes a curl call given an url"
  [url]
  (let [result (sh "curl" "-k" url)]
    (if (= 0 (:exit result))
      result
      (throw (RuntimeException.
              (str "shell-cmd: clojure.java.shell/sh failed. \n"
                   "exit status:" (:exit result) "\n"
                   "stderr:"      (:err  result) "\n"
                   "result:"      (:out  result) "\n"
                   ))))))


