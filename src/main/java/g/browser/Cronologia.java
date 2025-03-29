package g.browser;

import java.util.ArrayList;

public class Cronologia {

    private ArrayList<String> elenco = new ArrayList<String>();
    private int indiceCronologia = -1;
    private int dimensioneCronologia = 0;

    public boolean isVuota() {
        return elenco.isEmpty();
    }

    public boolean haUnSuccessore() {
        return (indiceCronologia < (dimensioneCronologia-1));
    }
    
    public boolean haUnPrecedessore() {
        return (indiceCronologia > 0 );
    }
    
    public String tornaIndietro() {
        if (!haUnPrecedessore() ) throw new RuntimeException(" la cronologia non ha un predecessore!! Usa if crono.haUnpredecessore() prima di usare questo metodo!! ");
        indiceCronologia--;
        String urlString = elenco.get(indiceCronologia);
        
        
        return urlString;
    }
    
    public String vaiAvanti() {
        
        if (!haUnSuccessore()) throw new RuntimeException(" la cronologia non ha un successore!! Usa if crono.haUnSuccessore() prima di usare questo metodo!! ");
       
        indiceCronologia ++;
        String urlString = elenco.get(indiceCronologia); 
        return urlString;
    }

    public void aggiungiInCronologia(String urlString) {

        indiceCronologia++;
        dimensioneCronologia = indiceCronologia + 1;

        if (indiceCronologia == elenco.size()) {

            elenco.add(urlString);  

        } else {
            elenco.set(indiceCronologia, urlString);
        }

    }




    public void dump() {

        String appo = "Cronologia: \n";
        int i = -1;
        appo += i + " " + (i == indiceCronologia ? "=>" : "  ") +"\n";

        for (i = 0; i < elenco.size(); i++) {
            appo += i + " " + (i == indiceCronologia ? "=>" : "  ")
                    + elenco.get(i)
                    + (i == dimensioneCronologia ? "<= dimensione cronologia " : "                         ")
                    + (i == elenco.size() ? "<= elenco.size()" : "                ")
                    + " \n";
        }

        i = elenco.size();
        appo += i + " " + (i == indiceCronologia ? "=>" : "  ")
                + "            "
                + (i == dimensioneCronologia ? "<= dimensione cronologia " : "                         ")
                + (i == elenco.size() ? "<= elenco.size()" : "                ")
                + " \n";
        
        
        if (isVuota()) {
            appo += " non ci sono precedessori e scuccessori ";
        } else { String sito = elenco.get(indiceCronologia);
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
