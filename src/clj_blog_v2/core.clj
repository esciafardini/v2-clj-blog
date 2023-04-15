(ns clj-blog-v2.core
  (:gen-class))

(defn my-fn
  "Callable entry point to the application."
  [data]
  (println (str (or (:name data) "BOZO") " did the dub!"))
  data)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "the main fn was called")
  (my-fn {:name (first args)}))

(my-fn 3)
