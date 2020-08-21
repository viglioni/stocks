
# stocks

## About
This project is a simple endpoint that checks some info about a stock and returns it.

### note that
1. All stock values have 15min of delay
2. All currency values are in BRL.
3. For now only IBOVESPA stocks.

## API

| Endpoint          | Name         | Request Type | Return | Return Code |
|-------------------|--------------|--------------|--------|-------------|
| "/"               | Hello World  | GET          | str    | 200         |
| "/health-check"   | Health Check | GET          | str    | 200         |
| "/ibov:stock-id"  | Stock        | GET          | json   | 200         |

### Example

```sh
$  curl http://localhost:4666/ibov/petr4
```

will return:
```json
{
    "price": "22.72",
    "max": "22.98",
    "min": "22.53",
    "variation": "-0.52",
    "stock-id": "petr4",
    "currency": "brl",
    "time": "2020-08-15T15:36:59.858-0300"
}
```

##### note that
1. Invalid stock ids will get you a 404.
2. Passing no stock id will get you a 500.


## run

You must have [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html ) installed on your machine. To run dev mode you must have [Leiningen](https://leiningen.org/#install ) too.

### With Leiningen
```sh
$ lein deps
$ lein run
```

### With java
```sh
$ java -jar ./executable/stocks-standalone.jar
```


### With Clojure Repl
#### dev mode
```sh
$ lein repl
user=> (require 'stocks.web)
user=> (def server (stocks.web/run-dev))
```

#### run 
```sh
$ lein repl
user=> (require 'stocks.web)
user=> (def server (stocks.web/-main))
```

#### stop server
```sh
user=> (.stop server)
```

Your app should now be running on [localhost:4666](http://localhost:4666/).

## test

Run all tests
```shell
$ lein test
```

Run tests in watch mode (you must have [fswatch](https://github.com/emcrisostomo/fswatch) installed)
```shell
$ lein test:watch
```

## :)
I hope this can be useful for anyone. 
In the future I may create a new endpoint that returns in USD.
