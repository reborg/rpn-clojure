(ns rpn-clojure.core)

(defn clifford [program]
  (if (#{\0 \1 \2 \3 \4 \5} (first program))
    (if (and (= \0 (first program)) (= 1 (count program))) "missing argument for push")
    "clifford does not understand operation 6"))
