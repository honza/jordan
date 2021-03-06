Jordan
======

Jordan is a Clojure library for Compojure that allows you to specify which
routes require the user to be logged in or to be an administrator.

Jordan is a replacement for libraries like [friend][1].

> He lay flat on the brown, pine-needled floor of the forest, his chin on his
> folded arms, and high overhead the wind blew in the tops of the pine trees.
> The mountainside sloped gently where he lay; but below it was steep and he
> could see the dark of the oiled road winding through the pass. There was a
> stream alongside the road and far down the pass he saw a mill beside the
> stream and the falling water of the dam, white in the summer sunlight.
>
> --- For Whom The Bell Tolls, Ernest Hemingway

Installation
------------

[![Clojars Project](http://clojars.org/jordan/latest-version.svg)](http://clojars.org/jordan)

Usage
-----

Jordan gives you two macros for protecting your routes: `with-login-required`
and `with-admin-required`.

``` clojure

(ns xyz.core
  (:require [jordan.core :refer :all]))

(defroutes routes
  (GET "/" req"<h1>hello</h1>")
  (GET "/account/" req
    (with-login-required "<h1>hello logged in user</h1>"))
  (GET "/admin/" req
    (with-admin-required "<h1>hello admin</h1>")))

```

For a real world example, check out [ansel][2] the self-hosted photo gallery.

### How does Jordan check if a user is logged in?

By default, Jordan checks if the current request map includes a truthy `:user`
key.  You can of course specify your own function.

``` clojure
;; Always true
(reset! logged-in-fn (fn [req] true))
```

### How does Jordan check if a user is an admin?

By default, Jordan checks if the current request map includes a truthy `:admin`
key inside the `:user` object.  You can of course specify your own function.

``` clojure
;; Always true
(reset! admin-fn (fn [req] true))
```

### How can I customize the error page?

Easy

``` clojure
(reset! default-404 (fn [req] {:status 404}))
```

License
-------

BSD, short and sweet

[1]: https://github.com/cemerick/friend
[2]: https://github.com/honza/ansel
