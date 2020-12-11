(ns aoc2020.day01-test
  (:require [aoc2020.day01 :refer :all]
            [aoc2020.util :refer :all]
            [clojure.test :refer :all]))

(def sample-input [1721 979 366 299 675 1456])
(def day01-input (-> (slurp "resources/day01_input.txt")
                     (read-lines str->int)))

(deftest day01-test
  (testing "Day 1: Part 1 -- Report Repair"
    (is (= 514579 (report-repair 2 sample-input)))
    (is (= 805731 (report-repair 2 day01-input))))
  (testing "Day 1: Part 2 -- Triples"
    (is (= 241861950 (report-repair 3 sample-input)))
    (is (= 192684960 (report-repair 3 day01-input)))))
