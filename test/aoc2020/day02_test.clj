(ns aoc2020.day02-test
  (:require [aoc2020.day02 :refer :all]
            [aoc2020.util :refer :all]
            [clojure.test :refer :all]))

(def sample-input "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc")
(def day02-input (slurp "resources/day02_input.txt"))

(deftest day02-test
  (testing "Part 1: Validity Count"
    (is (= 2 (count-valid-passwords sample-input)))
    (is (= 666 (count-valid-passwords day02-input))))
  (testing "Part 2: Toboggan Validity Count"
    (is (= 1 (count-valid-passwords sample-input valid-toboggan?)))
    (is (= 670 (count-valid-passwords day02-input valid-toboggan?)))))
