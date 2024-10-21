import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LogMemberVisits {

    public static void logVisits(Members member){

        if(member.isActiveMember()) {

            LocalDate visit = LocalDate.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String memberVisit = member.getName() + " " + member.getPersonNumber() + " " + visit.format(dtf) + '\n';

            String filePathLog = "src/Visitorlog.txt";

            try (FileWriter fw = new FileWriter(filePathLog, true)) {
                fw.write(memberVisit);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
