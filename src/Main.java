import javax.swing.*;
import java.util.List;

public class Main {

    public void searchMembers() {

        String file = "src/CustomerDatabase.txt";

        List<Members> members = ReadFromDb.readFromDb(file);

        String input = JOptionPane.showInputDialog(null, "Skriv in namn eller personnummer på besökaren");

        Members inputData = ReadFromDb.findMember(members, input);

        try {
        if (input.isEmpty()) {
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





