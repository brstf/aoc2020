(ns aoc2020.day03-test
  (:require [aoc2020.day03 :refer :all]
            [aoc2020.util :refer :all]
            [clojure.test :refer :all]))

(def sample-input (parse-input (slurp "resources/day03_sample.txt")))
(def day03-input (parse-input (slurp "resources/day03_input.txt")))

(def part2-slopes [[1 1] [3 1] [5 1] [7 1] [1 2]])

(deftest day03-test
  (testing "Part 1: Toboggan Trajectory"
    (is (= 7 (count-trees sample-input [3 1])))
    (is (= 153 (count-trees day03-input [3 1]))))
  (testing "Part 2: Slope Bonanza"
    (is (= 336 (apply * (map (partial count-trees sample-input) part2-slopes))))
    (is (= 2421944712 (apply * (map (partial count-trees day03-input) part2-slopes))))))
