import com.bridgelabz.exception.AddressBookException;
import com.bridgelabz.model.Person;
import com.bridgelabz.service.AddressBookMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

    // Object reference
    AddressBookMain main;

    // constant variable
    private final String FILE_PATH = "F:\\bridgelabze\\addressBook\\addressBook\\myfile.json";
    public final String CREATE_FILE = "addressBook";
    public final String ADD_RECORD = "addRecord";

    @Before
    public void setUp() {
        main = new AddressBookMain();
    }

    @Test
    public void givenFilePath_WhenCreateNewFile_ThenReturnSuccessMessage() throws AddressBookException {
        String result = main.addressBook(new Person(), FILE_PATH, CREATE_FILE);
        Assert.assertEquals("File Created Successfully", result);
    }

    @Test
    public void givenFilePath_WhenAddPersonRecord_ThenReturnSuccessMessage() throws AddressBookException {
        String result = main.addressBook(new Person("vivek", "karad", "shirur", "maharashtra", "431128"), FILE_PATH, ADD_RECORD);
        Assert.assertEquals("Add Records Successfully", result);
    }
}
