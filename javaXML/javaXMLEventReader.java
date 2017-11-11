
import java.io.FileNotFoundException;
import javax.rmi.CORBA.Stub;
import javax.sound.midi.SysexMessage;
import javax.xml.stream.XMLStreamException;
import java.io.FileReader;
import javax.xml.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.*;
import javax.xml.stream.util.EventReaderDelegate;


public class javaXMLEventReader{
    public static void main(String[] args) throws FileNotFoundException{
        XMLInputFactory xmlInputFactory=XMLInputFactory.newInstance();

        try{
            XMLEventReader xmlEventReader=xmlInputFactory.createXMLEventReader(
                    new FileReader("temp.xml")
            );
            while(xmlEventReader.hasNext()){
                XMLEvent event=xmlEventReader.nextEvent();
                if(event.isStartElement() && event.asStartElement().getName().toString().equals(Student.ROOT)){
                    Student student=new Student();

                    //find name
                    String[] names=new String[3];
                    while(!(event.isStartElement() && event.asStartElement().getName().toString().equals(Student.NAME))){
                        event=xmlEventReader.nextEvent();
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals(Student.NAME)) {
                        for(int i=0;i<3;){
                            if (event.isStartElement() && event.asStartElement().getName().toString().equals(Student.NAME_INNER_ELEMENTS[i])) {
                                event=xmlEventReader.nextEvent();
                                if (event.isCharacters()) {
                                    names[i] = event.asCharacters().getData();
                                }
                                i++;
                            }
                            event=xmlEventReader.nextEvent();
                        }
                    }
                    student.setName(names);
                    xmlEventReader.nextEvent();
//                    System.out.println(student.name[0]+" "+student.name[1]+" "+student.name[2]);

                    //find age
                    int age=0;
                    while(!(event.isStartElement() && event.asStartElement().getName().toString().equals(Student.AGE))){
                        event=xmlEventReader.nextEvent();
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals(Student.AGE)) {
                        event=xmlEventReader.nextEvent();
                        if(event.isCharacters()){
                            age = Integer.parseInt(event.asCharacters().getData().toString());
                        }
                    }
                    student.setAge(age);

                    //find abcd
                    Object abcd=new Object();
                    while(!(event.isStartElement() && event.asStartElement().getName().toString().equals(Student.ABCD))){
                        event=xmlEventReader.nextEvent();
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals(Student.AGE)) {
                        event=xmlEventReader.nextEvent();
                        if(event.isCharacters()){
                            abcd = event.asCharacters().getData().toString();
                        }
                    }
                    student.setAbcd(abcd);

                    System.out.println(student);
                }

            }
        }catch(XMLStreamException e){
            e.printStackTrace();
        }
    }
}
class Student{
    //element names
    final static String ROOT="student";
    final static String[] NAME_INNER_ELEMENTS=
            {
                    "firstName",
                    "middleName",
                    "lastName"
            };
    final static String NAME="name";
    final static String AGE="age";
    final static String ABCD="abcd";

    String[] name;
    int age;
    Object abcd;

    public String[] getName(){
        return name;
    }

    public void setName(String[] name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public Object getAbcd(){
        return abcd;
    }

    public void setAbcd(Object object){
        this.abcd=object;
    }

    @Override
    public String toString(){
        return "Student[name="+name[0]+" "+name[1]+" " +name[2]+", age="+age+", abcd="+abcd+"]";
    }
}