(ns living-clojure.week-3.day-3)

(defn reverse-interleave [coll n]
  (for [i (range n)]
    (take-nth n (drop i coll))))

(= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

(= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

(= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

; Splitting by type

(defn split-by-type [coll]
  (for [c (set (map class coll))]
    (filter #(= (class %) c) coll)))

(= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set (split-by-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
