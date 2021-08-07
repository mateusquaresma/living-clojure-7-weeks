(ns password-validator.password-validator-test
  (:require [clojure.test :refer :all])
  (:require [password-validator.password-validator :refer :all]))


(deftest at-least-9-chars
  (assert (and
            (false? (validate ""))
            (false? (validate "12345678"))
            (true? (validate "Ab23456789@")))))

(deftest at-least-1-digit
  (assert (and
            (false? (validate "abcdefghij"))
            (true? (validate "Abcdefghij1#")))))

(deftest at-least-1-uppercase
  (assert (and
            (false? (validate "abcdefghij1"))
            (true? (validate "Abcdefghij1$")))))

(deftest at-least-1-lowercase
  (assert (and
            (false? (validate "ABCDEFGHIJ1"))
            (true? (validate "Abcdefghij1%")))))

(deftest at-least-1-special-char
  (assert (and
            (false? (validate "Abcdefghij1"))
            (true? (validate "Abcdefghij1@")))))

(deftest no-repeated-char
  (assert (and
            (false? (validate "Abcdefghij1@A"))
            (true? (validate "Abcdefghij1@")))))

(deftest no-whitespace
  (assert (and
            (false? (validate "Abcdefghij1@ "))
            (true? (validate "Abcdefghij1@")))))

(deftest challenge-example
  (assert (and
            (false? (validate ""))
            (false? (validate "aa"))
            (false? (validate "ab"))
            (false? (validate "AAAbbbCc"))
            (false? (validate "AbTp9!foo"))
            (false? (validate "AbTp9!foA"))
            (false? (validate "AbTp9 fok"))
            (true?  (validate "AbTp9!fok")))))

(deftest multi-strategy
  (assert (and
            (false? (validate "AbTp9 fok" [ensure-no-whitespace]))
            (true? (validate  "AbTp9!fok" [ensure-no-whitespace ensure-no-repeated-char])))))

