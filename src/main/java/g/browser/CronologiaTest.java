package g.browser;

public class CronologiaTest {

    public static void main(String[] args) {

        Cronologia crono = new Cronologia();
        crono.dump();
        crono.aggiungiInCronologia("0.html");
        crono.aggiungiInCronologia("1.html");
        crono.aggiungiInCronologia("2.html");
        crono.aggiungiInCronologia("3.html");
        crono.aggiungiInCronologia("4.html");
        crono.aggiungiInCronologia("5.html");
        crono.dump();

        String appo = crono.tornaIndietro();  //Si dovrebbe usare con il controllo if corno.haUnPrecedessore 
        System.out.println("torno indietro e visualizzo " + appo);
        crono.dump();

        appo = crono.tornaIndietro();
        System.out.println("torno indietro e visualizzo " + appo);
        crono.dump();
        
        
        if (crono.haUnSuccessore()) {
            appo = crono.vaiAvanti();
            System.out.println("vado avanti e visualizzo " + appo);
            crono.dump();

        }
        
        appo = crono.tornaIndietro();
        System.out.println("torno indietro e visualizzo " + appo);
        crono.dump();



        crono.aggiungiInCronologia("10.html");
        System.out.println("visito una nuova pagina 10.html");
        crono.dump();

        crono.aggiungiInCronologia("11.html");
        System.out.println("visito una nuova pagina 11.html");
        crono.dump();

        crono.aggiungiInCronologia("12.html");
        System.out.println("visito una nuova pagina 12.html");
        crono.dump();
        
        
        System.out.println("torno indietro 6 volte**********************");
        appo = crono.tornaIndietro();
        appo = crono.tornaIndietro();
        appo = crono.tornaIndietro();
        appo = crono.tornaIndietro();
        appo = crono.tornaIndietro();
        appo = crono.tornaIndietro();
       
        crono.dump();
        
        
        if (crono.haUnPrecedessore()) {
            appo = crono.tornaIndietro();
            
        }

    }

}
