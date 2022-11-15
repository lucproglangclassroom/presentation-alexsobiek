(ns clojure-playground.concurrency
  (:gen-class))

(def numPromise (promise))                                  ;; Define promise for delivering random numbers

(def average
  (future
    (def numbers (repeatedly 4 #(rand-int 100)))            ;; Generate seq of 4 random numbers from 0 to 100
    (deliver numPromise numbers)                            ;; Deliver promise of random numbers
    (Thread/sleep 3000)                                     ;; Simulate long process (+ 3 seconds)
    (/ (apply + numbers) (count numbers))))                 ;; Average numbers, complete future


(defn -main []
    (println "Calculating average of" @numPromise)          ;; Print once promise of random numbers has been delivered
    (println "Average:" @average))                          ;; Print once average future has completed