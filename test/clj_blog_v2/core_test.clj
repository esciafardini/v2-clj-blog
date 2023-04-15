(ns clj-blog-v2.core-test
  (:require [clojure.test :refer :all]
            [clj-blog-v2.core :refer :all]))

(deftest a-test
  (testing "A non-sense test"
    (is (= 1 1))
    (is (= (my-fn "Hodo") "Hodo"))))
