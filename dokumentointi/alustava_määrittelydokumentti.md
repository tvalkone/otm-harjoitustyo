<h1>Vaatimusmäärittely<h1>


<h2>Sovelluksen tarkoitus<h2>

Sovellus mahdollistaa IT-projektin tai muun vastaavan projektin tuntikirjanpidon ja työajan seurannan. 
Käyttäjät kirjaavat tehdyn työajan projektikohtaisesti projektin sisäisille tehtäville (task). 
Kirjattua työaikaa voi seurata raporteilta. Sovellus toteutetaan englanniksi.

<h2>Käyttäjät<h2>

Sovelluksella on aluksi tavallisen käyttäjän (user) rooli, mutta jatkokehitysversiossa myös projektipäällikön (project manager) rooli.

<h2>Sovelluksen toiminnallisuudet perusversiossa<h2>

<h3>Kirjautuminen<h3>

*  Käyttäjä voi luoda käyttäjätunnuksen kirjautuessaa ensimmäistä kertaa sovellukseen

   *  Käyttäjätunnuksen luomiseksi käyttäjän on syötettävä Etu -ja Sukunimi, käyttäjätunnus (username) ja salasana (password).
   *  Käyttäjätunnuksen on oltava vähintään kolme merkkiä pitkä ja salasanan vähintään viisi merkkiä.
   *  Etu -ja sukunimi oltava vähintään kaksi merkkiä pitkiä.
   *  Lisäksi käyttäjä valitsee projektipäällikön tai tavallisen käyttäjän roolin	
	
*  Käyttäjä voi kirjautua sovellukseen syöttämällä oikean käyttäjätunnuksen ja salasanan.
   
   *  Sovellus ilmoittaa jos käyttäjätunnus tai salasana on väärin.

<h3>Sovelluksen Käyttö tavallisena käyttäjänä<h3>

	
*  Kirjautumisen jälkeen käyttäjä näkee omat projektinsa käyttöliittymän projektinäkymässä.
   *  Jos käyttäjää ei ole kiinnitetty yhteenkään projektiin, projektinäkymässä näkyy vai "Available" -niminen projekti.

*  Käyttäjä voi kirjata projekteille tehtyä työaikaa viikkoraporttinäkymässä.

   *  Käyttäjä voi luoda viikkoraportin johon hän voi lisätä omia projektejaan ja joiden tehtäville kirjataan tehtyä työaikaa päiväkohtaisesti.
   *  Viikkoraportin voi tallentaa keskeneräisenä.
   *  Käyttäjä voi kuitata viikkoraportin valmiiksi, jolloin raporttia ei voi enää muuttaa. Raportti vaatii lopuksi varmistuksen kokonaistyöajalle.

* Käyttäjä voi katsoa vanhoja viikkoraportteja 


<h2>Jatkokehitys<h2> 


<h3>Sovelluksen käyttö projektipäällikkönä<h3>

*  Tavallisen käyttäjän toiminnallisuuksien lisäksi projektipäällikkö voi hallinnoida projekteja

   *   Projektipäällikkö voi luoda uuden projektin

       *   Projektilla on nimi, viisi merkkiä pitkä projektinumero, alku- ja loppupäivämäärä muodossa dd.mm.yyyy, projektin tila (open/closed) ja yksi projektipäällikkö.
       *   Projektille voi lisätä myös tavallisia käyttäjiä jolloin projekti näkyy käyttäjän projektinäkymässä ja käyttäjä voi kirjata sille työaikaa.
  
   *   Projektipäällikkö voi muuttaa projektin loppupäivämäärää tai sulkea projektin jolloin projektille ei voi enää kirjata tunteja.   
	    
   *   Projektipäällikkö näkee kaikkien projektille kirjanneiden käyttäjien projektille/tehtäville kirjaaman ajan.

<h3>Muita kehityskohteita<h3>

*   Käyttäjän ajanseuranta kuukausitasolla
*   Projektipäällikön erilaiset projekti/kuukausi/viikko/käyttäjä -raportointimallit
*   Kommenttien lisääminen viikkoraporteille

