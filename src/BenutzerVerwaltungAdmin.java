import java.util.ArrayList;
public class BenutzerVerwaltungAdmin extends Benutzer implements BenutzerVerwaltung {
   static ArrayList<Benutzer> Datenhaltung = new ArrayList<Benutzer>();

   BenutzerVerwaltungAdmin(String id, char[] pw){
       super(id,pw);
   }

   public void benutzerEintragen(Benutzer benutzer){
       try{
           if(benutzerVorhanden(benutzer)){
               throw new ParameterDuplikat("Parameter ist vorhanden! Bitte eintragen einen neuen Benutzer");
           }
           Datenhaltung.add(benutzer);
       }
       catch(ParameterDuplikat e){
           e.printStackTrace();
       }
   }

   protected void benutzerLoeschen(Benutzer benutzer){
       try{
           if(Datenhaltung.isEmpty()){
               throw new NullPointerException("Datenhaltung ist leer!");
           }
           else if(!benutzerVorhanden(benutzer)){
               throw new NullPointerException("Benutzer ist nicht vorhanden! Kann nicht loeschen!");
           }
           Datenhaltung.remove(benutzer);
       }
       catch(NullPointerException e){
           e.printStackTrace();
       }
   }

   public boolean benutzerVorhanden(Benutzer benutzer){
        boolean vorhanden = false;
        for(int i = 0; i < Datenhaltung.size(); i++){
            if(benutzer.equals(Datenhaltung.get(i))){
                vorhanden = true;
                break;
            }
        }
        return vorhanden;
   }
}
