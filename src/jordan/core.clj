(ns jordan.core
  (:gen-class))

(defn logged-in? [req]
  (get-in req [:user]))

(defn admin? [req]
  (get-in req [:user :admin]))

(defn default-not-found [req]
  "404")

(def logged-in-fn (atom logged-in?))
(def admin-fn     (atom admin?))
(def default-404  (atom default-not-found))

(defmacro with-login-required [expr]
  (let [[method path req & body] expr]
    `(~method ~path ~req (if (@logged-in-fn ~req)
                           ~@body
                           (@default-404 ~req)))))

(defmacro with-admin-required [expr]
  (let [[method path req & body] expr]
    `(~method ~path ~req (if (@admin? ~req)
                           ~@body
                           (@default-404 ~req)))))
