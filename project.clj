(defproject jordan "0.1.1"
  :description ""
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot jordan.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
