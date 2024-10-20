(ns sosgilbues.org.br.home.views
  (:require [re-frame.core :as re-frame]
            [sosgilbues.org.br.routes :as routes]
            [sosgilbues.org.br.home.events :as events]
            [sosgilbues.org.br.home.subs :as subs]))

(defn who-we-are []
  [:div.container.d-flex.justify-content-center
   [:div {:style {:width "100%" :height "50%"}}
    [:h2 "Quem somos"]
    [:p "Somos a primeira instituição civil sem fins lucrativos de serviço voluntário, voltada para controle da
       desertificação no Município de Gilbués, Estado do Piauí. Fundada no ano de 2001, por professores, estudantes,
       servidores públicos, intelectuais e ambientalistas."]]])

(defn what-we-do []
  [:div.container.d-flex.justify-content-center
   [:div {:style {:width "1000%" :height "50%"}}
    [:h2 "O que fazemos"]
    [:p "Buscamos por meio da difusão do conhecimento de políticas de controle e convivência com processo acelerado
       de degradação ambiental que atinge o município de Gilbués e adjacências. Nosso trabalho é voltado para educação
       ambiental e sustentabilidade, especialmente com o público jovem e famílias atingidas, através de grupos de
       conversa, seminários e debates, de forma proativa e preventiva."]]])

(defn what-we-defend []
  [:div.container.d-flex.justify-content-center
   [:div {:style {:width "100%" :height "50%"}}
    [:h2 "O que defendemos"]
    [:ul
     [:li "Uso sustentável dos recursos hídricos"]
     [:li "Aplicação de práticas sustentáveis na agricultura"]
     [:li "Uso de manejo sustentável do solo"]
     [:li "Atividades menos ofensivas ao meio ambiente"]
     [:li "Educação e pesquisa"]]]])

(defn home-panel []
  [:div.container.p-5
   [:h2.d-flex.justify-content-center "Associação de Defesa Ambiental e Controle da Desertificação de Gilbués"]
   [:img.img-fluid {:src "assets/banner.png"}]

   (let [about-us-section-current-tab (re-frame/subscribe [::subs/about-us-section-current-tab])]
     [:div.container.mt-5.mb-5.d-flex.flex-column.align-items-center
      [:ul.nav.nav-tabs.justify-content-center
       [:li.nav-item
        [(if (= @about-us-section-current-tab :who-we-are) :a.nav-link.active :a.nav-link)
         {:href     "#"
          :on-click #(re-frame/dispatch [::events/set-about-us-section-current-tab :who-we-are])} "Quem Somos"]]
       [:li.nav-item
        [(if (= @about-us-section-current-tab :what-we-do) :a.nav-link.active :a.nav-link)
         {:href     "#"
          :on-click #(re-frame/dispatch [::events/set-about-us-section-current-tab :what-we-do])} "O que fazemos"]]
       [:li.nav-item
        [(if (= @about-us-section-current-tab :what-we-defend) :a.nav-link.active :a.nav-link)
         {:href     "#"
          :on-click #(re-frame/dispatch [::events/set-about-us-section-current-tab :what-we-defend])} "O que defendemos"]]]
      [:div.row.container.d-flex.justify-content-center
       (case @about-us-section-current-tab
         :who-we-are (who-we-are)
         :what-we-do (what-we-do)
         :what-we-defend (what-we-defend)
         (who-we-are))]])

   [:div.d-grid.gap-3.justify-content-center
    [:div.mx-auto [:h2 "Reportagens"]]
    [:div.mx-auto
     [:iframe {:src             "https://www.youtube.com/embed/yvfo6zt9d_o?si=nILBaQDp2ZdGfhLy?rel=0"
               :title           "YouTube video player"
               :frameborder     "0"
               :allow           "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
               :referrerpolicy  "strict-origin-when-cross-origin"
               :allowfullscreen true
               :width           "560"
               :height          "315"}]]

    [:div.mx-auto
     [:iframe {:src             "https://www.youtube.com/embed/C9JwxIyn0Vw?rel=0"
               :title           "Graças a um projeto do Governo Federal, agricultores cultivam alimentos em terras degradadas"
               :frameborder     "0"
               :allow           "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
               :referrerpolicy  "strict-origin-when-cross-origin"
               :allowfullscreen true
               :width           "560"
               :height          "315"}]]]])

(defmethod routes/panels :home-panel [] [home-panel])
