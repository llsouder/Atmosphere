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

(defn c-to-k
  "Convert from celsius to kelvin."
  [c]
  (+ c 273.15))
