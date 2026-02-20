# Calculador de Notes

Aplicació Java amb interfície gràfica (Swing) per gestionar i calcular les notes d'un estudiant.

Desenvolupada com a activitat de treball col·laboratiu amb **branques Git i Pull Requests** al CIDE.

---

## Funcionalitats

### Afegir Nota
Permet introduir notes per assignatura mitjançant un formulari amb:
- Selector d'assignatura (Matemàtiques, Castellà, Anglès, Català)
- Camp de text per la nota (0–10)
- Validació d'entrada (camps buits, valors fora de rang, text no numèric)

### Calcular Mitjana
Calcula i mostra en una nova finestra:
- Mitjana per cada assignatura
- Mitjana global de totes les notes
- Resultat final: **APROVAT** (≥ 5) o **SUSPÈS** (< 5)

### Mostrar Resultat
Finestra auxiliar per visualitzar el resultat de l'estudiant.

---

## Captures de pantalla

```
┌─────────────────────────────────────────────────────────┐
│  Calculador de Notes - Afegir Nota                      │
├─────────────────────────────────────────────────────────┤
│  Asignatura: [ Matemàtiques ▼ ]  Nota: [____]          │
│  [ Afegir Nota ]  [ Calcular Mitjana ]                  │
└─────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────┐
│  Calcular Mitjana                                       │
├─────────────────────────────────────────────────────────┤
│  Matemàtiques (2 notes): Mitjana = 7.50                 │
│  Anglès (1 notes): Mitjana = 6.00                       │
│  ─────────────────────────────────                      │
│  Mitjana Global: 7.00                                   │
│  APROVAT ✓                                              │
└─────────────────────────────────────────────────────────┘
```

---

## Estructura del projecte

```
calculador-notes/
├── src/
│   ├── Main.java              # Punt d'entrada de l'aplicació
│   ├── AfegirNota.java        # Formulari per afegir notes
│   ├── CalcularMitjana.java   # Càlcul i visualització de mitjanes
│   └── MostrarResultat.java   # Finestra de resultat
├── lib/                       # Dependències externes
├── bin/                       # Fitxers compilats
├── pom.xml
└── README.md
```

---

## Com executar

### Requisits
- Java JDK 11 o superior

### Des de terminal
```bash
cd src
javac Main.java AfegirNota.java CalcularMitjana.java MostrarResultat.java
java Main
```

### Des de VS Code
1. Obrir el projecte
2. Fer clic a **Run | Debug** sobre el `main` de `Main.java`

---

## Flux de treball Git

El projecte s'ha desenvolupat seguint un workflow de branques:

| Branca             | Funcionalitat                              | Responsable |
|--------------------|--------------------------------------------|-------------|
| `afegir-nota`      | Formulari per afegir notes                 | Alumne 1    |
| `calcular-mitjana` | Càlcul de la mitjana per assignatura       | Alumne 2    |
| `mostrar-resultat` | Visualització del resultat aprovat/suspès  | Alumne 3    |

### Procés seguit
1. Creació del repositori i branca `main` amb el codi inicial
2. Cada membre ha creat la seva branca: `git checkout -b <nom-branca>`
3. Desenvolupament i commits a cada branca
4. Pull Request a GitHub per fusionar cada branca amb `main`
5. Revisió de codi i resolució de conflictes

---

## Tecnologies

- **Java 11+**
- **Swing** — Interfície gràfica
- **Git & GitHub** — Control de versions i col·laboració

---

## Autors

@ByGamer01 & @shacortes ; David & Sergi
