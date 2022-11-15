(ns clojure-playground.core
  (:gen-class))

(defn hello-world []
  (println "Hello, world!"))

(defn hello [name]                                          ;; Take in single parameter `name`
  (println (str "Hello, " name)))                           ;; Concatenate two strings using str

(defn java-len [string]
  (.length string))                                         ;; Use Java interop for string length

(defn name-length [name]
  (println (str "Your name is " (java-len name) " letters long")))

(defn sum [& numbers]                                       ;; Take in an array of numbers as a parameter
  (apply + numbers))                                        ;; Apply addition to all numbers

(defn avg [& numbers]
  (/ (apply + numbers) (count numbers)))                    ;; Add all numbers, divide by count

(defn -main []
  (def user-name (read-line))                               ;; Read single line from stdin, assign it to `user-name`
  (hello-world)                                             ;; Greet the world
  (hello user-name)                                         ;; Greet the user
  (name-length user-name)                                   ;; Print length of user's name
  (println (str "1 + 2 + 3 = " (sum 1 2 3)))                ;; Print sum of 1 + 2 + 3
  (println (str "Avg of 1, 2, 3 = " (avg 1 2 3))))          ;; Print average of 1, 2, 3