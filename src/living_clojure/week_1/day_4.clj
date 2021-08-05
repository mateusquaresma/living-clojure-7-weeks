(ns living-clojure.week-1.day-4)

; Penultimate Element
(= (second (reverse (list 1 2 3 4 5))) 4)

(= (last (drop-last ["a" "b" "c"])) "b")

(= (last (butlast [[1 2] [3 4]])) [1 2])

; Sum it all up
(= (apply + [1 2 3]) 6)

(= (reduce + (list 0 -2 5 5)) 8)

(= (apply + #{4 2 1}) 7)

(= (reduce +  '(0 0 -1)) -1)

(= (apply + '(1 10 3)) 14)

; Find the odd numbers
(= (filter #(= (rem % 2) 1) #{1 2 3 4 5}) '(1 3 5))

(= ((fn [coll]
      (for [e coll
            :when (odd? e)]
        e)) [4 2 1 6]) '(1))

(= (filter odd? [2 2 4 6]) '())

(= (filter odd? [1 1 1 3]) '(1 1 1 3))

; Palindrome detector

(defn palindrome? [word]
  (= word (clojure.string/join (reverse word))))

(false? ((fn [coll] (= coll (reverse coll))) '(1 2 3 4 5)))

(true? (palindrome? "racecar"))

(true? ((fn [coll] (= coll (reverse coll))) [:foo :bar :foo]))

(true? ((fn [coll] (= coll (reverse coll))) '(1 1 3 3 1 1)))

(false? ((fn [coll] (= coll (reverse coll))) '(:a :b :c)))

; Duplicate a sequence
(defn duplicate [coll]
  (loop [res []
         temp-coll coll]
    (let [first (first temp-coll)]
      (if (empty? temp-coll)
        res
        (recur (conj (conj res first) first)
               (drop 1 temp-coll))))))

(= ((fn [coll] (flatten (map #(repeat 2 %) coll))) [1 2 3])
   '(1 1 2 2 3 3))

(= ((fn [coll] (flatten (map #(repeat 2 %) coll))) [:a :a :b :b])
   '(:a :a :a :a :b :b :b :b))

(= (duplicate [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

(= (duplicate [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))