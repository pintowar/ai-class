(ns ai-class.naive-bayes
  (:require [clojure.string :as string]
            [clojure.set :as set]))

(defn total-words-group
    ([sentence group all] (total-words-group sentence group all 1))
    ([sentence group all k]
        (let [count-words-group (fn [word group]
                (count (filter #(not= % nil) (map #(re-find (re-pattern word) %) group)))),
              total-unique-words (fn [group]
                (count (set (flatten (map #(string/split % #"\s+") group))))),
              total-word-group (fn [word group]
                (/ (+ k (count-words-group (re-pattern word) group))
                (+ (apply + (map #(count (string/split % #"\s+")) group)) (* k (total-unique-words all)))
                ))]
        (apply * (map #(total-word-group % group) (string/split sentence #"\s+"))))))

(defn prob-group-word
    ([group sentence all] (prob-group-word group sentence all 1))
    ([group sentence all k]
         (let [not-group (vec (set/difference (set all) (set group))),
               prob-group (/ (+ k (count group)) (+ (* k 2) (count all))),
               prob-not-group (/ (+ k (count not-group)) (+ (* k 2)(count all))),
               prob-sentence-group (total-words-group sentence group all),
               prob-sentence-not-group (total-words-group sentence not-group all)]
            (/ (* prob-group prob-sentence-group)
               (+ (* prob-group prob-sentence-group) (* prob-not-group prob-sentence-not-group))))))
