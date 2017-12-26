import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private Container cp;
    private ImagePanel jpn=new ImagePanel();
    private JPanel toolPane=new JPanel(new GridLayout(1,2,5,5));
    private JButton jbtnAddFish=new JButton("Add Fish");
    private JButton jbtnExit=new JButton("Exit");
    private JLabel jlb=new JLabel("aa");
    private int imgW,imgH;
    private int fishIndex=0;
//    private ArrayList<Fish>fishList=new ArrayList<Fish>();
//    private ArrayList<Fish2>fishList2=new ArrayList<Fish2>();
    private ArrayList<Thread>threadList=new ArrayList<Thread>();

    public MainFrame(){
        imgW=jpn.getImgWidth();
        imgH=jpn.getImgHeight();
        this.setBounds(350,100,imgW,imgH+30);
        this.setResizable(false);
        jpn.setLayout(null);
        toolPane.add(jbtnAddFish);
        toolPane.add(jbtnExit);
        jlb.setBounds(100,100,80,30);

        jbtnAddFish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                fishList.add(new Fish(imgH,imgW));
//                jpn.add(fishList.get(fishList.size()-1));
//                threadList.add(new Thread(fishList.get(fishList.size()-1)));
                threadList.get(threadList.size()-1).start();
            }
        });
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpn,BorderLayout.CENTER);
        cp.add(toolPane,BorderLayout.NORTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.validate();
    }
}
class ImagePanel extends JPanel {
    private BufferedImage image;
    private int imgW, imgH;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("1887055.jpg"));
            imgW = image.getWidth();
            imgH = image.getHeight();
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "IOException:" + ex.toString());
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public int getImgWidth() {
        return imgW;
    }

    public int getImgHeight() {
        return imgH;
    }

}
