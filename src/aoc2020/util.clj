(ns aoc2020.util)

(defn str->int [s]
  (Integer/parseInt s))

(defn read-lines
  "Parses a given string into lines, optionally transforming each line by the given function"
  ([s] (read-lines s identity))
  ([s tfn] (map tfn (clojure.string/split s #"\n"))))

(defn all-permutations
  "Split collection into every permutation of n items"
  [n coll]
  (if (= 1 n)
    (map vector coll)
    (loop [[x & xs] coll
           result []]
      (if (nil? xs)
        result
        (recur xs (apply conj result (map (partial into [x]) (all-permutations (dec n) xs))))))))

(def all-pairs (partial all-permutations 2))
