/**
 * Created by Admin on 15-04-2017.
 */
public class Enumerations {
    enum Month{
        Jan(31),
        Feb(28),
        March(31),
        Apr(30),
        May(31),
        June(30),
        July(31),
        Aug(31),
        Sept(30),
        Oct(31),
        Nov(30),
        Dec(31);

        private int days;

        Month(int days){
            this.days=days;
        }

        public int getDays() {
            return days;
        }
    }

    static Month month=Month.Apr;

    public static void main(String[] a){
        System.out.print(month.getDays());
    }
}
