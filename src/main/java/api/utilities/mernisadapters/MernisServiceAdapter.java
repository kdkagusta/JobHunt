package api.utilities.mernisadapters;

import java.sql.Date;

import api.utilities.fakeMernisService.MernisService;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserCheckService {

    @Override
    public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, Date date) {

        MernisService client = new MernisService();
        boolean result = client.TCKimlikDogrula(nationalityId, firstName, lastName, date);
        return result;
    }
}
