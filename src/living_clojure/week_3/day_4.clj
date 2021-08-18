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

(= (sieve 2) [2 3])

(= (sieve 5) [2 3 5 7 11])

(= (last (sieve 100)) 541)