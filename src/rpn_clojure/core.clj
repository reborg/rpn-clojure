(ns rpn-clojure.core)

;;(defn push [current] [(\1) [\9]])
;;(defn pop  [stack])
;;(defn add  [stack])
;;(defn sub  [stack])
;;(defn mul  [stack])
;;(defn div  [stack])
;;(def operations1 {\0 push \1 pop \2 add \3 sub \4 mul \5 div})

(def operations #{\0 \1 \2 \3 \4 \5})

(defn clifford [program]
  (if (operations (first program))
    (if (and (= \0 (first program)) (= 1 (count program))) 
      "missing argument for push"
      (if (= \0 (first program)) 
        (push [(rest program) []])))
    (str "clifford does not understand operation " (first program))))

