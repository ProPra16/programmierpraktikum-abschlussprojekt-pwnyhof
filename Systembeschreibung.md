Systembeschreibung:

Welche Klassen gibt es?
 - ConfigReader
 - Console
 - Information
 - MainScreenController 
 - Program
 - TDDTStart +
 - Timer
 - Tracking
 - TrackingScreenController
 
 Desweiteren gibt es noch 2 .fxml Dokumente
 - TextScreen
 - TrackingScreen
 in welchen sich das jeweilige Layout für das Hauptfenster bzw. das Trackingfenster
 befindet.
 
 Interaktion der Klassen untereinander:
 
 TDDTStart:
 Zunaechst wird durch das Ausfuehren der Klasse TDDTStart das Layout des Programms
 aus der Datei TextScreen.fxml geladen, danach wird darauf basierend eine neue Scene
 erstellt und zusammen mit dem Fenstertitel der Stage hinzugefuegt, bevor diese dann
 gezeigt wird.
 
 MainScreenController:
 Der MainScreenController weist den GUI Elementen (Menue, Buttons, TextAreas und
 TextField) Variablen zu um diese spaeter in den Methoden nutzen zu können.
 	Methoden:
 	public void handleMenuItem(ActionEvent e)
 		Hier wird erst mit Hilfe der Klasse Console aus der vorher zugewiesenen TextArea
 		console ein Outputstream initiiert, um eine Terminal-Ausgabe zu simulieren. Dazu
 		dient der PrintStream out, welchem der OutputStream zugewiesen wird.
 		Die ActionEvents werden wie folgt behandelt:
 	neu:
 		die linke und rechte TextArea werden geleert.
 	catalog:
 		die Moeglichkeit in der linken TextArea einen Code zu schreiben wird
 		deaktiviert, ein neuer DirectoryChooser wird mit dem Pfad ./Task/ als
 		initialDirectory initiiert und bietet die Moeglichkeit eine Aufgabe zu wählen
 		erstellt eine neue CLasse und einen neuen Test basierend auf den von in
 		ConfigReader gelesenen Daten.
 	load:
 		
 
 Timer:
 
 ConfigReader:
 
 Console:
 
 Information:
 
 Program:
 
 Tracking:
 
 TrackingScreenController:
 
 
 