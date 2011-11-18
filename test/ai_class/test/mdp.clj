(ns ai_class.test.mdp
  (:require [ai-class.mdp :as mdp])
  (:use [clojure.test]))

(def poss {:n [[0.8 77] [0.1 -100]], :w [[0.1 77] [0.8 0]]})

(deftest value-iteration
  (is (= (hash-map :n 48.6) (mdp/value-iteration poss 1 -3)) ))
