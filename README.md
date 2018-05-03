# Stehgreif-Projekt1-Burger


### Ein Burger Konfigurator mit folgenden Funktionen:

#### Kommands: 
    -   Anzeige des Menus "menu"
    -   Auswählen der Zutaten "zutat <bestellnr>" 
    -   Aktueller Burger anzeigen "burger"
    -   Bestellung aufgeben "erstellen"
    
-   Eine Karte mit Bestellnummer, Preis und Informationen
-   Warenkorb mit Zutaten, Informationen und Prei
-   Die Dauer der Bestellung + Gesamtpreis

-   Fleisch, Vegetarisch, Vegan
#### Brötchensorte, Salate, Saucen, Bratlinge, Gemüse:

    -   Hamburger (Standard)(1) – 27 mm, 1 1⁄2 Minuten 
    -   Hamburger Sesam(1) – 28 mm, 1 1⁄2 Minuten
    -   Vegan-Brötchen – 34 mm, 4 Minuten 
    -   Ciabatta – 41 mm, 5 1⁄2 Minuten
    
    -   Eisbergsalat1
    -   Rucolasalat
    
    -   Ketchup(1), 5 ml – normal
    -   Sandwich-Sauce(1), 10 ml – normal
    -   Chili-Sauce, 8 ml – scharf
    -   Honig-Senf-Sauce, 8 ml – süß
    
    -   Rindfleisch (Original) (1) – 25 mm, 4 1⁄2 Minuten
    -   Hähnchenfleisch gegrillt – 11 mm, 3 Minuten
    -   Falafel-Bratling – 21 mm, 3 1/2 Minuten
    -   Gemüse-Bratling – 25 mm, 4 Minuten
    
    (1) Zutat gehört zum Standard-Sortiment
    
#### Zubereitung:
    -   Saucen: <"Saucenname"> wird geschüttelt
    -   Gemüse: <"Gemüsename"> wird gewaschen
        -   1.Scheibe, 2.Scheibe ... <n>. Scheibe wird in der Dicke von <x> mm geschnitten
    -   Salat:  <"Salatname"> wird gewaschen
    -   Bratlinge:  <"Bratlingname"> wird <x> Minuten gebraten
    -   Brötchensorten:    <"Brötchenname"> wird <x> Minuten aufgebacken, bzw. wird direkt verwendet
    
#### Zutaten:
    -   Jede Zutat hat ihre eigene Class + Vererbungsstruktur
    -   Burger.class verwaltet Zutaten Array
    -   Burger kann frei zusammen gestellt werden mit max. 8 Zutaten

#### Verwaltung:
    -   Zutaten sollen an einer Stelle im Programm erstellt werden + Die Anzeige für das Menu
    -   Für alle Zutaten ein eigenes Array für die Verwaltung
    -   Ein eigenes Array als "Warenkorb" mit einer maximalen Burgeranzahl von 10
