(ns aoc2020.day03)

(defn parse-input [s]
  (map vec (clojure.string/split s #"\n")))

(defn inc-when [x b]
  (if b (inc x) x))

(defn is-tree? [hill x y]
  (= \# (nth (cycle (nth hill y)) x)))

(defn count-trees [hill slope]
  (loop [trees 0
         [x y] [0 0]]
    (if (>= y (count hill))
      trees
      (recur (inc-when trees (is-tree? hill x y)) (map + [x y] slope)))))
