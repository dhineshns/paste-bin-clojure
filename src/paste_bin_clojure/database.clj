(ns paste-bin-clojure.database
  (:require [clojure.java.jdbc :as sql]
            [debux.core :as dbg]))

;; user name : dn046118
;; password : root
;; port 5432

(def db-url "postgresql://localhost:5432/dn046118")
(def paste-bin-table-name :paste_bin_notes)


;; (sql/db-do-commands db-url
;;                     (sql/create-table-ddl paste-bin-table-name [[:language :text]
;;                                                             [:note :text]]))


(defn insert-note [note]
  (dbg/dbg (sql/insert! db-url paste-bin-table-name note)))

(defn select-star []
  (sql/query db-url
             [(str "select * from " (name paste-bin-table-name))]))

(select-star)
























