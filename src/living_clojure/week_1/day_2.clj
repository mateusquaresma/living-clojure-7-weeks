(ns living-clojure.week-1.day-2)

(= [20 30 40] (rest [10 20 30 40]))

(= 8 ((fn add-five [x] (+ x 5)) 3))

(= 8 ((fn [x] (+ x 5)) 3))

(= 8 (#(+ % 5) 3))

(= 8 ((partial + 5) 3))

(= ((fn double [x] (* x 2)) 2) 4)

(= ((fn [x] (* x 2)) 3) 6)

(= (#(* % 2) 11) 22)

(= ((partial * 2) 7) 14)

(= ((fn greetings [x] (str "Hello, " x "!")) "Rhea") "Hello, Rhea!")

(= ((fn [x] (str "Hello, " x "!")) "Dave") "Hello, Dave!")

(= (#(str "Hello, " % "!") "Jenn") "Hello, Jenn!")

; Map function
(= `(6 7 8) (map #(+ % 5) '(1 2 3)))

; Filter function
(= `(6 7) (filter #(> % 5) '(3 4 5 6 7)))

; Local bindings
(= 7 (let [x 5] (+ 2 x)))

(= 7 (let [x 3, y 10] (- y x)))

(= 7 (let [x 21] (let [y 3] (/ x y))))

; Let it be
(= 10 (let [x 9 y 1] (+ x y)))

(= 4 (let [y 5 z -1] (+ y z)))

(= 1 (let [z (- 2 1)] z))