(ns living-clojure.week-2.day-1)



; Fibonacci
(declare fib)
(defn fib [n]
  (cond
    (= n 1) 1
    (= n 2) 1
    :else (+ (fib (- n 2)) (fib (dec n)))))

(defn fib-seq [n]
  (map fib (range 1 (inc n))))

; Another approach
; (take 8 (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))

(= (fib-seq 3) '(1 1 2))

(= (fib-seq 6) '(1 1 2 3 5 8))

(= (fib-seq 8) '(1 1 2 3 5 8 13 21))

; Get the Caps

(= (apply str (re-seq #"[A-Z]+" "HeLlO, WoRlD!")) "HLOWRD")

(empty? (apply str (re-seq #"[A-Z]+" "nothing")))

(= (apply str (re-seq #"[A-Z]+" "$#A(*&987Zf")) "AZ")

; Intro to some

(= 6 (some #{2 7 6} [5 6 7 8]))

(= 6 (some #(when (even? %) %) [5 6 7 8]))

; Factorial Fun
(= ((fn [n] (apply * (range 1 (inc n)))) 1) 1)

(= ((fn [n] (apply * (range 1 (inc n)))) 3) 6)

(= ((fn [n] (apply * (range 1 (inc n)))) 5) 120)

(= ((fn [n] (apply * (range 1 (inc n)))) 8) 40320)

; Intro to destructuring

(= [2 4] (let [[a b c d e f g] (range)] [c e]))
