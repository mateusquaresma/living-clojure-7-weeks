(ns living-clojure.week-2.day-5)

; Pascal's Triangle

(declare binomial)
(defn binomial [n k]
  (cond
    (= k 0) 1
    :else (* (binomial n (dec k)) (/ (- (+ n 1) k) k))))

;; (defn pascal-triangle [n]
;;   (let [k (range 1 (inc n))
;;         fractions (map #(/ (- (+ n 1) %) %) k)]
;;     fractions))

(defn pascal-triangle-row [n]
  (let [columns (range 0 (inc n))]
    (vec (map #(binomial n %) columns))))

(binomial 5 0)

(pascal-triangle-row 5)

(defn pascal-triangle [n]
  (map pascal-triangle-row (range (inc n))))

(pascal-triangle 5)

(= (pascal-triangle-row 0) [1])

(= (map pascal-triangle-row (range 0 5))
   [[1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]])

(= (pascal-triangle-row 10)
   [1 10 45 120 210 252 210 120 45 10 1])