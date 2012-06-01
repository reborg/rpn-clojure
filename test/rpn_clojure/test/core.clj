(ns rpn-clojure.test.core
  (:use [rpn-clojure.core])
  (:use [midje.sweet]))

(facts "validating operations"
       (fact "it only executes known operations"
             (clifford "678") => "clifford does not understand operation 6"
             (clifford "Ze8") => "clifford does not understand operation Z")
       (fact "the number to push is required"
             (clifford "0") => "missing argument for push"))

(facts "stack operations" 
       (fact "the first item in is the first item out"
             (clifford "091") => 9
             (provided (push ['(\9 \1) []]) => ['(\1) [\9]])))
