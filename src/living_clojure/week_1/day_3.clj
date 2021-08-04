(ns living-clojure.week-1.day-3)

; Regular expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

; Recursion
(= `(5 4 3 2 1) ((fn foo [x]
         (when (> x 0)
           (conj (foo (dec x)) x))) 5))

; Recurring Theme
(= [7 6 5 4 3]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))

; Rearranging Code ->
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
   5)

; Rearranging Code ->>
(= (apply + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (apply +))
   11)

; For the win
(= `(1 5 9 13 17 21 25 29 33 37) (for [x (range 40)
            :when (= 1 (rem x 4))]
        x))

(= `(1 5 9 13 17 21 25 29 33 37) (for [x (iterate #(+ 4 %) 0)
            :let [z (inc x)]
            :while (< z 40)]
        z))

(= `(1 5 9 13 17 21 25 29 33 37) (for [[x y] (partition 2 (range 20))]
        (+ x y)))