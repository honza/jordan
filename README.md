Jordan
======

> He lay flat on the brown, pine-needled floor of the forest, his chin on his
> folded arms, and high overhead the wind blew in the tops of the pine trees.
> The mountainside sloped gently where he lay; but below it was steep and he
> could see the dark of the oiled road winding through the pass. There was a
> stream alongside the road and far down the pass he saw a mill beside the
> stream and the falling water of the dam, white in the summer sunlight.
>
> --- For Whom The Bell Tolls, Ernest Hemingway

Jordan is a Clojure authentication of web requests.

Usage
-----

``` clojure

(defroutes routes
  (GET "/" req"<h1>hello</h1>")
  (with-login-required
    (GET "/account/" req "<h1>hello logged in user</h1>"))
  (with-admin-required
    (GET "/admin/" req "<h1>hello admin</h1>"))))

```

License
-------

BSD, short and sweet
