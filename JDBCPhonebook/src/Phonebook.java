import java.sql.*;

public class Phonebook {

    private static final String DB_NAME="Phonebook";
    private static final String TABLE_NAME="MAINTABLE";

    String user="root";
    String password="didierdrogba";
    String connectionString="jdbc:mysql://127.0.0.1/"+DB_NAME;

    Connection connection;

    Phonebook(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(connectionString, user, password);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
        connection=null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        connection.close();
    }

    public static void main(String[] args) throws Exception{
        Phonebook phonebook=new Phonebook();
        //phonebook.insertContact(new Contact("sanil2", "sanilkhurana8@gmail.com", "8860009570"));
//        phonebook.deleteContact(0);
        Contact.print(phonebook.getContact(2));
    }

    public void insertContact(Contact contact){
        if(contact.id==-1){
            contact.generateContactId(connection);
        }
        try {
            String sql="INSERT INTO "+TABLE_NAME+" VALUES("+contact.id+", \""+contact.name+"\" , \""+contact.email+"\" , \""+contact.phone+"\");";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteContact(int id){
        try{
            String sql="DELETE FROM "+TABLE_NAME+" WHERE id="+id+";";
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Contact getContact(int id){
        try{
            String sql="SELECT * FROM "+TABLE_NAME+" where id="+id+";";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            resultSet.next();
            int id2=resultSet.getInt(1);
            String name=resultSet.getString(2);
            String email=resultSet.getString(3);
            String phone=resultSet.getString(4);
            Contact contact=new Contact(
                    id2, name, email, phone
            );
            return contact;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    static class Contact{
        int id;
        String name;
        String email;
        String phone;

        public Contact(String name, String email, String phone){
            id=-1;
            this.name=name;
            this.email=email;
            this.phone=phone;
        }

        public Contact(int id, String name, String email, String phone){
            this(name, email, phone);
            this.id=id;
        }

        public void generateContactId(Connection connection){
            try {
                Statement statement = connection.createStatement();
                String sql="SELECT MAX(id) FROM "+Phonebook.TABLE_NAME+";";
                ResultSet set=statement.executeQuery(sql);
                if(!set.next()){
                    throw new RuntimeException("Kuch ho gya yaar. pta nhi. debug kar abb tu");
                }
                int maxId=set.getInt(1);
                this.id=maxId+1;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public static void print(Contact c){
            System.out.println("[Contact("+c.id+", "+c.name+", "+c.phone+", "+c.email+")]");
        }
    }
}