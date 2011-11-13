(ns ai-class.logic
    (:require [clojure.contrib.combinatorics :as combinatorics]))

(defn imp [a b]
    (if (and (= a false) (= b false)) true 
    (if (and (= a false) (= b true)) true 
    (if (and (= a true) (= b false)) false 
    (if (and (= a true) (= b true)) true )))))

(defn possible-results [lst expr]
    (let [size (count lst)
          contextual-eval (fn [ctx expr] (eval
                                           `(let [~@(mapcat (fn [[k v]] [k `'~v]) ctx)]
                                              ~expr)))
          pos (apply combinatorics/cartesian-product (take size (repeat [true false])))
          elements (map #(zipmap lst %) pos)]
        (map #(contextual-eval % expr) elements)))


