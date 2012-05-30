(ns rpn-clojure.test.core
  (:use [rpn-clojure.core])
  (:use [midje.sweet]))

(facts "validating operations"
  (fact "it only executes known operations"
        (clifford "678") => "clifford does not understand operation 6")
  (fact "the number to push is required"
        (clifford "0") => "missing argument for push"))
