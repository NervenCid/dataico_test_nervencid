(ns solucion3.core-test
  	(:require [clojure.test :refer :all]
		[solucion3.core :refer :all]
		[solucion3.lib.invoice-item :refer :all]
	)
)

(deftest test-subtotal-1

	(is (= 5.0 (subtotal {:precise-quantity 1 :precise-price 10 :discount-rate 50})))

)

(deftest test-subtotal-2

	(is (= 200.0 (subtotal {:precise-quantity 20 :precise-price 10 :discount-rate 0})))

)

(deftest test-subtotal-3

	(is (= -300.0 (subtotal {:precise-quantity 30 :precise-price 10 :discount-rate 200})))

)

(deftest test-subtotal-4

	(is (= 100.0 (subtotal {:precise-quantity 5 :precise-price 20})))

)


(deftest test-subtotal-5

	(is (= 0.0 (subtotal {:precise-quantity 0 :precise-price 10})))

)