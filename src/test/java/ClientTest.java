import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;

public class ClientTest {
  @Rule
 public DatabaseRule database = new DatabaseRule();

 @Test
 public void client_instantiatesCorrectly_true() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg");
   assertEquals(true, testClient instanceof Client);
 }

 @Test
 public void getName_grabsNameFromClient_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg");
   assertEquals("Joanna", testClient.getName());
 }

 @Test
 public void
 getPhone_grabsPhoneFromClient_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg");
   assertEquals("123-456-7890", testClient.getPhone());
 }

 @Test
 public void getEmail_grabsEmailFromClient_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg");
   assertEquals("me@me.com", testClient.getEmail());
 }

 @Test
 public void getNextAppt_grabsNextApptFromClient_Date() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg");
   assertEquals(next_appt, testClient.getNextAppt());
 }
}
