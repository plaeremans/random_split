(ns random-split.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn draw-random "draws r random numbers from the first n integers " [n r]
  (repeatedly r #(Math/round (rand n) ) ))


(defn write-to-file [f coll]
  (spit f (clojure.string/join "\n" coll)))

(defn split-file [file-in file-out1 file-out2 split-factor]
  (with-open [in-file (io/reader file-in)]
    (let [in-rows (line-seq in-file)
          header-row  (take 1 in-rows)
          content-rows (drop 1 in-rows)
          n  (count content-rows)
          r  (Math/round (* split-factor n))
          shuffled-lines (shuffle content-rows)
          lines-for-one (take r shuffled-lines)
          lines-for-two (take (- n r) shuffled-lines)]
      (do
        (write-to-file file-out1 (conj lines-for-one header-row))
        (write-to-file file-out2 (conj lines-for-two header-row))))))



(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
