import javax.swing.*;
import java.util.List;

public class Main {

    public void searchMembers() {

        String file = "Inlamningsuppgift 2 Mikael R/src/CustomerDatabase.txt";
        // Läser in alla medlemmar och sparar dem i en lista
        List<Members> members = ReadFromDb.readFromDb(file);

        String input = JOptionPane.showInputDialog(null, "Skriv in namn eller personnummer på besökaren");
        // Söker i listan och jämför input med members
        Members inputData = ReadFromDb.findMember(members, input);

        try {
        if (input == null || input.isEmpty ()) {
                JOptionPane.showMessageDialog(null, "Inmatningen är tom, försök igen.");
            } else if (inputData == null) {
                JOptionPane.showMessageDialog(null, input + " är inte medlem.");
            } else {
                if (inputData.isActiveMember()) {
                    JOptionPane.showMessageDialog(null, inputData.getName() + " är aktiv medlem");
                    LogMemberVisits.logVisits(inputData);
                } else {
                    JOptionPane.showMessageDialog(null, inputData.getName() + " är inte aktiv medlem");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void main (String[]args) {

            Main m = new Main();
            m.searchMembers();
    }
}





