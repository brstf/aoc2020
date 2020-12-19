(ns aoc2020.day04-test
  (:require [aoc2020.day04 :refer :all]
            [aoc2020.util :refer :all]
            [clojure.test :refer :all]))

(def sample-input (parse-input (slurp "resources/day04_sample.txt")))
(def day04-input (parse-input (slurp "resources/day04_input.txt")))
(def sample-input2 (parse-input (slurp "resources/day04_sample2.txt")))

(deftest day04-test
  (testing "Part 1: Passport Verification"
    (is (= 2 (count (filter basic-passport-valid? sample-input))))
    (is (= 226 (count (filter basic-passport-valid? day04-input)))))
  (testing "part 2: Passport Validation"
    (is (= 4 (count (filter passport-valid? sample-input2))))
    (is (= 160 (count (filter passport-valid? day04-input))))))
