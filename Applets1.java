import java.awt.*;
import java.applet.*;

public class Applets1 extends Applet{

    int i=0;
    @Override
    public void paint(Graphics g) {
        g.drawString("A simple applet"+i, 10, 10);
        i++;
    }

}
