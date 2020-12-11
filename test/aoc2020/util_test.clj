(ns aoc2020.util-test
  (:require [aoc2020.util :refer :all]
            [clojure.test :refer :all]))

(deftest util-test
  (testing "all-pairs"
    (is (= [[1 2] [1 3] [2 3]] (all-pairs [1 2 3])))
    (is (= [[:a :b]] (all-pairs [:a :b])))
    (is (= [] (all-pairs [:single-value]))))
  (testing "all-permutations"
    (is (= [[1 2] [1 3] [2 3]] (all-permutations 2 [1 2 3])))
    (is (= [[1 2 3]] (all-permutations 3 [1 2 3])))
    (is (= [[1 2 3] [1 2 4] [1 3 4] [2 3 4]] (all-permutations 3 [1 2 3 4])))
    (is (= [[1 2 3 4]] (all-permutations 4 [1 2 3 4])))
    (is (= [] (all-permutations 4 [1 2 3])))))
