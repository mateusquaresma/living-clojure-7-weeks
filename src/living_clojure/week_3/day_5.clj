(ns living-clojure.week-3.day-5)

; Anagram finder

(defn anagram? [a b]
  (let [a-chars (set a)
        b-chars (set b)]
    (= a-chars b-chars)))

(defn anagram [a b]
  (when (anagram? a b) b))

(defn anagram-finder [words]
  (let [candidates (for [w words]
                     (let [anagram-w (partial anagram w)]
                       (set (filter some? (map anagram-w words)))))]
    (set (filter #(> (count %) 1) candidates))))

(= (anagram-finder ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= (anagram-finder ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})