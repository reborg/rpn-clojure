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
             (clifford "091") => \9
             (provided (push {:input '(\9 \1), :stack [], :result nil}) => (state '(\1) [\9]))))

(facts "push"
       (fact "there is a new item on the stack"
             (push (state [\1] [])) => (state [] [\1]))
       (fact "new items are pushed bofore the others"
             (push (state [\2] [\1])) => (state [] [\2 \1])))

(facts "exec"
       (fact "invokes the operation and removes it from the input"
             (exec {:input '(\0 \1) :stack [] :result nil}) => (state '() [\1])))
