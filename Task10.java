
import java.awt.FlowLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

class Picture {
    public void getPicture() throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:db2:sample", "db2admin",
                    "db2admin");
            String sql = "SELECT * FROM JLU.EMP_PHOTO WHERE PHOTO_FORMAT = 'gif' AND EMPNO = ";
            String[] name = { "000130", "000140", "000150", "000190" };
            for (int i = 0; i < 4; i++) {
                PreparedStatement query = con.prepareStatement(sql + name[i]);
                ResultSet re = query.executeQuery();
                if (re.next()) {
                    InputStream inputStream = re.getBinaryStream(3);
                    FileOutputStream fos = new FileOutputStream(name[i] + ".gif");
                    byte[] b = new byte[1024];
                    int len = -1;
                    while ((len = inputStream.read(b)) != -1) {
                        fos.write(b, 0, len);
                    }
                    fos.close();
                    inputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Task10 {
    static {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (Exception e) {
            System.out.println("\n Error loading DB2 Driver... \n");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "错误", JOptionPane.INFORMATION_MESSAGE);
        }
        ;
    }

    public static void main(String[] args) throws SQLException {
        Picture p = new Picture();
        p.getPicture();

        JFrame MainWindow = new JFrame("图片");

        ImageIcon img1 = new ImageIcon("/home/frankcox/IdeaProjects/DataBaseExpriment/000130.gif");
        JLabel pic1 = new JLabel(img1);

        ImageIcon img2 = new ImageIcon("/home/frankcox/IdeaProjects/DataBaseExpriment/000140.gif");
        JLabel pic2 = new JLabel(img2);

        ImageIcon img3 = new ImageIcon("/home/frankcox/IdeaProjects/DataBaseExpriment/000150.gif");
        JLabel pic3 = new JLabel(img3);

        ImageIcon img4 = new ImageIcon("/home/frankcox/IdeaProjects/DataBaseExpriment/000190.gif");
        JLabel pic4 = new JLabel(img4);

        MainWindow.add(pic1);
        MainWindow.add(pic2);
        MainWindow.add(pic3);
        MainWindow.add(pic4);

        MainWindow.setBounds(500, 100, 1000, 800);
        MainWindow.setLayout(new FlowLayout());
        MainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainWindow.setVisible(true);

    }
}