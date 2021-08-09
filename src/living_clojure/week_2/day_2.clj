(ns living-clojure.week-2.day-2)

; Advanced destructuring

(let [[a b & c] ["cat" "dog" "bird" "fish"]]
  [a b])

(let [[a b :as x] ["cat" "dog" "bird" "fish"]]
  x)

(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))

; A half-truth
(defn half-truth [& params]
  (if (every? true? params)
    false
    (if-not (some true? params)
      false
      true)))

(= false (half-truth false false))

(= true (half-truth true false))

(= false (half-truth true))

(= true (half-truth false true false))

(= false (half-truth true true true))

(= true (half-truth true true true false))

; Greatest Common Divisor
(declare gcd)
(defn gcd [a b]
  (cond
    (= a 0) b
    (= b 0) a
    :else (gcd b (rem a b))))
(= (gcd 2 4) 2)

(= (gcd 10 5) 5)

(= (gcd 5 7) 1)

(= (gcd 1023 858) 33)