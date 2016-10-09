(ns client.core
  (:require [clj-http.client :as client]
            [debux.core :as dbx]
            [clojure.test :refer :all]
            ))
(def url-address "http://localhost:8091/insert-note")

(deftest test-pingable
  (is (= 200 (:status (client/get url-address)))))

(client/get url-address
            {:query-params {:language :clojure
                            :note "reduce all!"}})

(run-tests)


















