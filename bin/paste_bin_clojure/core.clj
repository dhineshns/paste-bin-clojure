(ns paste-bin-clojure.core
  (:require [ring.middleware.params :as params]
            [ring.util.response :as resp]
            [ring.adapter.jetty :as jetty]
            [debux.core :as dbg]))

(defn insert-note-database [note]
  (dbg/dbg "The note is inserted"))

(defn insert-note [{:keys [query-params]}]
  (insert-note-database query-params)
  (resp/response "Your note has been inserted. Thanks. "))

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






















