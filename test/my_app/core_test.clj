(ns my-app.core-test
  (:require [midje.sweet :refer :all]
            [my-app.core :refer :all]
            [cloudlog-events.testing :refer [scenario as emit query apply-rules]]))

(fact
 ;; This test is written in the cloudlog testing DSL.
 ;; See http://axiom-clj.org/cloudlog-events.testing.html for more details.
 (scenario
  (as "alice"
      (emit [:my-app/task "alice" "Create app"])
      (emit [:my-app/task "alice" "Show app to @bob"])
      (query [:my-app/my-tasks "alice"]) => #{["alice" "Create app"]
                                              ["alice" "Show app to @bob"]})
  (apply-rules [:my-app.core/task-where-user-is-mentioned "bob"]) => #{["alice" "Show app to @bob"]}
  (as "bob"
      (query [:my-app/my-tasks "bob"]) => #{["alice" "Show app to @bob"]})))
