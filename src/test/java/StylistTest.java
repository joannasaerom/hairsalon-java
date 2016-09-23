import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;

public class StylistTest {
  @Rule
 public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_grabsNameFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("Joanna", testStylist.getName());
  }

  @Test
  public void getPhone_grabsPhoneFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("123-456-7890", testStylist.getPhone());
  }

  @Test
  public void getImgUrl_grabsImgUrlFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("www.example.com", testStylist.getImgUrl());
  }

  @Test
  public void getEmail_grabsEmailFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("me@me.com", testStylist.getEmail());
  }

  @Test
  public void getBio_grabsBioFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("Sample bio", testStylist.getBio());
  }

  @Test
  public void getInstagram_grabsInstagramFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("testhandle", testStylist.getInstagram());
  }

  @Test
  public void getSpecialty_grabsSpecialtyFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("Coloring", testStylist.getSpecialty());
  }

  @Test
  public void getDays_grabsDaysFromStylist_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals("M-F", testStylist.getDays());
  }

  @Test
  public void equals_compareTwoStylistInstances_true() {
    Stylist testStylist1 = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    Stylist testStylist2 = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    assertEquals(true, testStylist1.equals(testStylist2));
  }

  @Test
  public void save_savesTestStylist_true() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  public void all_grabsAllStylists_true() {
    Stylist testStylist1 = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist1.save();
    Stylist testStylist2 = new Stylist("Emily", "123-456-7890", "www.sample.com", "me@me.com", "Cuts", "Sample bio", "M-F", "testhandle");
    testStylist2.save();
    assertEquals(true, Stylist.all().get(0).equals(testStylist1));
    assertEquals(true, Stylist.all().get(1).equals(testStylist2));
  }

  @Test
  public void find_findsStylistWithSameId_true() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    assertEquals(Stylist.find(testStylist.getId()), testStylist);
  }

  @Test
  public void setName_updatesName_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setName("Emily");
    testStylist.update();
    assertEquals("Emily", testStylist.getName());
  }

  @Test
  public void setPhone_updatesPhone_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setPhone("757-947-4274");
    testStylist.update();
    assertEquals("757-947-4274", testStylist.getPhone());
  }

  @Test
  public void setImgUrl_updatesImgUrl_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setImgUrl("www.sample.com");
    testStylist.update();
    assertEquals("www.sample.com", testStylist.getImgUrl());
  }

  @Test
  public void setEmail_updatesEmail_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setEmail("jsa@me.com");
    testStylist.update();
    assertEquals("jsa@me.com", testStylist.getEmail());
  }

  @Test
  public void setBio_updatesBio_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setBio("Test");
    testStylist.update();
    assertEquals("Test", testStylist.getBio());
  }

  @Test
  public void setInstagram_updatesInstagram_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setInstagram("Test");
    testStylist.update();
    assertEquals("Test", testStylist.getInstagram());
  }

  @Test
  public void setSpecialty_updatesSpecialty_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setSpecialty("Test");
    testStylist.update();
    assertEquals("Test", testStylist.getSpecialty());
  }

  @Test
  public void setDays_updatesDays_String() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    testStylist.save();
    testStylist.setDays("Test");
    testStylist.update();
    assertEquals("Test", testStylist.getDays());
  }

  @Test
  public void getClients_retrievesClientsForStylist_true() {
    Stylist testStylist = new Stylist("Joanna", "123-456-7890", "www.example.com", "me@me.com", "Coloring", "Sample bio", "M-F", "testhandle");
    int stylistId = testStylist.getId();
    Date next_appt1 = Date.valueOf("2016-12-05");
    Client testClient1 = new Client("Joanna", "123-456-7890", "me@me.com", next_appt1, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", stylistId);
    testClient1.save();
    Date next_appt2 = Date.valueOf("2016-12-05");
    Client testClient2 = new Client("Joanna", "123-456-7890", "me@me.com", next_appt2, "https://pbs.twimg.com/profile_images/739247958340698114/fVKY9fOv.jpg", stylistId);
    testClient2.save();
    assertEquals(true, testStylist.getClients().contains(testClient1));
    assertEquals(true, testStylist.getClients().contains(testClient2));
  }
}
