(ns ai-class.mdp)

(def maze [[0 0 0 100]
           [0 :- 0 -100]
           [0 0 0 0]])

(defn elem [maze lin col] (nth (nth maze lin) col))

(defn value-iteration [possibilities gamma reward]
  (let [mult-sum (fn [el col] (apply + (map #(apply * %) (el col)))),
        poss-cost (fn [opt] (map #(hash-map % (mult-sum % opt)) (keys opt))),
        maximum (nth (sort-by last (poss-cost possibilities)) 0)]
        (zipmap (keys maximum) (list (+ reward (apply * gamma (vals maximum)))))
    ))