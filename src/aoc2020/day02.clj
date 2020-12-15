(ns aoc2020.day02
  (:require [aoc2020.util :refer [str->int read-lines]]))

(defn parse-line [s]
  (let [[l u c p] (rest (re-find (re-matcher #"(\d+)-(\d+) (.*): (.*)" s)))]
    {:v1 (str->int l)
     :v2 (str->int u)
     :char (first c)
     :password p}))

(defn parse-input [s]
  (read-lines s parse-line))

(defn valid-sled? [{:keys [v1 v2 char password]}]
  (contains? (set (range v1 (inc v2))) (get (frequencies password) char)))

(defn valid-toboggan? [{:keys [v1 v2 char password]}]
  (= 1  (->> (vals (select-keys (vec password) [(dec v1) (dec v2)]))
             (filter (partial = char))
             count)))

(defn count-valid-passwords
  ([s] (count-valid-passwords s valid-sled?))
  ([s valid-fn] (count (filter valid-fn (parse-input s)))))
