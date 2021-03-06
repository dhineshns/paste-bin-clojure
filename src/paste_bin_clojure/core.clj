(ns paste-bin-clojure.core
  (:require [ring.middleware.params :as params]
            [ring.util.response :as resp]
            [ring.adapter.jetty :as jetty]
            [debux.core :as dbg]
            [paste-bin-clojure.database :as db]))

(defn insert-note-database [note]
  (let [uid (str (java.util.UUID/randomUUID))]
    (db/insert-note (-> note
                        (assoc :note_uid uid)))
    uid))

(defn insert-note [{:keys [query-params]}]
  
  (resp/response (str "Your note has been inserted. Thanks. "
                       (insert-note-database query-params))))

(defn handler [{:keys [uri], :as request}]
  (dbg/dbg request)
  (condp = uri
    "/insert-note" (insert-note request)
    (resp/response "I don't know what you are talking about!")))

(def app
  (-> #'handler
      (params/wrap-params)))

(defonce server-1
  (jetty/run-jetty app {:port 8091
                        :join? false}))






















