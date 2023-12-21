package api.utilities.mernisadapters;

import java.sql.Date;

public interface UserCheckService {

    boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, Date date);
}
