(ns atmosphere.core
  (:gen-class))

(defn f-to-c
  "Convert from fahrenheit to celsius."
  [f]
  (/ (- f 32.0) 1.8))

(defn f-to-m
  "Convert from feet to meters."
  [f]
  (* f 0.3048))

(defn std-temp
  "Calculate standard temperature.
  Results are within .1 of the data
  found on http://meteorologytraining.tpub.com/14269/css/14269_75.htm."
  [h]
  (- 15.04 (* 0.00649 h)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
