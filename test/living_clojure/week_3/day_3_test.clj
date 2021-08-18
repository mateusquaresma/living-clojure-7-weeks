(ns living-clojure.week-3.day-3-test
  (:require [clojure.test :refer :all])
  (:require [living-clojure.week-3.day-3 :refer :all]))


(deftest reverse-into-2-colls
  (is (= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))))

(deftest reverse-into-3-colls
  (is (= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))))

(deftest reverse-into-5-colls
  (is (= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))
