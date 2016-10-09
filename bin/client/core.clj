(ns client.core
  (:require [clj-http.client :as client]
            [debux.core :as dbx]
            [clojure.test :refer :all]
            ))
(def url-address "http://localhost:8090/insert-note")

(deftest test-pingable
  (is (= 200 (:status (client/get url-address)))))

(client/post url-address
             {:form-params {:foo "bar"}
              :content-type :json})

(run-tests)


















