import java.time.LocalDate;
import java.time.Period;

public class Members {

    private String personNumber;
    private String name;
    private LocalDate memberSince;

    public Members(String personNumber, String name, LocalDate memberSince) {
        this.personNumber = personNumber;
        this.name = name;
        this.memberSince = memberSince;
    }

    public boolean isActiveMember(){
        LocalDate now = LocalDate.now();
        Period period = Period.between(memberSince, now);

        return period.getYears() < 1;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getName() {
        return name;
    }
}


