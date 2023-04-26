import java.io.*;
import java.util.*;
import org.json.*;

public class Fichier {

    public static void main(String[] args) {
        
        try {
            FileWriter fichier = new FileWriter("fichier.txt");
            fichier.write("Ceci est un fichier texte vierge.");
            fichier.close();
            System.out.println("Le fichier texte a été créé.");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la création du fichier texte.");
            e.printStackTrace();
        }
        
        
        try {
            FileWriter fichier = new FileWriter("fichier.txt", true);
            fichier.write("\nCeci est une ligne ajoutée au fichier texte existant.");
            fichier.close();
            System.out.println("Le fichier texte a été modifié.");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la modification du fichier texte.");
            e.printStackTrace();
        }
        
     
        try {
            File fichier = new File("fichier.txt");
            Scanner scanner = new Scanner(fichier);
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                System.out.println(ligne);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier texte n'a pas été trouvé.");
            e.printStackTrace();
        }
        
    
        JSONArray contacts = new JSONArray();
        JSONObject contact1 = new JSONObject();
        contact1.put("id", 1);
        contact1.put("nom", "GRILLY");
        contact1.put("prenom", "Jordan");
        contact1.put("age", 45);
        contact1.put("mail", "j.grilly@ynov.com");
        contacts.put(contact1);
        JSONObject contact2 = new JSONObject();
        contact2.put("id", 2);
        contact2.put("nom", "DUPONT");
        contact2.put("prenom", "Jean");
        contact2.put("age", 30);
        contact2.put("mail", "j.dupont@gmail.com");
        contacts.put(contact2);
        
        try {
            FileWriter fichier = new FileWriter("fichier.json");
            fichier.write(contacts.toString());
            fichier.close();
            System.out.println("Le fichier JSON a été créé.");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la création du fichier JSON.");
            e.printStackTrace();
        }
        
        try {
            File fichier = new File("fichier.json");
            Scanner scanner = new Scanner(fichier);
            String contenu = "";
            while (scanner.hasNextLine()) {
                contenu += scanner.nextLine();
            }
            scanner.close();
            JSONArray contactsJSON = new JSONArray(contenu);
            for (int i = 0; i < contactsJSON.length(); i++) {
                JSONObject contact = contactsJSON.getJSONObject(i);
                if (contact.getString("nom").equals("GRILLY")) {
                    System.out.println("Nom : " + contact.getString("nom"));
                    System.out.println("Prénom : " + contact.getString("prenom"));
                    System.out.println("Âge : " + contact.getInt("age"));
                    System.out.println("Adresse e-mail : " + contact.getString("mail"));
                }
            }
        } catch (FileNotFoundException e) {
          System.out.println("Le fichier JSON n'a pas été trouvé.");
          e.printStackTrace();
          } catch (JSONException e) {
          System.out.println("Une erreur est survenue lors de la lecture du fichier JSON.");
          e.printStackTrace();
          }
    }
}
