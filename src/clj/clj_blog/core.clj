(ns clj_blog.core
  (:require [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn my-fn
  "Callable entry point to the application."
  [input-data-map]
  (println (str (or (:name input-data-map) "BOZO") " did the dub!")))

(defonce server (atom nil))

(defn start-server [port-number]
  (reset! server
          (jetty/run-jetty (fn [req] {:status 200 :body "Hello" :headers {}})  ;; a really basic handler
                           {:port port-number
                            :join? false}))) ;; don't block the main thread

(defn stop-server []
  (when-some [s @server] ;; check if there is an object in the atom
    (.stop s)            ;; call the .stop method
    (reset! server nil)));; overwrite the atom with nil

(comment
  (start-server 3888)
  (stop-server))

(defn -main
  "Starts up a jetty server that can be stopped via repl"
  [port-num]
  (println "main fn was called")
  (start-server (Integer/parseInt port-num))
  (println "Server started on port " port-num))
