(ns microblog-clojure.core
    (:require [compojure.core :as c]
              [ring.adapter.jetty :as j])
              
  (:gen-class))

(c/defroutes app
  (c/GET "/" request
    "Hello, world!"))

(defonce server (atom nil))

(defn -main []
  (when @server
    (.stop @server))
  (reset! server (j/run-jetty app {:port 3000 :join? false})))
