# solucion2

## Problem 2: Core Generating Functions
  Given the invoice defined in **invoice.json** found in this repo, generate an invoice that passes the spec **::invoice** defined in **invoice-spec.clj**. Write a function that as an argument receives a file name (a JSON file name in this case) and returns a clojure map such that

```
(s/valid? ::invoice invoice) => true 
```

where invoice represents an invoice constructed from the JSON.

#### Execute the code 

In order to run this project execute with cmd:

```console
lein run
```

#### Result

Executing the code the JSON file provided does not meet the spec due to the field ":invoice/items".