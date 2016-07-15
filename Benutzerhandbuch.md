Einleitung:

Das eigentliche Lehrziel des Programms, ist es einen Ueberblick in die Testgetriebene Entwicklung zu bekommen.
Dazu  wird folgendes Schema verwendet:

1. Einen Test schreiben
  - Dieser soll fehlschlagen
2. Wenn die Bedingung erfuellt ist muss Code geschrieben werden der den Test gelingen laesst.
3. Wenn der Code kompiliert und der Test durchlaeuft kann man in der REFACTOR-Phase seinen
   geschriebenen Code verbessern.
4. Der naechste Test soll geschrieben werden
5. Diese Reihenfolge wiederholt sich daraufhin

Fuer den Benutzer:

Um sich eine Uebung auszusuchen, navigieren Sie auf den Menuereiter File -> Catalog und waehlen Sie die 
gewuenschte Aufgabe aus.

Nun haben Sie Zeit sich die Aufgabe anzuschauen.

In den beiden vorliegenden Textfeldern sollte nun ein Programmgeruest erschienen sein.
Ihre erste Aufgabe wird sein einen fehlschlagenden Test zu schreiben.

Wenn Sie dies getan haben koennen sie den Knopf "check" betaetigen.
Ihr Test wird kompiliert und getestet.
Falls es einen fehlschlagenden Test gibt, koennen Sie den Knopf "next" benutzen.
Dieser Ueberprueft nochmals die Bedingung, dass ein Test fehlschlaegt und leitet Sie
zur Codephase ueber.

Falls bei der Aufgabe die Erweiterung "Babysteps" aktiviert ist, ist Ihnen in den darauffolgenden
Phasen ein Zeitlimit gesetzt.
Wenn das Zeitlimit abgelaufen ist, werden Ihre Aenderungen der aktuellen Phase geloescht und Sie werden
in die vorherige Phase zurueckversetzt.
Sie koennen jedoch nicht mehr als eine Phase zurueckfallen.

In der Codephase muessen Sie nun den Code zu Ihrem Test schreiben.
Mit Hilfe des Knopfes "check" koennen Sie Ueberpruefen ob ihr Programm kompiliert und Ihr Test
durchlaeuft.
Falls dies der Fall ist (Ihr Programm kompiliert und alle Tests laufen durch) kommen
Sie zur REFACTOR-Phase.
Nun haben Sie die Moeglichkeit ihr Programm zu verbessern.
Unten links im Programmfenster sehen Sie einen Knopf "run", dieser kann betaetigt werden um Ihr Programm zu starten.
Wenn Sie Argumente Uebergeben wollen koennen Sie dies in dem dafuer vorgesehenen Textfeld tun.

Der Knopf "next" leitet im folgenden die naechste Test-Phase ein.

Falls Sie explizit waehrend des Programmiervorgangs speichern wollen kÃoennen Sie dies tun, indem Sie
auf den Menuereiter File -> SaveCode oder SaveTest navigieren.
Den letzten speicherstand koennen Sie per File -> Load abrufen, beachten Sie jedoch, dass nach einem "next" oder "check"
Knopfdruck das Programm automatisch gespeichert wird.

Fuer die Uebungsleiter:

Um eine neue Uebungsaufgabe zu kreieren, legen Sie im Ordner "Task" einen neuen Ordner mit dem Uebungsnamen an.
Dieser muss drei Dateien enthalten:

1. Eine Code-Datei (.java)
2. Eine Test-Datei (.java)
3. Eine config-Datei (.txt)

Solang ihre Code.java und Test.java kompilieren koennen Sie ein beliebiges Programmgeruest erstellen.

Wichtig ist das Layout der config-Datei.
Hier ein Beispiel:

config.txt

Inhalt:                                                                                                                               
ProgramName: Code                                                                                                                    
TestName: Try                                                                                                                         
Babysteps: true                                                                                                                       
Babystep Duration: 180000

Beachten Sie, dass keine Leerzeichen am Ende jeder Zeile stehen und, dass "ProgramName: xxxx" in
der ersten Zeile stehen muessen.
"ProgramName: xxxx" muss den Namen ihrer Code-Datei zugewiesen bekommen (ohne .java).
"TestName: xxxx" muss den Namen ihrer Test-Datei zugewiesen bekommen (ohne .java).
"Babysteps: xxxx" ist "true" oder "false" je nachdem ob die Erweiterung aktiviert sein soll.
"Babystep Duration: xxxxx" gibt an wie lange eine Phase dauern darf (in Milisekunden).
