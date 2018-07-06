(ns atmosphere.convert
  (:require [atmosphere.standard :as std]
            [atmosphere.core :refer :all]))

(defn mach-to-true
  [mach altitude]
      (let [t0 288.15
            t (c-to-k (std/temperature altitude))]
      (* (Math/sqrt (/ t t0)) mach altitude)))

447.38
