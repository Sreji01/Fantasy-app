(ns fantasy-app.core-test
  (:require [clojure.test :refer :all]
            [fantasy-app.core :refer :all]
            [midje.sweet :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(fact "Check if there is a return value"
      (rank-players @players) =not=> nil)

