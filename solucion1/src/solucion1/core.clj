(ns solucion1.core
	(:require [clojure.java.io :as io]
    	[clojure.edn :as edn]
	)
)

(defn read-edn-file [file-path]
	(with-open [reader (io/reader file-path)]
    	(edn/read (java.io.PushbackReader. reader))
	)
)

(def invoice_map (read-edn-file "./src/solucion1/invoice.edn"))

(defn has_retention [retention items]
	(doseq [i items]
		(if (contains? i :retentionable/retentions)
			(do
				(println ":retentionable/retentions EXIST")
				;;(println ":retentionable/retentions" (get-in i [:retentionable/retentions 0 :retention/rate]))

			)
			(do
				(println ":retentionable/retentions DO NOT EXIST")
			)
		)
	)
)

(defn has_tax_rate [rate retention items]
	(doseq [i items]
		(if (contains? i :taxable/taxes)
			(do
				(println ":taxable/taxes EXIST")
				;;(println ":tax/rate" (get-in i [:taxable/taxes 0 :tax/rate]))
				(if (= (has_retention retention items) nil)
					(do
						(if (= (get-in i [:taxable/taxes 0 :tax/rate]) rate)
							(do
								(println "Result Tax:" i)
							)
						)
					)
				)
			)
			(do
				(println ":taxable/taxes DO NOT EXIST")
				(has_retention retention items)
			)
		)
	)
)

(defn filter_data [rate retention items]
	(doseq [i items]
		(if (and (contains? i :taxable/taxes) (= (get-in i [:taxable/taxes 0 :tax/rate]) rate))
			(do
				;;(println ":taxable/taxes EXIST")
				;;(println ":tax/rate" (get-in i [:taxable/taxes 0 :tax/rate]))
				(if (not (contains? i :retentionable/retentions))
					(do
						(println "No retentions")
						(println "RESULT: " i)
					)
				)
			)
			(do
				;;(println ":taxable/taxes DO NOT EXIST")
				(if (contains? i :retentionable/retentions)
					(do
						;;(println ":retentionable/retentions EXIST")
						(if (= (get-in i [:retentionable/retentions 0 :retention/rate]) retention)
							(do
								(println "No Tax")
								(println "RESULT: " i)
								)
							)
						;;(println "No Tax")
						;;(println "RESULT: " i)
					)
					;;(do
					;;	(println ":retentionable/retentions DO NOT EXIST")
					;;	)
				)
			)
		)
	)
)

(defn -main
	"I don't do a whole lot ... yet."
  	[& args]
	;;(println "Hello, World!")
	(def invoice_items (
		(:invoice/items invoice_map) 0)
	)
	(def my_filter
		(->> invoice_map
			(:invoice/items)
			(filter_data 19 1)
		)
	)
)