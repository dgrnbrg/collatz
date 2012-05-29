(ns collatz.core)

(defn hail-step [^long n]
  (if (even? n)
    (bit-shift-right n 1)
    (unchecked-inc (unchecked-multiply n 3))))

(def hail-step' (memoize hail-step))

(defn hailseq
  [seed]
  (take-while pos? (iterate hail-step' seed)))

(defn maxhailseq
  "Maximize the hailstone seq over the given range"
  [over]
  (reduce #(max (second %1) (second %2))
          (pmap #(vector % (count (hailseq %)))
               over)))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
