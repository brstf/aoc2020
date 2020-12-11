(ns aoc2020.day01
  (:require [aoc2020.util :refer [all-permutations]]))

(defn report-repair [n coll]
  (->> (all-permutations n coll)
       (filter #(= 2020 (apply + %)))
       first
       (apply *)))
