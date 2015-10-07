(ns data-structures-talk.data-test1
  (:require [clojure.test :refer :all]))

;; Task: replace the ? with the correct answer to make all of the tests pass.

(def ? nil)

(deftest get-test
  (testing "different ways to get maps"
    (is (= ? (get {:a 1} :a)))
    (is (= ? ({:a 1} :a)))
    (is (= ? (:a {:a 1})))
    (is (= ? (:b {:a 1})))
    (is (= ? (get {:a 1} :b :d))))

  (testing "different ways to get from vectors"
    (is (= ? (get [:a :b :c :d] 2)))
    (is (= ? (get [] 2)))
    (is (= ? ([:a :b :c :d] 3)))
    (is (= ? ([:a] 2)))                                     ;; hint: clojure.test/thrown? might be helpful here
    (is (= ? (nth [:a :b :c :d] 3)))
    (is (= ? (nth [:a :b :c :d] 23 :no))))

  (testing "different ways to get from sets"
    (is (= ? (get #{:a :b :c} :a)))
    (is (= ? (get #{:a :b :c} :x)))
    (is (= ? (#{:a :b :c} :a)))
    (is (= ? (:a #{:a :b :c})))))

(deftest get-in-test
  (is (= ? (get-in {:a {:b {:c "x"}}} [:a :b :c])))
  (is (= ? (get-in [0 1 {:x 3}] [2 :x]))))

(deftest conj-test
  (is (= {:a 1 :b 2} (conj {:a 1} ?)))
  (is (= {:a 1 :b 2 :c 3} (conj {:a 1} ? ?)))

  (is (= [] (conj [:x :y :z] :a)))
  (is (= [] (conj [:x :y :z] :a :b :c)))

  (is (= #{} (conj #{:a :b :c} :d)))
  (is (= #{} (conj #{:a :b :c} :d :a :b)))

  (is (= '() (conj '(:a :b :c) :d)))
  (is (= '() (conj '(:a :b :c) :d :e :f)))

  (is (= [] (conj nil :a))))

(deftest cons-test
  (is (= ? (cons :x [:a :b :c])))
  (is (= ? (cons :x '(:a :b :c))))
  ;; Task: explain why these two return the same result.
  )

(deftest assoc-test
  (is (= ? (assoc {} :x 1)))
  (is (= ? (assoc {} :x 1 :y 2)))

  (is (= ? (assoc [] 0 :x)))
  (is (= ? (assoc [] 1 :x)))
  (is (= ? (assoc [:a :b :c] 1 :x))))

(deftest assoc-in-test
  (is (= ? (assoc-in {:a {93 {:c 3}} :d 4} [:a 93 :c] 23)))
  (is (= ? (assoc-in {:a [23 24 25]} [:a 2] 86))))
