# reactive-r2dbc

Din cauza ca aceasta este un stack de tehnologii noi, am avut nevoie de multa documentarea,
in total mi-a luat 2 zile pline
  
Lansarea programului 
port: 9090
 

  In resource se aflu 2 sql files, unul care creaza tabelele si altul care inserteaza datele in ele (ele se pornesc pe rand). La fel acolo se afla si
  config.properties in care sunt salvate careva constante ca de exemplul drumul pe care se va salva Excel file (report) sau datele pentru
  baza de date. (In propertyReader trebuie de pus absolutePath la locatia config.properties, am uitat sa clarific). La fel PropertyReader existent
  este doar pentru aceasta etapa, ele nu ar functiona cum se cade in afara de IDE.
  
  Initial aveam insertarea sutei de date din diverse XML prin stream sau apeland direct la bnm.md, va fi adaugat deja cu timpul
  
  Excel file cu istoria transactiilor de ziua curenta se poate primi pe adresa http://localhost:9090/exchanger/excel
  In Excel datele arata mai user friendly, in loc de numar a operatorului e numele acestuia (ca de exemplu)
  
 Cea mai multa functionalitate este anume in schimbul valutar, nu am dovedit sa scriu teste dar este totusi unul, care face post request.
  (L-am adaugat pentru ca sa fie posibilitatea de facut transactii utilizand Post chiar din code)
 Pentru a face un schimb e nevoie de trimis un post cu body in care sa fie id'ul operatorului, id'ul valutei transmisa si celei primite si desigur ca suma.
 Deja in program se face calculul facanduse Update la tabela (fara procent, cursul e constant deoarece programul e scris de un om bun)
 Tranzactia este adaugata in tabela Exchanger,
 iar in tabela Cash(unde se pastreaza datele despre cash la operatori) se face update (cantitateaVeche+-sumaPrimita/eliberata) dependend de valutele date

  
