(ns sosgilbues.org.br.views
  (:require
    [re-frame.core :as re-frame]
    [sosgilbues.org.br.events :as events]
    [sosgilbues.org.br.routes :as routes]
    [sosgilbues.org.br.subs :as subs]))


(defn member-team-card
  [image-url full-name role]
  [:div.col [:div.card.h-100
             [:img.card-img-top {:src image-url}]
             [:div.card-body
              [:h5.card-title full-name]
              [:p.card-text role]]]])

(defn team-panel []
  [:<>
   [:div.container
    [:h1.title "Equipe"]
    [:h2.title "Liderança"]
    [:div.container.row.row-cols-1.row-cols-md-4.g-3
     (member-team-card "assets/members/ivete.jpg" "Ivete Gomes Da Silva Oliveira" "Diretora")]]])

(defmethod routes/panels :team-panel [] [team-panel])

(defn home-panel []
  [:div.container [:h1 "Associação de Defesa Ambiental e Controle da Desertificação de Gilbues"]
   [:img.img-fluid {:src "assets/banner.png"}]])

(defmethod routes/panels :home-panel [] [home-panel])

;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [:<>
     [:nav.navbar.navbar-expand-lg.bg-body-tertiary
      [:div.container-fluid
       [:a.navbar-brand {:href "/"} [:img.d-inline-block.align-text-top.mx-1 {:height "24"
                                                                              :src    "logo.png"}] [:strong "SOS "] "Gilbués"]
       [:ul.navbar-nav.me-auto.mb-2.mb-lg-0
        [:li.nav-item.dropdown
         [:a.nav-link.dropdown-toggle {:href "#" :role "button" :data-bs-toggle "dropdown"} "Sobre"]
         [:ul.dropdown-menu
          [:li [:a.dropdown-item {:href "/team"} "Equipe"]]]]]]]
     (routes/panels @active-panel)]))
