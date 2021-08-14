(ns living-clojure.week-3.day-2
  (:require [clojure.math.numeric-tower :as math]))

; Flipping out

(defn inverter [function]
  (fn [arg1 arg2]
    (function arg2 arg1)))

(= 3 ((inverter nth) 2 [1 2 3 4 5]))

(= true ((inverter >) 7 8))

(= 4 ((inverter quot) 2 8))

(= [1 2 3] ((inverter take) [1 2 3 4 5] 3))

; Rotate a sequence

(defn rotate-right [displacement coll]
  (loop [d displacement
         c-coll coll]
    (if (zero? d)
      (apply list c-coll)
      (let [[head & tail] c-coll]
        (recur (dec d) (conj (vec tail) head))))))

(defn rotate-left [displacement coll]
  (loop [d (math/abs displacement)
         c-coll coll]
    (if (zero? d)
      (apply list c-coll)
      (let [body (butlast c-coll)
            last-element (last c-coll)]
        (recur (dec d) (conj body last-element))))))

(defn rotate [displacement coll]
  (cond
    (zero? displacement) coll
    (neg? displacement) (rotate-left displacement coll)
    (pos? displacement) (rotate-right displacement coll)))

(= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2))

(= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3))

(= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1))

(= (rotate 1 '(:a :b :c)) '(:b :c :a))

(= (rotate -4 '(:a :b :c)) '(:c :a :b))



