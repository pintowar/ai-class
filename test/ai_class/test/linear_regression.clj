(ns ai_class.test.linear-regression
  (:require [ai-class.linear-regression :as lr])
  (:use [clojure.test]))

(def data [{:x 3, :y 0}{:x 6, :y -3}{:x 4, :y -1}{:x 5,:y -2}])

(deftest calc-w-one
  (is (= -1 (lr/calc-w-one data)) ))

(deftest calc-w-zero
  (is (= {:a -1, :b 3} (lr/calc-w-zero data)) ))
