(ns aoc2020.day05-test
  (:require [aoc2020.day05 :refer :all]
            [aoc2020.util :refer :all]
            [clojure.test :refer :all]))

(def day05-input (map bsp->seat (read-lines (slurp "resources/day05_input.txt"))))

(deftest day05-test
  (testing "Part 1: Binary Boarding"
    (is (= 357 (:id (bsp->seat "FBFBBFFRLR"))))
    (is (= 567 (:id (bsp->seat "BFFFBBFRRR"))))
    (is (= 119 (:id (bsp->seat "FFFBBBFRRR"))))
    (is (= 820 (:id (bsp->seat "BBFFBBFRLL"))))
    (is (= 835 (apply max (map :id day05-input)))))
  (testing "Part 2: Find Your Seat!"
    (is (= 649 (missing-number (map :id day05-input))))))
