package g.browser;


public class Cronologia {

    private String[]  elenco = new String [100];
    
    private int dimensioneCronologia = 0; //Mi serve sapere quanti dei 100
                                          // sto effettivamente usando
    
    private int indiceCronologia = -1 ; //all'inizio è vuota 
                                        //inizializzo = -1 
                                        // perché 0 è un indice valido
                                        // maledetti info! contano da zero!!
    
    public boolean isVuota() {
        return (dimensioneCronologia == 0 ) ;
    }

    public boolean haUnSuccessore() {
        return (indiceCronologia < (dimensioneCronologia-1));
    }
    public String vaiAvanti() {
        indiceCronologia ++;
        String urlString = elenco[indiceCronologia]; 
        return urlString;
    }

    public boolean haUnPrecedessore() {
        return (indiceCronologia > 0 );
    }
    public String tornaIndietro() {
        indiceCronologia--;
        String urlString = elenco[indiceCronologia];
        return urlString;
    }
        
    public void aggiungiInCronologia(String urlString) {

        indiceCronologia++;
        dimensioneCronologia = indiceCronologia + 1;
        elenco[indiceCronologia]=urlString;
    }

    public void dump() {

        String appo = "Cronologia: \n";
        int i = -1;
        appo += i + " " + (i == indiceCronologia ? "=>" : "  ") +"\n";

        for (i = 0; i < dimensioneCronologia; i++) {
            appo += i + " " + (i == indiceCronologia ? "=>" : "  ")
                    + elenco[i]
                    + (i == dimensioneCronologia ? "<= dimensione cronologia " : "                         ")
                    + " \n";
        }

        i = dimensioneCronologia;
        appo += i + " " + (i == indiceCronologia ? "=>" : "  ")
                + "            "
                + (i == dimensioneCronologia ? "<= dimensione cronologia " : "                         ")
                + " \n";
        
        
        if (isVuota()) {
            appo += " non ci sono precedessori e scuccessori ";
        } else { String sito = elenco[indiceCronologia];
            if (haUnSuccessore()) {
               
                appo += "\n" + sito + "     ha un successore ";
            } else {
              
                appo += "\n" + sito + " NON  ha un successore";
            }

            if (haUnPrecedessore()) {
                
                appo += "\n" + sito + "      ha un precedessore \n";
            } else {
                
                appo += "\n" + sito + " NON  ha un precedessore \n";
            }
        }

        System.out.println( appo);
    }


    
    
    
    
    
}
