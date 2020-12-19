(ns aoc2020.day04
  (:require [clojure.spec.alpha :as s]
            [aoc2020.util :refer [str->int]]))

(def valid-fields [::byr ::iyr ::eyr ::hgt ::hcl ::ecl ::pid ::cid])

(def hcl-regex #"#[0-9a-f]{6}")
(def pid-regex #"[0-9]{9}")
(def hgt-regex #"(\d+)(in|cm)")

(defn valid-cm? [n]
  (<= 150 n 193))

(defn valid-in? [n]
  (<= 59 n 76))

(defn valid-height? [s]
  (let [[_ n u] (re-matches hgt-regex s)]
    (case u
      "in" (valid-in? (str->int n))
      "cm" (valid-cm? (str->int n)))))

(s/def ::year (s/and string? #(re-matches #"\d+" %) #(<= 1000 (str->int %) 9999)))
(s/def ::byr (s/and ::year #(<= 1920 (str->int %) 2002)))
(s/def ::iyr (s/and ::year #(<= 2010 (str->int %) 2020)))
(s/def ::eyr (s/and ::year #(<= 2020 (str->int %) 2030)))
(s/def ::hgt (s/and string? #(re-matches hgt-regex %) valid-height?))
(s/def ::ecl #{"amb" "blu" "brn" "gry" "grn" "hzl" "oth"})
(s/def ::hcl (s/and string? #(re-matches hcl-regex %)))
(s/def ::pid (s/and string? #(re-matches pid-regex %)))
(s/def ::fields (set valid-fields))
(s/def ::passport (s/keys :req [::byr ::iyr ::eyr ::hgt ::hcl ::ecl ::pid]
                          :opt [::cid]))

(defn- namespaced-kw [s]
  (keyword "aoc2020.day04" s))

(defn str->field [s]
  (update (clojure.string/split s #":") 0 namespaced-kw))

(defn str->passport [s]
  (->> (clojure.string/split s #"\s")
    (map str->field)
    (into {})))

(defn parse-input [s]
  (map str->passport (clojure.string/split s #"\n\n")))

(defn passport-valid? [p]
  (s/valid? ::passport p))

(defn basic-passport-valid? [p]
  (every? (partial get p) (disj (set valid-fields) ::cid)))


