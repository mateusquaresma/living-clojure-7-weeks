(ns living-clojure.week-3.day-1)

; Tree or not to Tree
(declare binary-tree?)
(defn binary-tree? [candidate]
  (let [[value & [left right]] candidate]
    (or
      (nil? candidate)
      (and
        (= (count candidate) 3)
        (not (nil? value))
        (or (nil? left) (coll? left))
        (or (nil? right) (coll? right))
        (binary-tree? left)
        (binary-tree? right))
      )
    ))

(binary-tree? '(:a nil nil))

(= (binary-tree? '(:a nil(ns living-clojure.week-3.day-1)

                    ; Tree or not to Tree
                    (declare binary-tree?)
                    (defn binary-tree? [candidate]
                      (let [[value & [left right]] candidate]
                        (or
                          (nil? candidate)
                          (and
                            (= (count candidate) 3)
                            (not (nil? value))
                            (or (nil? left) (coll? left))
                            (or (nil? right) (coll? right))
                            (binary-tree? left)
                            (binary-tree? right))
                          )
                        ))

                    (binary-tree? '(:a nil nil))

                    (= (binary-tree? '(:a nil nil))
                       true)

                    (= (binary-tree? '(:a (:b nil nil) nil))
                       true)

                    (= (binary-tree? '(:a (:b nil nil)))
                       false)

                    (= (binary-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
                       true)

                    (= (binary-tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
                       false)

                    ; Beauty is Symmetry

                    (defn symmetric? [tree]
                      (= ((fn mirror [[value left right :as tree]]
                            (when tree [value (mirror right) (mirror left)])) tree) tree))

                    ; #(= ((fn mirror [[n l r :as tree]] (when tree [n (mirror r) (mirror l)])) %) %)

                    (= (symmetric? '(:a (:b nil nil) (:b nil nil))) true)

                    (= (symmetric? '(:a (:b nil nil) nil)) false)

                    (= (symmetric? '(:a (:b nil nil) (:c nil nil))) false)

                    (= (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                    [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
                       true)

                    (= (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                    [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
                       false)

                    (= (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                    [2 [3 nil [4 [6 nil nil] nil]] nil]])
                       false)

                    (= (binary-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
                       true)

                    (= (binary-tree? [1 [2 [3 [4 false nil] nil] nil] nil])
                       false)

                    (= (binary-tree? '(:a nil ()))
                       false) nil))
   true)

(= (binary-tree? '(:a (:b nil nil) nil))
   true)

(= (binary-tree? '(:a (:b nil nil)))
   false)

(= (binary-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)

(= (binary-tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)

; Beauty is Symmetry

(defn symmetric? [tree]
  (= ((fn mirror [[value left right :as tree]]
        (when tree [value (mirror right) (mirror left)])) tree) tree))

; #(= ((fn mirror [[n l r :as tree]] (when tree [n (mirror r) (mirror l)])) %) %)

(= (symmetric? '(:a (:b nil nil) (:b nil nil))) true)

(= (symmetric? '(:a (:b nil nil) nil)) false)

(= (symmetric? '(:a (:b nil nil) (:c nil nil))) false)

(= (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)

(= (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)

(= (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)

(= (binary-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)

(= (binary-tree? [1 [2 [3 [4 false nil] nil] nil] nil])
   false)

(= (binary-tree? '(:a nil ()))
   false)