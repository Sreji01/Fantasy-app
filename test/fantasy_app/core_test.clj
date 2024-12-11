(ns fantasy-app.core-test
  (:require [clojure.test :refer :all]
            [fantasy-app.core :refer :all]
            [midje.sweet :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(fact "Check if there is a return value"
      (rank-players @players) =not=> nil)

(fact "Check if there is a return value"
      (suggest-best-captain @players) =not=> nil)

(fact "Check if the returned player is the one with max predicted points"
      (suggest-best-captain @players) => {:id 328, :first-name "Mohamed", 
                                          :second-name "Salah", :team 12, :now-cost 13.3, :total-points 151, 
                                          :form "14.7", :expected-points 15.7})

(fact "Check if there is a return value"
      (suggest-best-transfer @players (nth @players 2)) =not=> nil)

