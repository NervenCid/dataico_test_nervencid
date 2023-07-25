(ns solucion2.core
	(:require
		[clojure.java.io :as io]
		[clojure.data.json :as json]
		[clojure.spec.alpha :as s]
		[solucion2.specs.invoice_spec :as invoice-spec]
		)
	(:gen-class)
)

(defn read-json-file [file-path]
	(with-open [reader (io/reader file-path)]
		(json/read reader)
	)
)

(defn json-to-map [file-path]
	(let [json-data (read-json-file file-path)]
		json-data
		)
	)

(def json-file-path "./src/solucion2/invoice.json")

(def invoice-data (json-to-map json-file-path))

(defn validate [data]
	(s/valid? ::invoice-spec/invoice data)
)

(defn -main
	"I don't do a whole lot ... yet."
	[& args]
	(println "Validation Result: " (validate invoice-data))
	(println "Explain" (s/explain-str ::invoice-spec/invoice invoice-data))
)
