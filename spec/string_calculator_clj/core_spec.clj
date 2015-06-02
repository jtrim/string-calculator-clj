(ns string-calculator-clj.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj.core :refer :all]))

(describe "string-calculator/add"
  (it "returns zero when given an empty string"
    (should (= 0 (add ""))))

  (it "returns zero when given nil"
    (should (= 0 (add nil))))

  (it "returns the number when given a single number"
    (should (= 1 (add "1"))))

  (it "sums two numbers"
    (should (= 3 (add "1,2"))))

  (it "sums three numbers"
    (should (= 6 (add "1,2,3"))))

  (it "sums many numbers"
    (should (= 15 (add "1,2,3,4,5"))))

  (it "supports newlines as delimiters"
    (should (= 6 (add "1,2\n3"))))

  (it "supports a custom delimiter"
    (should (= 15 (add "//;\n1,2;3\n4,5"))))

  )


(run-specs)
