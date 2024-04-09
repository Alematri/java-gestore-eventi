CONSEGNA

Stiamo lavorando a un programma che deve gestire eventi (ad esempio concerti, conferenze, spettacoli,...)
MILESTONE :1:
La consegna è di creare una classe Evento che abbia le seguenti proprietà:
● titolo
● data (LocalDate)
● numero di posti in totale (capienza della location)
● numero di posti prenotati
Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati che va inizializzato a 0.
Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. In caso contrario sollevare opportune eccezioni.
Aggiungere metodi getter e setter in modo che:
● titolo sia in lettura e in scrittura
● data sia in lettura e scrittura
● numero di posti totale sia solo in lettura
● numero di posti prenotati sia solo in lettura
Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
1. prenota : aggiunge un certo numero di posti prenotati. Se l’evento è già passato o non ha abbastanza posti disponibili deve sollevare un’eccezione.
2. disdici : riduce di un certo numero i posti prenotati. Se l’evento è già passato o non ci sono abbastanza prenotazioni deve sollevare un’eccezione.
3. l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
MILESTONE :2:
1. Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.
2. Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo eventuali eccezioni.
3. Stampare a video il numero di posti prenotati e quelli disponibili
4. Chiedere all’utente se e quanti posti vuole disdire
5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo eventuali eccezioni
6. Stampare a video il numero di posti prenotati e quelli disponibili
MILESTONE :3:
Creare una classe Concerto che estende Evento, che ha anche gli attributi :
● ora: LocalTime
● prezzo: BigDecimal
Aggiungere questi attributi nel costruttore e implementarne getter e setter
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€)
Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato

--------------------------------

MILESTONE 1

1- Definire la struttura base della classe Evento.
2- Aggiungere i campi dati titolo, data, numeroPostiTotali e numeroPostiPrenotati.
3- Implementare il costruttore della classe per inizializzare questi campi dati.
4- Aggiungere controlli nel costruttore per verificare la validità della data e del numero di posti totali.
5- Implementare i metodi getter e setter per consentire l'accesso ai campi dati.

6- Implementazione del metodo prenota, che aggiunge un certo numero di posti prenotati e solleva un'eccezione se l'evento è già passato o non ci sono abbastanza posti disponibili.
7- Implementazione del metodo disdici, che riduce di un certo numero i posti prenotati e solleva un'eccezione se l'evento è già passato o non ci sono abbastanza prenotazioni.
8- Override del metodo toString in modo che restituisca una stringa contenente la data formattata e il titolo dell'evento.
9- Aggiunta di eventuali metodi (public e private) che aiutino a svolgere le funzioni richieste.