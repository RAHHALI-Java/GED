
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class task extends Thread{
    View fr=new View();
    File src,tg;
    FileInputStream in;
    FileOutputStream out;
    task(File from,File to) {
      src=from;
      tg=to;
    }

    @Override
    public void run() {
        int len,total,cur;
        try {
            super.run();
            byte b[]=new byte[1024];
            in = new FileInputStream(src);
            total=in.available();
            out=new FileOutputStream(tg+"/"+src.getName());
            while((len=in.read(b))>0)
            {
             out.write(b);
             cur=in.available();
             fr.progressBar.setValue(100-(int)(cur/(float)total*100));
             Thread.sleep(1000);
            }
            JOptionPane.showMessageDialog(fr, "Stockage effectué avec succés !");
            fr.progressBar.setValue(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(task.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(task.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

}
