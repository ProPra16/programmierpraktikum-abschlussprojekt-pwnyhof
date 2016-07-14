Einleitung:

Das eigentliche Lehrziel des Programms, ist es einen Überblick in die Testgetriebene Entwicklung zu bekommen.
Dazu  wird folgendes Schema verwendet:

1. Einen Test schreiben
  - Dieser soll fehlschlagen
2. Wenn die Bedingung erfüllt ist muss Code geschrieben werden der den Test gelingen lässt.
3. Wenn der Code kompiliert und der Test durchläuft kann man in der REFACTOR-Phase seinen
   geschriebenen Code verbessern.
4. Der nächste Test soll geschrieben werden
5. Diese Reihenfolge wiederholt sich daraufhin

Für den Benutzer:

Um sich eine Übung auszusuchen, navigieren Sie auf den Menüreiter File -> Catalog und wählen Sie die 
gewünschte Aufgabe aus.

Nun haben Sie Zeit sich die Aufgabe anzuschauen.

In den beiden vorliegenden Textfeldern sollte nun ein Programmgerüst erschienen sein.
Ihre erste Aufgabe wird sein einen fehlschlagenden Test zu schreiben.

Wenn Sie dies getan haben können sie den Knopf "check" betätigen.
Ihr Test wird kompiliert und getestet.
Falls es einen fehlschlagenden Test gibt, können Sie den Knopf "next" benutzen.
Dieser Überprüft nochmals die Bedingung, dass ein Test fehlschlägt und leitet Sie
zur Codephase über.

Falls bei der Aufgabe die Erweiterung "Babysteps" aktiviert ist, ist Ihnen in den darauffolgenden
Phasen ein Zeitlimit gesetzt.
Wenn das Zeitlimit abgelaufen ist, werden Ihre Änderungen der aktuellen Phase gelöscht und Sie werden
in die vorherige Phase zurückversetzt.
Sie können jedoch nicht mehr als eine Phase zurückfallen.

In der Codephase müssen Sie nun den Code zu Ihrem Test schreiben.
Mit Hilfe des Knopfes "check" können Sie überprüfen ob ihr Programm kompiliert und Ihr Test
durchläuft.
Falls dies der Fall ist (Ihr Programm kompiliert und alle Tests laufen durch) kommen
Sie zur REFACTOR-Phase.
Nun haben Sie die Möglichkeit ihr Programm zu verbessern.
Unten links im Programmfenster sehen Sie einen Knopf "run", dieser kann betätigt werden um Ihr Programm zu starten.
Wenn Sie Argumente übergeben wollen können Sie dies in dem dafür vorgesehenen Textfeld tun.

Der Knopf "next" leitet im folgenden die nächste Test-Phase ein.

Falls Sie explizit während des Programmiervorgangs speichern wollen können Sie dies tun, indem Sie
auf den Menüreiter File -> SaveCode oder SaveTest navigieren.
Den letzten speicherstand können Sie per File -> Load abrufen, beachten Sie jedoch, dass nach einem "next" oder "check"
Knopfdruck das Programm automatisch gespeichert wird.

Für die Übungsleiter:

Um eine neue Übungsaufgabe zu kreieren, legen Sie im Ordner "Task" einen neuen Ordner mit dem Übungsnamen an.
Dieser muss drei Dateien enthalten:

1. Eine Code-Datei (.java)
2. Eine Test-Datei (.java)
3. Eine config-Datei (.txt)

Solang ihre Code.java und Test.java kompilieren können Sie ein beliebiges Programmgerüst erstellen.

Wichtig ist das Layout der config-Datei.
Hier ein Beispiel:

config.txt

Inhalt:                                                                                                                               
ProgramName: Code                                                                                                                    
TestName: Try                                                                                                                         
Babysteps: true                                                                                                                       
Babystep Duration: 15000

Beachten Sie, dass keine Leerzeichen am Ende jeder Zeile stehen und, dass "ProgramName: xxxx" in
der ersten Zeile stehen müssen.
"ProgramName: xxxx" muss den Namen ihrer Code-Datei zugewiesen bekommen (ohne .java).
"TestName: xxxx" muss den Namen ihrer Test-Datei zugewiesen bekommen (ohne .java).
"Babysteps: xxxx" ist "true" oder "false" je nachdem ob die Erweiterung aktiviert sein soll.
"Babystep Duration: xxxxx" gibt an wie lange eine Phase dauern darf (in Milisekunden).
