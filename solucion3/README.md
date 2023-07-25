# solucion3

## Problem 3: Test Driven Development
Given the function **subtotal** defined in **invoice-item.clj** in this repo, write at least five tests using clojure core **deftest** that demonstrates its correctness. This subtotal function calculates the subtotal of an invoice-item taking a discount-rate into account. Make sure the tests cover as many edge cases as you can!

#### Execute the code 

In order to run this project execute with cmd:

```console
lein test
```

#### Result

I proposed these test cases:

1. A simple full input case

    ```console
    {:precise-quantity 1 :precise-price 10 :discount-rate 50}
    ```

2. A case where "discount-rate" is 0 explicitly

    ```console
    {:precise-quantity 20 :precise-price 10 :discount-rate 0}
    ```

3. A case where "discount-rate" is above of 100

    ```console
    {:precise-quantity 30 :precise-price 10 :discount-rate 200}
    ```

4. A case where "discount-rate" is not provided

    ```console
    {:precise-quantity 5 :precise-price 20}
    ```

5. A case where the result must be 0

    ```console
    {:precise-quantity 0 :precise-price 10}
    ```

Executing the code this is the output

```console
lein test solucion3.core-test

Ran 5 tests containing 5 assertions.
0 failures, 0 errors.
```

This satisfy all the tests cases.