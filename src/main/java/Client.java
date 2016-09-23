import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.sql.Date;

public class Client {
  private String name;
  private String phone;
  private String email;
  private Date next_appt;
  private String img_url;
  private int id;
  private int stylistId;

// Constructor
  public Client(String _name, String _phone, String _email, Date _next_appt, String _img_url, int _stylistId) {
    name = _name;
    phone = _phone;
    email = _email;
    next_appt = _next_appt;
    img_url = _img_url;
    stylistId = _stylistId;
  }

  // Getter and Setter Methods

  public String getName() {
    return name;
  }

  // public void setName(String _name) {
  //   this.name = name;
  // }

  public String getPhone() {
    return phone;
  }
//
//   public void setPhone(String _phone) {
//     this.phone = _phone;
//   }
//
  public String getEmail() {
    return email;
  }
//
//   public void setEmail(String _email) {
//     this.email = _email;
//   }
  public Date getNextAppt() {
    return next_appt;
  }
//   public void setNextAppt(Date _date) {
//     this.next_appt = _date;
//   }
  public String getImgUrl() {
    return img_url;
  }
//   public void setImgUrl(String _url) {
//     this.img_url = _url;
//   }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylistId;
  }

//Methods accessing database
  public static List<Client> all() {
    String sql = "SELECT * FROM clients;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, phone, email, next_appt, img_url, stylistId) VALUES (:name, :phone, :email, :next_appt, :img_url, :stylistId);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("phone", this.phone)
        .addParameter("email", this.email)
        .addParameter("next_appt", this.next_appt)
        .addParameter("img_url", this.img_url)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }
  public void update() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET (name, phone, email, next_appt, img_url, stylistId) = (:name, :phone, :email, :next_appt, :img_url, :stylistId) WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("name", this.name)
      .addParameter("phone", this.phone)
      .addParameter("email", this.email)
      .addParameter("next_appt", this.next_appt)
      .addParameter("img_url", this.img_url)
      .addParameter("stylistId", this.stylistId)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if(!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
      this.getPhone().equals(newClient.getPhone()) &&
      this.getEmail().equals(newClient.getEmail()) &&
      this.getId() == newClient.getId() &&
      this.getNextAppt().equals(newClient.getNextAppt()) &&
      this.getEmail().equals(newClient.getEmail()) &&
      this.getStylistId() == newClient.getStylistId();
    }
  }
  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id = :id;";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
        return client;
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

}
