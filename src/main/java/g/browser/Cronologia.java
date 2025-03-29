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
        return (indiceCronologia < (dimensioneCronologia - 1));
    }

    public boolean haUnPrecedessore() {
        return (indiceCronologia > 0);
    }

    public String tornaIndietro() {
        if (!haUnPrecedessore()) {
            throw new RuntimeException(" la cronologia non ha un predecessore!! Usa if crono.haUnpredecessore() prima di usare questo metodo!! ");
        }
        indiceCronologia--;
        String urlString = elenco.get(indiceCronologia);

        return urlString;
    }

    public String vaiAvanti() {

        if (!haUnSuccessore()) {
            throw new RuntimeException(" la cronologia non ha un successore!! Usa if crono.haUnSuccessore() prima di usare questo metodo!! ");
        }

        indiceCronologia++;
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

    public String dump() {

        String appo = "Cronologia: \n";

        if (isVuota()) {
            appo += "  è vuota \n\n"
                    + "-1 <- indice Cronologia \n"
                    + "0 <- dimensione cronologia\n\n"
                    + "NON  ha un precedessore  NON  ha un successore\n";
            System.out.println(appo);
            return appo;
        }

        int i;
        for (i = 0; i < elenco.size(); i++) {
            appo += i + " "
                    + elenco.get(i)
                    + (i == indiceCronologia ? " <- idnice cronologia " : "")
                    + (i == dimensioneCronologia ? "<- dimensione cronologia " : "")
                    + " \n";
        }

        i = elenco.size();
        appo += i + " "
                + "         "
                + (i == indiceCronologia ? " <- idnice cronologia " : "") //non dovrebbe accadere ....
                + (i == dimensioneCronologia ? "<- dimensione cronologia " : "")
                + " \n";

        appo += "\n";
        if (haUnPrecedessore()) {

            appo += "      ha un precedessore ";
        } else {

            appo += " NON  ha un precedessore ";
        }
        if (haUnSuccessore()) {
            appo += "      ha un successore\n ";
        } else {

            appo += " NON  ha un successore\n";
        }

        System.out.println(appo);
        return appo;
    }

}
