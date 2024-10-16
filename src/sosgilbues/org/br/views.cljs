(ns sosgilbues.org.br.views
  (:require
    [re-frame.core :as re-frame]
    [sosgilbues.org.br.events :as events]
    [sosgilbues.org.br.routes :as routes]
    [sosgilbues.org.br.subs :as subs]))


(defn member-team-card
      [image-url full-name role details]
      [:div.col [:div.card.sm-3.h-100
                 [:img.card-img-top {:src image-url}]
                 [:div.card-body
                  [:h5.card-title full-name]
                  [:p.card-text [:strong role]]
                  details]]])

(defn team-panel []
      [:<>
       [:div.container
        [:div.row.p-5
         [:h1.title "Equipe"]
         [:h2.title "Diretoria"]
         [:div.container.row.row-cols-1.row-cols-md-4.g-3
          (member-team-card "assets/members/ivete.jpg" "Ivete Gomes Da Silva Oliveira" "Presidente - Sócia fundadora"
                            [:<>
                             [:p "Pós graduada em coordenação pedagógica atuando na educação a 37 anos."]
                             [:p "Participou da 6ª COP – Cuba."]
                             [:p "ivetegill@yahoo.com.br"]])
          (member-team-card "assets/members/leandro.jpg" "Leandro Andrade Figueredo" "Vice Presidente - Sócio fundador"
                            [:<>
                             [:p "Graduado em Geografia e Administração, especialista em Geo-história."]
                             [:p "Professor e gestor escolar há 12 anos."]
                             [:p "leandro-af@hotmail.com"]])
          (member-team-card "assets/members/fatinha.jpg" "Fatima Lustosa Barreira de Oliveira" "Diretora de Educação e Mobilização Comunitária - Sócia fundadora"
                            [:<>
                             [:p "Especialista em Língua e Literatura Portuguesa, Docência do Ensino Superior e em\nInformática na Educação."]
                             [:p "Professora Aposentada. Militante do meio Ambiente."]
                             [:p "fatimalbo@hotmail.com"]])
          (member-team-card "assets/members/fabriciano.jpeg" "Fabriciano da Cunha Corado Neto" "Diretor de estudo e planejamento - Sócio fundador"
                            [:<>
                             [:p "Agronomia - Universidade Federal de Goiás"]
                             [:p "Especialização em Meio Ambiente e Agronegócio com Habilitação em Docência Superior - Universidade Estadual do Piauí"]
                             [:p "Mestrado em Solos e Nutrição de Plantas - Universidade Federal do Piauí"]
                             [:p "Palestrante nas áreas de Meio Ambiente (com foco em  Desertificação e Conservação de Solos) e Processos de Produção para pequenos e médios produtores"]
                             [:p "fabricianocorado316@gmail.com"]])
          (member-team-card "assets/members/x.jpg" "Raimundo Nelson Aguiar Lustosa" "Diretor de administração - Sócio fundador"
                            [:<>
                             [:p "Sociólogo."]
                             [:p "dhoka_lustosa@hotmail.com"]])
          (member-team-card "assets/members/marlos.jpeg" "José Marlos Moreira de Souza" "Diretor financeiro"
                            [:<>
                             [:p "Graduado em Geografia e Administração, especialista em Geografia Meio Ambiente e Sustentabilidade."]
                             [:p "Ambientalista há 22 anos, professor na rede estadual de ensino."]
                             [:p "moreirauabufpi@gmail.com"]])
          (member-team-card "assets/members/jenerson.jpg" "Jênerson Gonçalves da Silva de Jesus" "Diretor de divulgação e comunicação"
                            [:<>
                             [:p "Zootecnista, Geógrafo, especialista em Geoprocessamento."]
                             [:p "Professor na rede estadual de ensino."]
                             [:p "Ambientalista membro da SOS Gilbués há 17 anos."]
                             [:p "jenersongoncalves@gmail.com"]])]]
        [:div.container.p-5
         [:h2.title "Conselho Fiscal"]
         [:ul
          [:li "Vera Fonseca"]
          [:li "Aldo Pinheiro"]]]]])

(defmethod routes/panels :team-panel [] [team-panel])

(defn home-panel []
      [:div.container.p-5
       [:h2 "Associação de Defesa Ambiental e Controle da Desertificação de Gilbués"]
       [:img.img-fluid {:src "assets/banner.png"}]
       [:h2 "Quem somos"]
       [:p "Somos a primeira instituição civil sem fins lucrativos de serviço voluntário, voltada para controle da
       desertificação no Município de Gilbués, Estado do Piauí. Fundada no ano de 2001, por professores, estudantes,
       servidores públicos, intelectuais e ambientalistas."]
       [:h2 "O que fazemos"]
       [:p "Buscamos por meio da difusão do conhecimento de políticas de controle e convivência com processo acelerado
       de degradação ambiental que atinge o município de Gilbués e adjacências. Nosso trabalho é voltado para educação
       ambiental e sustentabilidade, especialmente com o público jovem e famílias atingidas, através de grupos de
       conversa, seminários e debates, de forma proativa e preventiva."]
       [:h2 "O que defendemos"]
       [:ul
        [:li "Uso sustentável dos recursos hídricos"]
        [:li "Aplicação de práticas sustentáveis na agricultura"]
        [:li "Uso de manejo sustentável do solo"]
        [:li "Atividades menos ofensivas ao meio ambiente"]
        [:li "Educação e pesquisa"]]
       [:div.row {:style {:height "720px"}}
        [:iframe {:src             "https://www.youtube.com/embed/yvfo6zt9d_o?si=nILBaQDp2ZdGfhLy?rel=0"
                  :title           "YouTube video player"
                  :frameborder     "0"
                  :allow           "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  :referrerpolicy  "strict-origin-when-cross-origin"
                  :allowfullscreen true}]]
       [:div.row.mt-2 {:style {:height "720px"}}
        [:iframe {:src             "https://www.youtube.com/embed/C9JwxIyn0Vw?rel=0"
                  :title           "Graças a um projeto do Governo Federal, agricultores cultivam alimentos em terras degradadas"
                  :frameborder     "0"
                  :allow           "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  :referrerpolicy  "strict-origin-when-cross-origin"
                  :allowfullscreen true}]]
       [:div.row.mt-2 {:style {:height "720px"}}
        [:iframe {:src "https://www.youtube.com/embed/9RioCudwQqY?rel=0"
                  :title "Piauí luta contra a desertificação de terras"
                  :frameborder "0"
                  :allow "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  :referrerpolicy "strict-origin-when-cross-origin"
                  :allowfullscreen true}]]])

(defmethod routes/panels :home-panel [] [home-panel])

;; main

(defn main-panel []
      (let [active-panel (re-frame/subscribe [::subs/active-panel])]
           [:<>
            [:nav.navbar.navbar-expand-lg.bg-success.bg-gradient
             [:div.container-fluid
              [:a.navbar-brand.text-white {:href "/"} [:img.d-inline-block.align-text-top.mx-1 {:height "24"
                                                                                                :src    "logo.png"}] [:strong "SOS "] "Gilbués"]
              [:ul.navbar-nav.me-auto.mb-2.mb-lg-0
               [:li.nav-item.dropdown
                [:a.nav-link.dropdown-toggle.text-white {:href "#" :role "button" :data-bs-toggle "dropdown"} "Sobre"]
                [:ul.dropdown-menu
                 [:li [:a.dropdown-item {:href "/team"} "Equipe"]]]]]]]
            (routes/panels @active-panel)
            [:footer.container-fluid.p-4.bg-dark.sticky-bottom
             [:div.container.text-white [:p "Nossa instituição é mantida por doações dos voluntários e associados."]]]]))
