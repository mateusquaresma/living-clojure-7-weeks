(ns living-clojure.week-2.day-4)

; Symmetric Difference
(defn symmetric-difference [set-a set-b]
  (let [a (clojure.set/difference set-a set-b)
        b (clojure.set/difference set-b set-a)]
    (set (concat a b))))

(= (symmetric-difference #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(= (symmetric-difference #{:a :b :c} #{}) #{:a :b :c})

(= (symmetric-difference #{} #{4 5 6}) #{4 5 6})

(= (symmetric-difference #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})

; Least Common Multiple

(declare gcd)
(defn gcd [a b]
  (cond
    (= a 0) b
    (= b 0) a
    :else (gcd b (rem a b))))

(defn lcm [& args]
  (/ (reduce * args) (reduce gcd args)))

(== (lcm 2 3) 6)

(== (lcm 5 3 7) 105)

(== (lcm 1/3 2/5) 2)

(== (lcm 3/4 1/6) 3/2)

(== (lcm 7 5/7 2 3/5) 210)