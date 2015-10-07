(ns data-structures-talk.data-test2
  (:require [clojure.test :refer :all])
  (:import (clojure.lang PersistentQueue)))

(def ? nil)

(deftest update-test
  (is (= ? (update {:a 1} :a inc)))
  (is (= ? (update {:a 1} :a + 3)))

  (is (= ? (update [28 29 30 31] 1 str)))

  (is (= ? (update-in {:a {:b 23}} [:a :b] / 5)))
  (is (= ? (update-in [{:a 1} {:b 3}] [1 :b] range))))

(deftest contains-test
  (is (= ? (contains? [:a :b :c :d] 2)))
  (is (= ? (contains? [:a :b :c :d] :b)))
  (is (= ? (contains? {[:x :y] 23} [:x :y])))
  (is (= ? (contains? {:b 5} :b)))

  ;; implementation detail, don't use this in normal code
  ;; see https://github.com/clojure/clojure/blob/clojure-1.7.0/src/jvm/clojure/lang/APersistentVector.java#L403
  (is (= ? (.contains [:a :b :c :d] :b)))
  (is (= ?) (.containsAll [:a :b :c :d] #{:a :c :d})))

(deftest sets-and-maps-as-predicates
  (is (= ? (some pos? [-5 -3 1 0])))
  (is (= ? (some #{:fred :jane} [:bob :jack :jill :jane])))
  ;; think about why this works

  (is (= ? (every? pos? [1 3 5 9])))
  (is (= ? (every? #{:bob :lucy :jack} [:lucy :bob :jack :lucy :jack])))

  (is (= ? (some {:a :x} [:a :b :c :d]))))

(deftest count-test
  (is (= ? (count [1 2 3 4])))
  (is (= ? (count (range 100))))
  (is (= ? (count {:a 1 :b 2}))))

(deftest first-test
  (is (= ? (first [:a :b :c])))
  (is (= ? (first {:a 1 :b 2}))))

(deftest peek-pop-test
  (is (= ? (peek [1 2 3 4])))
  (is (= ? (peek '(1 2 3 4))))

  (is (= ? (pop [1 2 3 4])))
  (is (= ? (pop '(1 2 3 4))))

  ;; why can we call first on a map, but not peek? What happens if you try this:
  ;; (peek {:a 1})

  ;; you might need to do some Google searching to understand this one
  (is (= ? (-> (PersistentQueue/EMPTY)
               (conj :a)
               (conj :b)
               (pop)
               (peek))))
  )

(deftest empty-test
  (is (= ? (empty [:a :b])))
  (is (= ? (empty {:x :y})))

  (is (= ? (empty? [:a :b])))
  (is (= ? (empty? []))))

(deftest reverse-test
  (is (= ? (reverse [:a :b :c])))
  (is (= ? (reverse {:a 1 :b 2 :c 3})))
  (is (= ? (reverse #{:a :b :c :d})))
  (is (= ? (reverse (list 1 2 3 4))))
  (is (= ? (reverse (reverse [:a :b :c]))))

  ;; what's the difference between reverse and rseq?
  (is (= ? (rseq [:a :b :c :d])))
  ;; why can't we call rseq on a normal map?
  (is (= ? (rseq (sorted-map :a 1 :b 2 :c 3))))
  )

;; dissoc
;; disj

;; building data structures with functions
