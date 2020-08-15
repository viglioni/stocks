(ns stocks.controller.time)

(defn date-and-time
  "Returns date and time at São Paulo/Brazil timezone"
  []
  (java.util.TimeZone/setDefault
   (java.util.TimeZone/getTimeZone "America/Sao_Paulo"))
  (java.util.Date.))

(defn date-and-time-hr
  "Returns a human readable date and time at São Paulo/Brazil timezone"
  []
  (.toString (date-and-time)))

(defn date-and-time-js
  "Returns a 'javascript-readable' date and time at São Paulo/Brazil timezone"
  []
  (.format (java.text.SimpleDateFormat. "yyyy-MM-dd'T'HH:mm:ss.SSSZ") (date-and-time)))
