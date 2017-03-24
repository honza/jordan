(defproject jordan "0.3.0"
  :description ""
  :url "https://github.com/honza/jordan"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot jordan.core
  :target-path "target/%s"
  :license {:name "BSD" :url "http://opensource.org/licenses/BSD-2-Clause"}
  :profiles {:uberjar {:aot :all}})
