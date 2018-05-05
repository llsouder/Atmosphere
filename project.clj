(defproject atmosphere "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot atmosphere.core
  :target-path "target/%s"
  :plugins [[quickie "0.4.1"]
            [lein-cloverage "1.0.11"]]
  :profiles {:uberjar {:aot :all}})
