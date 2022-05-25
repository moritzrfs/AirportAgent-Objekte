# AirportAgent-Objekte <!-- omit in toc -->
Dies ist das Repo der Objekt-Gruppe des Airport Simulation Projekts :airplane: .

# Inhaltsverzeichnis <!-- omit in toc -->
- [Projekt-Oragnisation](#projekt-oragnisation)
  - [Rolleneinteilung](#rolleneinteilung)
- [Software Dokumentation](#software-dokumentation)

---
# Projekt-Oragnisation
Das gesamte Product-Backlog mit den dazugehörigen Epics, User-Stories und Sprints der Objekt-Gruppe befindet sich in [JIRA](https://airportagent-objekte.atlassian.net/jira/software/projects/AO/boards/1). 
## Rolleneinteilung
**Ansprechpersonen**:
- Simulationsgruppe
- Agentengruppe
- Dozent
  
**Präsentation**:
- Vorgehen
- Ergebnisse

**Programmieren**:
- Plugin
- Objekte:
  - Wände
  - Ticketschalter
  - Sicherheitsschleuse
  - Gepächabgabe

# Software Dokumentation
Unsere Lösung basiert auf einem Java Projekt welches als Plugin in der Architektur der [Simulations-Gruppe](https://github.com/Vincent200355/AirportAgentSimulation-Base) ausgeführt werden kann. Das entsprechende Plugin implementiert demnach die benötigte Schnittstelle `dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin`. <br>
Aufgrund der [User Stories](https://airportagent-objekte.atlassian.net/jira/software/projects/AO/boards/1) wurden folgende Objekte implementiert:  
1. Wände
2. Ticketschalter
3. Sicherheitsschleuse
4. Gepächabgabe
