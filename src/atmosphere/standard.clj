(ns atmosphere.standard)

(defn temperature
  "Calculate standard temperature.
  Results are within .1 of the data
  found on http://meteorologytraining.tpub.com/14269/css/14269_75.htm."
  [h]
  (- 15.04 (* 0.00649 h)))

(defn troposphere
  "Calculate standard pressure in kPa for the troposphere.
  The troposphere runs from the surface of the Earth to 11,000 meters."
  [h]
  (if (> h 11000)
    (throw (java.lang.IllegalArgumentException. (str h ": height cannot exceed 11000m.")))
    (let [T (temperature h)]
      (* 101.29
         (Math/pow (/ (+ T 273.1) 288.08)
                   5.256)))))

(defn lower-stratosphere
  "Calculate standard pressure in kPa for the lower stratosphere.
  The lower stratosphere runs from 11,000 meters to 25,000 meters.
  In the lower stratosphere the temperature is constant and the
  pressure decreases exponentially."
  [h]
  (if (or (< h 11000) (>= h 25000))
    (throw (java.lang.IllegalArgumentException. (str h ": height should be between 11,000 and 25,000.")))
    (let [T -56.46]
      (* 22.65
         (Math/exp (- 1.73 (* 0.000157 h)))))))

(defn upper-stratosphere
  "Calculate standard pressure in kPa for the upper stratosphere.
  The upper stratosphere is above 25,000 meters.
  In the upper stratosphere the temperature increases slightly and
  the pressure decreases exponentially."
  [h]
  (if (< h 25000)
    (throw (java.lang.IllegalArgumentException. (str h ": height should be over 25,000.")))
    (let [T (+ -131.21 (* 0.00299 h))]
      (* 2.488
         (Math/pow (/ (+ T 273.1) 216.6) -11.388)))))

(defn pressure
  "Calculate standard pressure in kPa."
  [h]
  (cond
    (< h 11000) (troposphere h)
    (< h 25000) (lower-stratosphere h)
    :else (upper-stratosphere h)))

