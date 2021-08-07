(ns password-validator.password-validator)

(defn ensure-1-digit [pass]
  (> (count (re-seq #"\d+" pass)) 0))

(defn ensure-9-chars [pass]
  (>= (count pass) 9))

(defn ensure-1-uppercase [pass]
  (> (count (re-seq #"[A-Z]+" pass)) 0))

(defn ensure-1-lowercase [pass]
  (> (count (re-seq #"[a-z]+" pass)) 0))

(defn ensure-1-special-char [pass]
  (> (count (re-seq #"[!@#$%^&*()-\+]+" pass)) 0))

(defn ensure-no-repeated-char [pass]
  (= (count pass) (count (set pass))))

(defn ensure-no-whitespace [pass]
  (= (count (re-seq #"\s" pass)) 0))

(defn validate
  ([pass]
   (and (ensure-1-digit pass)
        (ensure-9-chars pass)
        (ensure-1-uppercase pass)
        (ensure-1-lowercase pass)
        (ensure-1-special-char pass)
        (ensure-no-repeated-char pass)
        (ensure-no-whitespace pass)))
  ([pass strategies]
   (let [applied-rules (map #(% pass) strategies)]
     (every? true? applied-rules))))

