(ns fantasy-app.core
  (:gen-class)
  (:require [clj-http.client :as client]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def players (atom []))

;;Automaticly generated function
(defn fetch-player-metrics []
  (let [url "https://fantasy.premierleague.com/api/bootstrap-static/"
        response (client/get url {:as :json})]
    (if (= 200 (:status response))
      (let [data (:body response)
            player-elements (:elements data)
            player-statistics (map (fn [player]
                                     {:id (:id player)
                                      :first-name (:first_name player)
                                      :second-name (:second_name player)
                                      :team (:team player)
                                      :now-cost (/ (:now_cost player) 10.0)
                                      :total-points (:total_points player)
                                      :form (:form player)
                                      :expected-points (Double/parseDouble (:ep_next player))})
                                   player-elements)]
        (reset! players player-statistics))
      (println "Failed to retrieve data from the API."))))

(defn rank-players
  "A function that ranks players based on predicted points."
  [players]
  (sort-by (fn [player] (- (:expected-points player))) players))

(defn suggest-best-captain
  "A function that selects the best captain based on predicted points."
  [team]
  (first (rank-players team)))