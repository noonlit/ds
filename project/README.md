# Project context and requirements
## 15. Scorul de la Bowling
<details>
  <summary>Click to expand!</summary>
Descriere: Un joc de bowling este alcătuit din X ture, și în fiecare tură un jucător poate să arunce de 2 ori cu bila. 

Scorul jucătorului pentru fiecare tură este numărul popicelor dărâmate plus un eventual bonus. Bonusul poate fi primit în 2 situații, pentru strike și pentru spare. 

Spare avem când jucătorul dărâmă toate cele 10 popice cu cele 2 aruncări din tura respectivă. În acest caz bonusul este numărul de popice
dărâmate la aruncarea următoare. 

Strike avem când juctorul dărâmă toate cele 10 popice dintr-o singură aruncare (în acest caz aruncarea a 2-a nu mai există). Bonusul pentru un strike este numărul popicelor dărâmate în tura următoare (deci la 2 aruncări, dacă există). 

În caz că avem mai multe strikeuri sau spare-uri consecutive, bonusul pentru fiecare caz se ia doar pentru tura următoare. 

Ne trebuie un container pentru: a reține numărul de popice dărâmate pentru fiecare tură.

Funcționalități:
- Citiți și memorați numărul de popice dărâmate de un jucător pentru X ture (se citește X-ul și după aceea numărul de popice pentru cele X ture). Dacă în ultima tură jucătorul are spare sau strike, jocul se termină, nu mai are voie la aruncări extra.

- Afișați câte spare-uri și câte strike-uri a avut jucătorul (calculați valorile doar dacă se alege
această funcționalitate, nu le calculați și rețineți în timpul citirii).

- Afișați scorul după fiecare tură (calculați valorile doar dacă se alege această funcționalitate, nu le
calculați și rețineți în timpul citirii).

Exemple:
Dacă au fost în total 6 ture: cu următoarele numere de popice dărâmate: 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1 scorul pe ture este:
- Tura 1: 1 + 4 = 5
- Tura a 2-a: 4 + 5 = 9
- Tura a 3-a: 6 + 4 = 10 + 5 = 15 – avem spare (10 popice darâmate din 2 aruncări, bonusul
este numărul de popice dărâmat la aruncarea următoare)
- Tura a 4-a: 5 + 5 = 10 + 10 = 20 – avem spare din nou
- Tura a 5-a: 10 + 1 = 11 – avem strike (toate popicele dărâmate dintr-o singură lovitură), bonusul este numărul popicelor dărâmate în tura următoare (în cele 2 aruncări)
- Tura a 6-a: 0 +1 = 1

Scor total: 5+9+15+20+11+1 = 61, au fost 2 spare-uri și 1 strike.
</details>

## Implementation
Main application entry point is Application.java. If this entry point is used, a game will be built from user input.

The Service directory contains:
- a GameStatsWriter, whose responsibility it is to display game stats requested by the player. 

The Model directory contains:
- the Game class, which is a container for game Rounds and also calculates the total score and per-round score for the game.
- the Round class, which is a container for Rolls.
- the Roll class, which holds the number of pins the player knocked down in one attempt.
