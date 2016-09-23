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
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   assertEquals(true, testClient instanceof Client);
 }

 @Test
 public void getName_grabsNameFromClient_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   assertEquals("Joanna", testClient.getName());
 }

 @Test
 public void
 getPhone_grabsPhoneFromClient_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   assertEquals("123-456-7890", testClient.getPhone());
 }

 @Test
 public void getEmail_grabsEmailFromClient_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   assertEquals("me@me.com", testClient.getEmail());
 }

 @Test
 public void getNextAppt_grabsNextApptFromClient_Date() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   assertEquals(next_appt, testClient.getNextAppt());
 }

 @Test
 public void getStylistId_grabsStylistIdFromClient_1() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   assertEquals(1, testClient.getStylistId());
 }

 @Test
 public void equals_compareTwoClientInstances_true() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient1 = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   Client testClient2 = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   assertEquals(true, testClient1.equals(testClient2));
 }

 @Test
 public void save_savesTestClient_true() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   assertTrue(Client.all().get(0).equals(testClient));
 }

 @Test
 public void all_grabsAllClients_true() {
   Date next_appt1 = Date.valueOf("2016-12-05");
   Client testClient1 = new Client("Joanna", "123-456-7890", "me@me.com", next_appt1, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient1.save();
   Date next_appt2 = Date.valueOf("2016-12-05");
   Client testClient2 = new Client("Joanna", "123-456-7890", "me@me.com", next_appt2, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient2.save();
   assertEquals(true, Client.all().get(0).equals(testClient1));
   assertEquals(true, Client.all().get(1).equals(testClient2));
 }

 @Test
 public void find_findsClientWithSameId_true() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   assertEquals(Client.find(testClient.getId()), testClient);
 }

 @Test
 public void setName_resetsNameToGivenArgument_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   testClient.setName("Emily");
   testClient.update();
   assertEquals("Emily", testClient.getName());
 }

 @Test
 public void setPhone_resetsPhoneToGivenArgument_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   testClient.setPhone("757-947-4274");
   testClient.update();
   assertEquals("757-947-4274", testClient.getPhone());
 }

 @Test
 public void setEmail_resetsEmailToGivenArgument_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   testClient.setEmail("jsa@me.com");
   testClient.update();
   assertEquals("jsa@me.com", testClient.getEmail());
 }

 @Test
 public void setNextAppt_resetsNextApptToGivenArgument_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   Date next_appt2 = Date.valueOf("2016-11-05");
   testClient.setNextAppt(next_appt2);
   testClient.update();
   assertEquals(next_appt2, testClient.getNextAppt());
 }

 @Test
 public void setImgUrl_resetsImgUrlToGivenArgument_String() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   testClient.setImgUrl("www.example.com");
   testClient.update();
   assertEquals("www.example.com", testClient.getImgUrl());
 }

 @Test
 public void setStylistUrl_resetsStylistIdToGivenArgument_2() {
   Date next_appt = Date.valueOf("2016-12-05");
   Client testClient = new Client("Joanna", "123-456-7890", "me@me.com", next_appt, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", 1);
   testClient.save();
   testClient.setStylistId(2);
   testClient.update();
   assertEquals(2, testClient.getStylistId());
 }
}
