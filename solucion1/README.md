# solucion1

### Problem 1 Thread-last Operator ->>
Given the invoice defined in **invoice.edn** in this repo, use the thread-last ->> operator to find all invoice items that satisfy the given conditions. Please write a function that receives an invoice as an argument and returns all items that satisfy the conditions described below.
#### Requirements
- Load invoice to play around with the function like this:

```
(def invoice (clojure.edn/read-string (slurp "invoice.edn")))
```

#### Definitions
- An invoice item is a clojure map { … } which has an :invoice-item/id field. EG.

```
{:invoice-item/id     "ii2"  
  :invoice-item/sku "SKU 2"}
```

- An invoice has two fields :invoice/id (its identifier) and :invoice/items a vector of invoice items

#### Invoice Item Conditions
- At least have one item that has :iva 19%
- At least one item has retention :ret\_fuente 1%
- Every item must satisfy EXACTLY one of the above two conditions. This means that an item cannot have BOTH :iva 19% and retention :ret\_fuente 1%.

#### Execute the code 

In order to run this project execute with cmd:

```console
lein run
```

#### Result

Executing the code this is the output

```console
No retentions
RESULT:  {:invoice-item/id ii3, :invoice-item/sku SKU 3, :taxable/taxes [#:tax{:id t3, :category :iva, :rate 19}]}
No Tax
RESULT:  {:invoice-item/id ii4, :invoice-item/sku SKU 3, :retentionable/retentions [#:retention{:id r2, :category :ret_fuente, :rate 1}]}
```

This satisfy all the conditions according to the file "invoice.edn" provided.