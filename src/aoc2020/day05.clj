(ns aoc2020.day05)

(def binary-fn {\F take
                \B drop
                \L take
                \R drop})

(defn binary-search [max s]
  (first (reduce #((binary-fn %2) (/ (count %1) 2) %1) (range max) s)))

(defn seat-id [{:keys [row col]}]
  (+ (* row 8) col))

(defn add-seat-id [m]
  (assoc m :id (seat-id m)))

(defn bsp->seat [s]
  (add-seat-id {:row (binary-search 128 (take 7 s))
                :col (binary-search 8 (drop 7 s))}))

(defn missing-number [nums]
  (let [[mn mx] ((juxt #(apply min %) #(apply max %)) (sort nums))]
    (- (apply + (range mn (inc mx))) (apply + nums))))
