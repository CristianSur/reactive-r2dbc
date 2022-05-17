# reactive-r2dbc

Un cuvant inainte 

  Am fost uimit cand vazusem termen maxim de o zi, daca sa nu iai in considerare jobul (uneori si universitate), ar arata mai posibil.
  Insusi taskul nu pare dificil de fel, mult timp ia acel fapt, ca e nevoie de folosit multe tehnici noi si uneori 
  te stopezi la un bug din neatentie. Am fost nevuit multe sa studiez de la baza, ca de exemplu in ce proiecte se merite de folosit reactor.
  Am reusit doar jumatate din cele planuite, vroiam sa fie si conectarea la bnm.md, dar, cred eu, 
  ca mai bine de aratat asa cum este la moment. Mai departe voi continua proiectul deja singur, pentru sine.
  
  Nu pot sa spun ca e un project curat, dar arata fix atat de calitativ si chiar mai mult, decat se merita pentru timpul scurt ce a fost investit.
  
Lansarea programului 
port: 9090

  In resource se aflu 2 sql files, unul care creaza tabelele si altul care inserteaza datele in ele (ele se pornesc pe rand). La fel acolo se afla si
  config.properties in care sunt salvate careva constante ca de exemplul drumul pe care se va salva Excel file (report) sau datele pentru
  baza de date. (In propertyReader trebuie de pus absolutePath la locatia config.properties, am uitat sa clarific).
  
  Excel file cu istoria transactiilor de ziua curenta se poate primi pe adresa http://localhost:9090/exchanger/excel
  In Excel datele arata mai user friendly, in loc de numar a operatorului e numele acestuia (ca de exemplu)
  
 Cea mai multa functionalitate este anume in schimbul valutar, nu am dovedit sa scriu teste dar este totusi unul, care face post request.
  (L-am adaugat pentru ca sa fie posibilitatea de facut transactii utilizand Post chiar din code)
 Pentru a face un schimb e nevoie de trimis un post cu body in care sa fie id'ul operatorului, id'ul valutei transmisa si celei primite si desigur ca suma.
 Deja in program se face calculul facanduse Update la tabela (fara procent, cursul e constant deoarece programul e scris de un om bun)
 Tranzactia este adaugata in tabela Exchanger,
 iar in tabela Cash(unde se pastreaza datele despre cash la operatori) se face update (cantitateaVeche+-sumaPrimita/eliberata) dependend de valutele date

 
 Concluzia
 
   Mie cu adevarat mi-a placut sa fac acest task si sunt extrem de interesat in posibilitatea de a ma dezvolta in acest curent. 
   Daca este ocazia, sunt gata sa fac si mai multe taskuri pentru a avansa.
  
