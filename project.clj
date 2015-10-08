(defproject data-structures-talk "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [criterium "0.4.3"]
                 ]
  :plugins [[lein-gorilla "0.3.4"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.11.0"]]}}
  :test-refresh {:quiet true})
