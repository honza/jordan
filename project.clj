(defproject jordan "0.2.1"
  :description ""
  :url "https://github.com/honza/jordan"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot jordan.core
  :target-path "target/%s"
  :license {:name "BSD" :url "http://opensource.org/licenses/BSD-2-Clause"}
  :profiles {:uberjar {:aot :all}})
