package utils;

import com.telran.contacts.models.Contact;
import com.telran.contacts.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/UserDataContacts.csv")));

        String line = reader.readLine();
        while(line !=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setTel(split[2]).setEmail(split[3]).setCity(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();

        //    @DataProvider
//    public Iterator<Object[]> addNewContact() {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Oliver","Kan","12345678987","kan@gm.com","Berlin","goalkiper"});
//        list.add(new Object[]{"Oliver","Kan","1234567123","kan+1@gm.com","Berlin","goalkiper"});
//        list.add(new Object[]{"Oliver","Kan","1234567321","kan+2@gm.com","Berlin","goalkiper"});
//        return list.iterator();
//    }
    }
    @DataProvider
    public Iterator<Object[]> RegistrationNegativeTestFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/UserDataContacts1.csv")));

        String line = reader.readLine();
        while(line !=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
