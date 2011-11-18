(ns ai-class.reinforcement-learning)

(defn state-update
  ([state next-state n-visit reward] (state-update state next-state n-visit reward #(/ 1 (+ % 1)) 1))
  ([state next-state n-visit reward alpha gamma]
    (+ state (* (alpha n-visit) (+ reward (- (* gamma next-state) state) )))))

(defn temporal-difference-learning [policy]
  (let [clone-policy (map #(* 1 %) policy)
        its (range 1 (count policy))
        func (fn [given-policy iteration]
         (let [z (take (dec (count given-policy)) given-policy)
               els (map #(list (nth z %) (nth (next given-policy) %) iteration (nth clone-policy %)) (range (count z)))
               res (conj (vec (map #(apply state-update %) els)) (last policy))]
           res)
        )]
      (loop [cnt (apply min its) acc policy] (if (> cnt (apply max its)) acc (recur (inc cnt) (func acc cnt)) ))
    ))