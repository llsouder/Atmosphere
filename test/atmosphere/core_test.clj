(ns atmosphere.core-test
  (:require [clojure.test :refer :all]
            [atmosphere.core :refer :all]))

(defn difference ^double [^double x ^double y]
  (Math/abs (double (- x y))))

(defn close? [tolerance x y]
  (< (difference x y) tolerance))

(deftest convert-temp-test
  (testing "Convert from fahrenheit to celsius."
    (is (= 0.0 (f-to-c 32.0)))
    (is (= 100.0 (f-to-c 212.0)))
    (is (close? 0.1 -22.6 (f-to-c -8.8)))
    (is (= 15.0 (f-to-c 59.0)))))

(deftest convert-altitude-test
  (testing "Convert from feet to meters."
    (is (= 0.0 (f-to-m 0.0)))
    (is (= 0.3048 (f-to-m 1.0)))
    (is (= 3048.0 (f-to-m 10000)))))

(deftest std-temp-test
  (testing "Calculating standard temperature calculation."
    (is (close? 0.1 15.0 (std-temp 0)))
    (is (close? 0.1 -4.8 (std-temp (f-to-m 10000))))
    (is (close? 0.1 -24.6 (std-temp (f-to-m 20000))))))
