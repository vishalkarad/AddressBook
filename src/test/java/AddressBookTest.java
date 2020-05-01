import com.bridgelabz.exception.AddressBookException;
import com.bridgelabz.model.Person;
import com.bridgelabz.service.AddressBookMain;
import com.bridgelabz.service.FileMenuOptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class AddressBookTest {

    // Object reference
    AddressBookMain main;

    // constant variable
    String FILE_PATH = "F:\\bridgelabze\\addressBook\\addressBook\\myfile1.json";
    public final String CREATE_FILE = "addressBook";
    public final String ADD_RECORD = "addRecord";
    public final String DELETE_RECORD ="deleteRecord";
    public final String SORT_LIST = "sortListByName";
    public final String SORT_ZIP = "sortListByZip";
    public final String PRINT_RECORDS = "printRecords";

    @Before
    public void setUp() {
        main = new AddressBookMain();
    }

    @Test
    public void givenFilePath_WhenCreateNewFile_ThenReturnSuccessMessage() throws AddressBookException, IOException {
        String result = main.addressBook(new Person(), FILE_PATH, CREATE_FILE);
        Assert.assertEquals("File Created Successfully", result);
    }

    @Test
    public void givenFilePath_WhenAddPersonRecord_ThenReturnSuccessMessage() throws AddressBookException, IOException {
        String result = main.addressBook( new Person("nilesh", "aghav", "shirur", "maharashtra", "431156","9763219692"),FILE_PATH, ADD_RECORD);
        Assert.assertEquals("Add Records Successfully", result);
    }

    @Test
    public void givenRecordPosition_WhenDeleteRecord_ThenReturnDeletedMessage() throws IOException, AddressBookException {
        String position="1";
        String result = main.addressBook(new Person(),FILE_PATH,DELETE_RECORD,position);
        Assert.assertEquals("Delete Record", result);
    }

    @Test
    public void givenFilePath_WhenSortRecordByName_ThenReturnSortedMessage() throws IOException, AddressBookException {
        String result = main.addressBook(new Person(),FILE_PATH,SORT_LIST);
        Assert.assertEquals("Sort Records ByName", result);
    }
}
