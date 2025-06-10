// Cucu Fabio 4F Fila B

import BackEnd.*;
import Utility.Tools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] opzioni = {"Agenzia immobiliare", "Inserimento immobili", "Visualizzazione immobili", "Ricerca Immobile", "Vendita Immobile", "Fine"};
        String[] sceltaImmobile = {"OPZIONI", "Box", "Appartamento", "Villa"};
        String[] sceltaRicerca = {"OPZIONI", "Tipo", "Città", "Superficie Minima"};
        int cap, superficie, nPostiAuto, nBagni, nVani, superficieGiardino;
        boolean menu = true, controlloInserimento, menuSceltaImmobile;
        String codiceAlfanumerico, indirizzo, citta, str;
        Scanner sc = new Scanner( System.in );
        Agenzia agenzia = new Agenzia();

        do {
            switch (Tools.Menu( opzioni, sc )) {
                case 1 -> {
                    menuSceltaImmobile = true;
                    System.out.println( "Inserimento dati generali:" );

                    do {
                        System.out.println( "Inserire codice alfanumerico dell'immobile da inserire" );
                        codiceAlfanumerico = sc.nextLine();

                        controlloInserimento = !codiceAlfanumerico.isEmpty(); //Controllo che il dato inserito sia accettabile

                    } while (!controlloInserimento);

                    try { // Solleverà un'eccezione se il codice alfanumerico è lo stesso di uno precedentemente inserito
                        agenzia.checkEsistenza( codiceAlfanumerico );

                        do {
                            System.out.println( "Inserire indirizzo dell'immobile" );
                            indirizzo = sc.nextLine();

                            controlloInserimento = indirizzo.isEmpty(); //Controllo che il dato inserito sia accettabile

                        } while (controlloInserimento);

                        do {
                            System.out.println( "Inserire CAP dell'immobile" );
                            cap = Integer.parseInt( sc.nextLine() );

                            controlloInserimento = (cap <= 0); //Controllo che il dato inserito sia accettabile

                        } while (controlloInserimento);

                        do {
                            System.out.println( "Inserire città dell'immobile" );
                            citta = sc.nextLine();

                            controlloInserimento = citta.isEmpty(); //Controllo che il dato inserito sia accettabile

                        } while (controlloInserimento);

                        do {
                            System.out.println( "Inserire superficie dell'immobile" );
                            superficie = Integer.parseInt( sc.nextLine() );

                            controlloInserimento = (superficie <= 0); //Controllo che il dato inserito sia accettabile

                        } while (controlloInserimento);

                        System.out.println( "Selezione il tipo di immobile specifico:" );

                        do {
                            switch (Tools.Menu( sceltaImmobile, sc )) {
                                case 1 -> {
                                    do {
                                        System.out.println( "Inserire numeri posti auto della box" );
                                        nPostiAuto = Integer.parseInt( sc.nextLine() );

                                        controlloInserimento = (nPostiAuto <= 0); //Controllo che il dato inserito sia accettabile

                                    } while (controlloInserimento);

                                    Immobile b = new Box( codiceAlfanumerico, indirizzo, citta, superficie, cap, nPostiAuto );

                                    agenzia.addImmobile( b );
                                    menuSceltaImmobile = false;
                                }
                                case 2 -> {
                                    do {
                                        System.out.println( "Inserire numeri vani dell'appartamento" );
                                        nVani = Integer.parseInt( sc.nextLine() );

                                        controlloInserimento = (nVani <= 0); //Controllo che il dato inserito sia accettabile

                                    } while (controlloInserimento);

                                    do {
                                        System.out.println( "Inserire numeri bagni dell'appartamento" );
                                        nBagni = Integer.parseInt( sc.nextLine() );

                                        controlloInserimento = (nBagni <= 0); //Controllo che il dato inserito sia accettabile

                                    } while (controlloInserimento);

                                    Immobile a = new Appartamenti( codiceAlfanumerico, indirizzo, citta, superficie, cap, nVani, nBagni );

                                    agenzia.addImmobile( a );
                                    menuSceltaImmobile = false;
                                }
                                case 3 -> {
                                    do {
                                        System.out.println( "Inserire superficie del giardino della villa" );
                                        superficieGiardino = Integer.parseInt( sc.nextLine() );

                                        controlloInserimento = (superficieGiardino <= 0); //Controllo che il dato inserito sia accettabile

                                    } while (controlloInserimento);

                                    Immobile v = new Ville( codiceAlfanumerico, indirizzo, citta, superficie, cap, superficieGiardino );

                                    agenzia.addImmobile( v );
                                    menuSceltaImmobile = false;
                                }
                                default -> System.out.println( "Opzione non valida" );
                            }
                        } while (menuSceltaImmobile);


                    } catch (Exception e) {
                        System.out.println( e.getMessage() );
                    }
                }
                case 2 -> {
                    System.out.println( "Visualizzazione" );
                    if (!agenzia.getListaImmobile().isEmpty()) {
                        agenzia.visualizza();
                    } else {
                        System.out.println( "Non è stato inserito nemmeno un immobile" );
                    }
                }
                case 3 -> {
                    System.out.println( "Ricerca" );
                    if (!agenzia.getListaImmobile().isEmpty()) {
                        System.out.println( "Selezione il tipo di ricerca da eseguire:" );

                        switch (Tools.Menu( sceltaRicerca, sc ))
                        {
                            case 1 -> {

                            }

                            case 2 -> {
                                System.out.println("Inserisci la città da ricercare");
                                str = sc.nextLine();
                                agenzia.ricerca( "città", str );
                            }
                            
                        }
                    } else {
                        System.out.println( "Non è stato inserito nemmeno un immobile" );
                    }
                }
                case 4 -> {
                    System.out.println( "Vendita" );
                    if (!agenzia.getListaImmobile().isEmpty()) {
                        agenzia.visualizza();
                    } else {
                        System.out.println( "Non è stato inserito nemmeno un immobile" );
                    }
                }
                case 5 -> {
                    menu = false;
                }
                default -> System.out.println( "Opzione non accettabile, riprova." );
            }

            Tools.clrScr();

        } while (menu);
    }
}