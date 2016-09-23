
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Stylist {
  private String name;
  private String specialty;
  private String phone;
  private String img_URL;
  private String email;
  private String bio;
  private String days_available;
  private String instagram;
  private int id;

  public Stylist(String _name, String _phone, String _img_URL, String _email, String _specialty, String _bio, String _days_available, String _instagram){
    name = _name;
    phone = _phone;
    img_URL = _img_URL;
    email = _email;
    specialty = _specialty;
    bio = _bio;
    days_available = _days_available;
    instagram = _instagram;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getImgUrl() {
    return img_URL;
  }

  public String getEmail() {
    return email;
  }

  public String getBio() {
    return bio;
  }

  public String getInstagram() {
    return instagram;
  }

  public int getId() {
    return id;
  }

  public String getSpecialty() {
    return specialty;
  }

  public String getDays() {
    return days_available;
  }

  public void setName(String _name) {
    this.name = _name;
  }

  public void setPhone(String _phone) {
    this.phone = _phone;
  }

  public void setImgUrl(String _url) {
    this.img_URL = _url;
  }

  public void setEmail(String _email) {
    this.email = _email;
  }

  public void setBio(String _bio) {
    this.bio = _bio;
  }

  public void setInstagram(String _instagram) {
    this.instagram = _instagram;
  }

  public void setSpecialty(String _specialty) {
    this.specialty = _specialty;
  }

  public void setDays(String _days) {
    this.days_available = _days;
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylistId = :id;";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
      this.getPhone().equals(newStylist.getPhone()) &&
      this.getImgUrl().equals(newStylist.getImgUrl()) &&
      this.getEmail().equals(newStylist.getEmail()) &&
      this.getBio().equals(newStylist.getBio()) &&
      this.getInstagram().equals(newStylist.getInstagram()) &&
      this.getSpecialty().equals(newStylist.getSpecialty()) &&
      this.getDays().equals(newStylist.getDays()) &&
      this.getId() == newStylist.getId();
    }
  }

  public static List<Stylist> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists;";
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, phone, img_url, email, bio, instagram, specialty, days) VALUES (:name, :phone, :img_url, :email, :bio, :instagram, :specialty, :day);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("phone", this.phone)
        .addParameter("img_url", this.img_URL)
        .addParameter("email", this.email)
        .addParameter("bio", this.bio)
        .addParameter("instagram", this.instagram)
        .addParameter("specialty", this.specialty)
        .addParameter("day", this.days_available)
        .executeUpdate()
        .getKey();
    }
  }

  public void update() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET (name, phone, img_url, email, bio, instagram, specialty, days) = (:name, :phone, :img_url, :email, :bio, :instagram, :specialty, :days WHERE id = :id);";
      con.createQuery(sql)
        .addParameter("name", this.name)
        .addParameter("phone", this.phone)
        .addParameter("img_url", this.img_URL)
        .addParameter("email", this.email)
        .addParameter("bio", this.bio)
        .addParameter("instagram", this.instagram)
        .addParameter("specialty", this.specialty)
        .addParameter("days", this.days_available)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists where id = :id;";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
