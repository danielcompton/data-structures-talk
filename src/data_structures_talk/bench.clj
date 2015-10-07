(ns data-structures-talk.bench)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


;(-> item :select :from)
;(get-in item [:select :from])
;
;;;
;
;{:k 1 :m 2}
;(hash-map :k 1 :m 2)
;
;;;
;
;(str "x" " " "y" " " "z")
;(str/join " " ["x" "y" "z"])
;(find faster options with java interop)
;(.concat "abc" "def")
;(StringBuilder)
;format
;(reduce str ["a" "b" "c"])
;"https://github.com/clojure/core.incubator/blob/master/src/main/clojure/clojure/core/strint.clj#L31"
;
;;;
;
;reduce a vector
;list
;array
;vector-of
;
;;;
;
;(defn round num :round-to 60)
;(defn round num {:round-to 60})
;(defn round num 60)
;
;;;;
;
;(Math/round)
;
;;;
;
;(into {} (map f coll))
;(into {} (map f) coll)
;
;;;
;
;
;zero?
;(= 0)
;
;;;
;
;{:keys [from to mast]}
;(:from) (:to) (:mask)
;
;;;
;
;(assoc :k 1)
;(assoc :v 2)
;
;(assoc :k 1 :v 2)
;
;;;
;
;(set (apply concat (map :legs durations)))
;(into #{} (comp (map :legs) (mapcat identity)) durations)
;
;;;
;
;every?
;reduce version of every?
