(ns solucion3.lib.invoice-item)

(defn suma-bonita-invoice [a b]
  (+ a b)
)

(defn- discount-factor [{:keys [discount-rate]
                         :or                {discount-rate 0}}]
  (- 1 (/ discount-rate 100.0)))

(defn subtotal
  [{:keys [precise-quantity precise-price discount-rate]
    :as                item
    :or                {discount-rate 0}}]
  (* precise-price precise-quantity (discount-factor item))
)

