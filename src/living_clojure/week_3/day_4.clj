(ns living-clojure.week-3.day-4)

(defn sieve [n]
  (loop [i 2
         coll (range 2 (inc n))
         primes []
         limit 0]
    (if (> limit n)
      primes
      (recur (first (drop 1 coll))
             (filter #(not= 0 (rem % i)) coll)
             (conj primes i)
             (inc limit)))))

(defn prime? [n]
  (let [range-n (range 2 n)
        divisors (filter some? (map #(when (= 0 (rem n %)) %) range-n))]
    (zero? (count divisors))))
(defn prime-gen [n]
  (take n (filter prime? (iterate inc 2))))


(= (prime-gen 2) [2 3])

(= (prime-gen 5) [2 3 5 7 11])

(= (last (prime-gen 100)) 541)