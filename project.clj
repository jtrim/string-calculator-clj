(defproject string-calculator-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot string-calculator-clj.core
  :target-path "target/%s"
  :plugins [[speclj "3.2.0"]]
  :test-paths ["spec"]
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[speclj "3.2.0"]]}})
