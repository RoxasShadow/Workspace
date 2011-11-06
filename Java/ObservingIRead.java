/**
	ObservingIRead.java
	(C) Giovanni Capuano 2011
*/
import java.util.Observable; // Include la classe Observable, che individua il soggetto da osservare.
import java.util.Observer; // Include l'interfaccia Observer, che dà vita all'osservatore.
import java.io.*;
import java.net.URL;

/* Dichiara i vari stati che l'osservato può assumere. */
class ObserverState {
	public final static int START = 0; // Costanti di stato.
	public final static int READY = 1;
	public final static int READLINE = 2;
	public final static int DONE = 3;
	public final static int EXCEPTION = 4;
	public int code; // Codice che individua la costante di stato del soggetto.
	public Object msg; // (Super)oggetto di un eventuale input da parte del soggetto.
	public ObserverState(int code, Object msg) {
		this.code = code;
		this.msg = msg;
	}
}

/*
La classe osservata (soggetto) legge il file dato come argomento e ad ogni stato notifica il cambiamento tramite una costante definita dalla precedente classe.
Estende la classe Observable.
*/
class Reader extends Observable {
	public void readFile(String path) {
		changedState(new ObserverState(ObserverState.START, null)); // L'applicazione sta per partire.
		try {
			StringBuffer buffer = new StringBuffer("");
			File file = new File(path);
			URL filePath = file.toURI().toURL();
			BufferedReader reader = new BufferedReader(new InputStreamReader(filePath.openStream()));
			String line;
			changedState(new ObserverState(ObserverState.READY, null)); // L'applicazione è pronta.
			while((line = reader.readLine()) != null) {
				buffer.append(line);
				changedState(new ObserverState(ObserverState.READLINE, line)); // La riga è stata letta e la lascia all'osservatore.
			}
			reader.close();
			changedState(new ObserverState(ObserverState.DONE, null)); // L'applicazione è terminata.
		}
		catch(IOException e) {
			changedState(new ObserverState(ObserverState.EXCEPTION, e)); // Eccezione invocata, segnala l'avvento e lo lascia all'osservatore.
		}
	}
	
	/* Metodo che provvede a segnalare all'osservatore il cambiamento di stato del soggetto. */
	private void changedState(ObserverState msg) {
		setChanged(); // Segnala all'osservatore riguardo il cambiamento di stato.
		notifyObservers(msg); // Notifica l'osservatore inviandogli lo stato assunto dal soggetto.
	}
}

/*
L'osservatore che si occupa di stampare gli stati assunti dal soggetto.
Implementa l'interfaccia Observer.
*/
class ObserverStateMan implements Observer {
	/* Questo metodo viene invocato ad ogni notifica e agisce in conseguenza al cambiamento di stato. */
	public void update(Observable o, Object arg) {
		ObserverState message = (ObserverState)arg; // L'istanza classe che definisce gli stati.
 		if(message.code == ObserverState.START) // Se lo stato assunto dal soggetto corrisponde a questo determinato status del soggetto...
			System.out.println("Inizializzazione..."); // ...nvoca qualche metodo o esegue una procedura.
		else if(message.code == ObserverState.READY)
			System.out.println("Pronto.");
		else if(message.code == ObserverState.DONE)
			System.out.println("Fatto.");
	}
}

/*
Come l'osservatore precedente ma stampa i messaggi dati in input dal soggetto.
(Sarebbe stato possibile inglobare  il tutto nell'osservatore precedente, ma in questo modo è possibile mostrare l'uso di diversi osservatori.
L'uso dell'operatore instanceof è opzionale, ma il suo uso ci consente di controllare se l'input corrisponde ad una determinata classe, dal momento che msg è di tipo Object, e quindi "padre" di tutte le classi.
*/
class ObserverStatePrinter implements Observer {
	public void update(Observable o, Object arg) {
		ObserverState message = (ObserverState)arg;
 		if(message.code == ObserverState.READLINE) {
 			if(message.msg instanceof String) {
				System.out.println("Readed line: "+message.msg);
			}
		}
 		else if(message.code == ObserverState.EXCEPTION)
 			if(message.msg instanceof Exception)
				System.out.println("Exception: "+message.msg);
	}
}

/*
La classe principale che concretizza le classi precedenti.
Non fa altro che istanziare il soggetto e assegnargli gli osservatori.
*/
public class ObservingIRead {
	public ObservingIRead() {
		Reader reader = new Reader(); // Istanziamo l'oggetto...
		reader.addObserver(new ObserverStateMan()); // ...colleghiamo gli osservatori...
		reader.addObserver(new ObserverStatePrinter());
		reader.readFile("ObservingIRead.java"); // ...e lo facciamo partire prima con un file esistente (ovvero questo :)...
		System.out.println("----------------------------------------");
		reader.readFile("ObservingIRead.fail"); // ...e poi con un file non esistente, generando quindi un'eccezione.
	}
	
	public static void main(String[] args) {
		new ObservingIRead();
	}
}
