(ns data-structures-talk.bench
  (:require [criterium.core]
            [clojure.string :as str]))

;; Benchmark the different operations over the same data in data-test1 and data-test2 using Criterium:

(comment
  (criterium.core/bench (+ 2 2))
  ; or
  (criterium.core/quick-bench (+ 2 2))
  )

;; Benchmark the difference between these:

(-> {:select {:from "abc"}} :select :from)
(get-in {:select {:from "abc"}} [:select :from])

;; Test the cost of constructing maps in different ways

{:k 1 :m 2}
(hash-map :k 1 :m 2)

;; Try joining strings using all of these functions. Which way is fastest?
;; What about for different lengths or numbers of strings?

(comment
  (str "x" " " "y" " " "z")
  (str/join " " ["x" "y" "z"])
  (.concat "abc" "def")
  ;; Write your own using (StringBuilder)
  format                                                    ;; try it using format
  (reduce str ["a" "b" "c"])
  "https://github.com/clojure/core.incubator/blob/master/src/main/clojure/clojure/core/strint.clj#L31")

;; Benchmark the cost of destructuring or using kwargs

;; (round1 350 :round-to 60)
;; (round2 350 {:round-to 60)
;; (round3 350 60)

(defn round1 [num & {:keys [round-to]
                     :or {round-to 60}}]
  '(num round-to))

(defn round2 [num {:keys [round-to]
                   :or {round-to 60}}]
  '(num round-to))

(defn round3 [num round-to]
  '(num round-to))

;; Benchmark the difference between transducing into a map, or making a sequence
;; and then putting it into the map.
;; You'll need to make your own test data

(comment
  (into {} (map f coll))
  (into {} (map f) coll))

;; Benchmark different ways of testing for 0

(comment
  zero?
  (= 0)
  (== 0))

;; Benchmark the cost of destructuring in a let block vs just getting each key individually

(let [{:keys [from to mask]} {:from "friday" :to "saturday" :mask "0000100"}]
  [from to mask])

(let [m {:from "friday" :to "saturday" :mask "0000100"}
      from (:from m)
      to (:to m)
      mask (:mask m)]
  [from to mask])

(let [m {:from "friday" :to "saturday" :mask "0000100"}]
  [(:from m) (:to m) (:mask m)])


;; Benchmark the costs of associng into a map one at a time, or altogether.
;; Test how it varies with different sizes of data

(comment
  (assoc m :k 1)
  (assoc m :v 2)

  (assoc m :k 1 :v 2))
