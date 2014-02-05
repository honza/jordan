(ns jordan.core
  (:gen-class))

(defn logged-in? [req]
  (get-in req [:user]))

(defn admin? [req]
  (get-in req [:user :admin]))

(defn default-not-found [req]
  {:status 404
   :body "Not found"})

(def logged-in-fn (atom logged-in?))
(def admin-fn     (atom admin?))
(def default-404  (atom default-not-found))

(defn with-login-required* [handler]
  (fn [req]
    (if (@logged-in-fn req)
      (handler)
      (@default-404 req))))

(defmacro with-login-required [& body]
  `(with-login-required* (fn [] ~@body)))

(defn with-admin-required* [handler]
  (fn [req]
    (if (@admin-fn req)
      (handler)
      (@default-404 req))))

(defmacro with-admin-required [& body]
  `(with-admin-required* (fn [] ~@body)))
