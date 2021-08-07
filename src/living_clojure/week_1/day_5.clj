(ns living-clojure.week-1.day-5)

; Compress a sequence
(defn remove-duplicate [args]
  (let [data (seq args)]
    (loop [data data
           res []]
      (if (empty? data)
        res
        (recur (drop 1 data)
               (let [data-head (first data)
                     tail-res (last res)]
                 (if (= tail-res data-head)
                   res
                   (conj res data-head))))))))

; simples solution found on the internet
; (apply str (map first (partition-by identity "Leeeeeerrroyyy")))

(= (apply str (remove-duplicate "Leeeeeerrroyyy")) "Leroy")

(= (remove-duplicate [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))

(= (remove-duplicate [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

; Pack a sequence
(= (partition-by identity [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))

(= (partition-by identity [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))

(= (partition-by identity [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

; Drop every nth item
(defn drop-every-nth [coll nth]
  (let [indexes (range 1 (inc (count coll)))
        mapped-values (map list indexes coll)
        filtered-values (filter #(not= 0 (rem (first %) nth)) mapped-values)]
    (vec (map #(second %) filtered-values))))

(= (drop-every-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])

(= (drop-every-nth [:a :b :c :d :e :f] 2) [:a :c :e])

(= (drop-every-nth [1 2 3 4 5 6] 4) [1 2 3 5 6])

; Intro to iterate
(= `(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))

; Replicate a sequence
(defn replicate-n [args n]
  (reduce concat (map #(take n (repeat %)) args)))

(= (replicate-n [1 2 3] 2) '(1 1 2 2 3 3))

(= (replicate-n [:a :b] 4) '(:a :a :a :a :b :b :b :b))

(= (replicate-n [4 5 6] 1) '(4 5 6))

(= (replicate-n [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))

(= (replicate-n [44 33] 2) [44 44 33 33])