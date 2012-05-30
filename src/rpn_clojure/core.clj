(ns rpn-clojure.core)

(defn clifford [program]
  (if (#{\1 \2 \3 \4 \5} (first program))
    ()
    "clifford does not understand operation 6"))
