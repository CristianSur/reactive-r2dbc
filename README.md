# reactive-r2dbc

Un cuvant inainte --
  Am fost uimit cand vazusem termen maxim de o zi, daca sa nu i-ai in considerare jobul (uneori si universitate), ar arata mai posibil.
  Insusi taskul nu pare dificil de fel, mult timp ia acel fapt, ca e nevoie de folosit multe tehnici noi si uneori 
  te stopezi la un bug din neatentie. Am dovedit sa fac doar jumatate din cele planuite, nici conectarea cu bnm.md nu am reusit sa o fac,
  dar, cred eu, ca mai bine de aratat asa. Mai departe voi continua proiectul deja singur.
  
Lansarea programului --
  In resource se aflu 2 sql files, unul care creaza tabelele si altul care inserteaza datele in ele. La fel acolo se afla si
  config.properties in care sunt salvate careva constante ca de exemplul drumul pe care se va salva Excel file (report) sau datele pentru
  baza de date. (In propertyReader trebuie de pus absolutePath la config.properties, am uitat sa clarific).
  
  Excel file cu istoria transactiilor de ziua curenta se poate primi pe adresa http://localhost:8080/exchanger/excel
  
 Cea mai multa functionalitate este anume in schimbul valutar, nu am dovedit sa scriu teste dar este totusi unul, case simuleaza post request. 
 Pentru a facec un schimb e nevoie de trimis un post cu body in care sa fie id'ul operatorului, id'ul valutei transmisa si celei primite si desigur ca suma.
 Deja in program se face tranferul (fara procent, cursul e constant deoarece programul e scris de un om bun)
  
  
