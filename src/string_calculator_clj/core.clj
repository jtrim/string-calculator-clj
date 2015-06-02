(ns string-calculator-clj.core
  (:require [clojure.string :as str])
  (:gen-class))

(def default-delims ["," "\\n"])
(def custom-delim-regex #"(?s)\/\/(.)\n.*")

(defn extract-custom-delims
  "Extracts delimiters from a number string specifier.
   (extract-custom-delims \"//;\\n1,2,3\") ;=> [\";\"]
   (extract-custom-delims \"1,2,3\") ;=> []"
  [num-str]
  (->>
    (re-seq custom-delim-regex num-str)
    (map last)
    (into [])))

(defn extract-num-str [num-str]
  (if (re-matches custom-delim-regex num-str)
    (->>
      (str/split num-str #"\n")
      rest
      (str/join "\n"))
    num-str))

(defn add-with-delims [num-str delims]
  (let
    [delimiter-regex (re-pattern (str "[" (str/join delims) "]"))]
    (->>
      (str/split num-str delimiter-regex)
      (map #(Integer. %))
      (reduce +))))

(defmulti add identity)

(defmethod add ""  [_] 0)
(defmethod add nil [_] 0)
(defmethod add :default [num-str-specifier]
  (let [delims (into default-delims (extract-custom-delims num-str-specifier))
        num-str (extract-num-str num-str-specifier)]
    (add-with-delims num-str delims)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (add (first args))))
