(ns living-clojure.week-3.day-2-test
  (:require [clojure.test :refer :all])
  (:require [living-clojure.week-3.day-2 :refer :all]))

(deftest displace-1-right
  (is (= [2 3 4 5 1] (rotate-right 1 [1 2 3 4 5]))))

(deftest displace-3-right
  (is (= [4 5 1 2 3] (rotate-right 3 [1 2 3 4 5]))))

(deftest displace-1-left
  (is (= [5 1 2 3 4] (rotate-left 1 [1 2 3 4 5]))))

(deftest displace-3-left
  (is (= [3 4 5 1 2] (rotate-left 3 [1 2 3 4 5]))))

(deftest rotate-6-right
  (is (= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1))))

(deftest rotate-4-left
  (is (= (rotate -4 '(:a :b :c)) '(:c :a :b))))