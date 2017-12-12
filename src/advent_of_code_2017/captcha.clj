(ns advent-of-code-2017.captcha)

(defn sum-matching-neighours
  ([xs]
   (let [starting-sum (if (= (first xs) (last xs))
                        (Character/digit (first xs) 10)
                        0)]
     (sum-matching-neighours xs starting-sum)))
  ([xs sum]
   (if (<= (count xs) 1)
     sum
     (let [x (Character/digit (first xs) 10)
           y (Character/digit (first (rest xs)) 10)]
       (recur (rest xs) (if (= x y) (+ sum x) sum))))))
