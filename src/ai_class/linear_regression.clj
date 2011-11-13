(ns ai-class.linear-regression)

(defn calc-w-one [data]
    (let [a (* (count data) (reduce + (map #(* (get % :x) (get % :y)) data))), 
          b (* (reduce + (map #(get % :x) data)) (reduce + (map #(get % :y) data))), 
          c (* (count data) (reduce + (map #(* (get % :x) (get % :x)) data))), 
          d (* (reduce + (map #(get % :x) data)) (reduce + (map #(get % :x) data)))
          ]
    (/(- a b)(- c d))))
    
(defn calc-w-zero [data]
    (let [w-one (calc-w-one data), 
          w-zero (/ (- (reduce + (map #(get % :y) data))(* w-one (reduce + (map #(get % :x) data)))) (count data))]
        (hash-map :a w-one, :b w-zero)))
