import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadFromDb {

    public static List<Members> readFromDb(String filePathString) {

        List<Members> members = new ArrayList<>();
        Path filePath = Paths.get(filePathString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String personalInfo;
            while ((personalInfo = br.readLine()) != null) {
                String[] data = personalInfo.split(", ");

                String personNumber = data[0];
                String name = data[1];

                String date = br.readLine();
                LocalDate memberSince = LocalDate.parse(date, formatter);

                members.add(new Members(personNumber, name, memberSince));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }
    public static Members findMember (List <Members> members, String input){

        for (Members member : members) {
            if (member.getPersonNumber().equals(input) || member.getName().equalsIgnoreCase(input)) {
                return member;
            }
        }
        return null;
    }
}






