(ns living-clojure.week-2.day-3)

; Simple Closures
(defn power [n]
  (fn [x] (long (Math/pow x n))))

(= 256 ((power 2) 16) ((power 8) 2))

(= [1 8 27 64] (map (power 3) [1 2 3 4]))

(= [1 2 4 8 16] (map #((power %) 2) [0 1 2 3 4]))

; Cartesian Product
(defn cartesian-product [first second]
  (set (for [a first b second] [a b])))

(= (cartesian-product #{"ace" "king" "queen"} #{"spade" "heart" "diamond" "club"})
   #{["ace" "spade"] ["ace" "heart"] ["ace" "diamond"] ["ace" "club"]
     ["king" "spade"] ["king" "heart"] ["king" "diamond"] ["king" "club"]
     ["queen" "spade"] ["queen" "heart"] ["queen" "diamond"] ["queen" "club"]})

(= (cartesian-product #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (cartesian-product
                (into #{} (range 10))
                (into #{} (range 30)))))