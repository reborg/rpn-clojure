(ns rpn-clojure.core)

(defstruct current-input-and-stack :input :stack :result)
(defmacro state [current-input current-stack & result] (struct current-input-and-stack current-input current-stack result))

(defn cpush [ops]
  (if (empty? (:input ops))
    (throw (Exception. "missing argument for push"))
    (state
      (rest (:input ops)) 
      (cons (first (:input ops))
            (:stack ops)))))

(defn cpop [ops]
  (let [last-item (last (:stack ops))
        new-stack (first (split-at (- (count (:stack ops)) 1) (:stack ops)))]
    {:input (:input ops) :stack new-stack :result last-item}))

;;(defn add  [stack])
;;(defn sub  [stack])
;;(defn mul  [stack])
;;(defn div  [stack])

(def operations {\0 cpush \1 pops \2 pops \3 pops \4 pops \5 pops})

(defn exec [ops]
    ((operations (first (:input ops))) 
      {:input (rest (:input ops)) :stack (:stack ops) :result (:result ops)}))

(defn clifford [program]
  (if (contains? operations (first program))
    (first (:stack (exec (state program []))))
    (str "clifford does not understand operation " (first program))))
