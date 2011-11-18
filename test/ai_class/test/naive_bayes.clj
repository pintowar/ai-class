(ns ai-class.test.naive-bayes
  (:require [ai-class.naive-bayes :as nb])
  (:use [clojure.test]))

(def spams ["offer is secret" "click secret link " "secret sports link"])
(def hams ["play sports today" "went play sports" "secret sports event" "sports is today" "sports cost money"])
(def all-groups (flatten (list hams spams)))

(deftest total-words-group
  (is (= 4/21 (nb/total-words-group "secret" spams all-groups)) ))

(deftest prob-group-word
  (is (= 36/85 (nb/prob-group-word spams "secret sports" all-groups) )))
