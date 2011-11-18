(ns ai-class.test.reinforcement-learning
  (:require [ai-class.reinforcement-learning :as rl])
  (:use [clojure.test]))

(deftest state-update
  (is (= 1/2 (rl/state-update 0 1 1 0)))
  (is (= 1/6 (rl/state-update 0 1/2 2 0)))
  (is (= 2/3 (rl/state-update 1/2 1 2 0))))

(deftest temporal-difference-learning
  (is (= [1/6 2/3 1] (rl/temporal-difference-learning [0 0 1]))))
