
# stocks


## run

### run dev mode
```sh
$ lein repl
user=> (require 'stocks.web)
user=>(def server (stocks.web/run-dev))
```

### run 
```sh
$ lein repl
user=> (require 'stocks.web)
user=>(def server (stocks.web/-main))
```

### stop server
on repl:
```sh
user=>(.stop server)
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

