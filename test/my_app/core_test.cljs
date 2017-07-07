(ns my-app.core-test
  (:require [cljs.test :refer-macros [is testing]]
            [devcards.core :refer-macros [deftest]]
            [my-app.core :as app]))

(deftest a-test
  (is (= (app/plus 3 4) 7)))

(deftest b-test
  (is (= (app/plus 3 7) 9))
  (is (= (app/plus 3 7) 10)))
