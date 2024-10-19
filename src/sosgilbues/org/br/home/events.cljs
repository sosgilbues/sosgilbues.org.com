(ns sosgilbues.org.br.home.events
  (:require [re-frame.core :as re-frame]
            [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-fx
  ::set-about-us-section-current-tab
  (fn-traced [{:keys [db]} [_ tab]]
    {:db (assoc db :about-us-section-current-tab tab)}))
