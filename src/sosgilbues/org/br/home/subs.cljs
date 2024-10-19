(ns sosgilbues.org.br.home.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::about-us-section-current-tab
  (fn [db _]
    (:about-us-section-current-tab db)))
