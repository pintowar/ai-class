(ns ai_class.test.logic
  (:require [ai-class.logic :as lgic])
  (:use [clojure.test]))

(deftest imp
  (is (= true (lgic/imp true true)))
  (is (= false (lgic/imp true false)))
  (is (= true (lgic/imp false true)))
  (is (= true (lgic/imp false false))) )

(deftest possible-results
  (is (= '(false false false true) (lgic/possible-results '[a b] '(and (= a b) (not (or a b)))) )))
