
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

//Table�࣬ʵ�ֻ�ȡ���ݣ���ʼ�������±��
class Table {
    public String[][] Data = new String[200][14];
    private String[] TableTitle = new String[] { "EMPNO", "FIRSTNME", "MIDINIT", "LASTNAME", "WORKDEPT", "PHONENO",
            "HIREDATE", "JOB", "EDLEVEL", "SEX", "BIRTHDATE", "SALARY", "BONUS", "COMM" };
    private JTable TheTable;

    // ��ʼ������
    Table() {
        try {
            int row = 0;
            Connection connection = DriverManager.getConnection("jdbc:db2:sample", "db2admin",
                    "db2admin");
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, "
                    + "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM" + " FROM JLU.EMPLOYEE ");
            while (rs.next()) {
                for (int i = 0; i < 14; i++) {
                    if (rs.getString(i + 1).equals(" ")) {
                        Data[row][i] = "��";
                    } else {
                        Data[row][i] = rs.getString(i + 1);
                    }
                }
                row++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "����", JOptionPane.WARNING_MESSAGE);
        }
        TableColumn column;
        this.TheTable = new JTable(Data, TableTitle);
        TheTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // �����п�
        for (int i = 0; i < 14; i++) {
            column = TheTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(90);
        }
    }

    // ���ر��
    JTable getTheTable() {
        return this.TheTable;
    }

    // ��������
    void refreshData() {
        try {
            int row = 0;
            Connection connection = DriverManager.getConnection("jdbc:db2:sample", "db2admin",
                    "db2admin");
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, "
                    + "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM" + " FROM EMPLOYEE ");
            // ��ȡ����
            while (rs.next()) {
                for (int i = 0; i < 14; i++) {
                    if (rs.getString(i + 1).equals(" ")) {
                        Data[row][i] = "��";
                    } else {
                        Data[row][i] = rs.getString(i + 1);
                    }
                }
                row++;
            }
            rs.close();
            stmt.close();
            TheTable.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "����", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class InsertFunction {
    InsertFunction() {
    };

    static int changerow = 0;

    static void up() {
        changerow++;
    }

    static void down() {
        changerow--;
    }

    // ���в���
    public void InsertOneRow() {
        JFrame getInput = new JFrame("����");
        String[] data = new String[14];
        JLabel EMPNO = new JLabel("EMPNO");
        JLabel FIRSTNME = new JLabel("FIRSTNME");
        JLabel MIDINIT = new JLabel("MIDINIT");
        JLabel LASTNAME = new JLabel("LASTNAME");
        JLabel WORKDEPT = new JLabel("WORKDEPT");
        JLabel PHONENO = new JLabel("PHONENO");
        JLabel HIREDATE = new JLabel("HIREDATE");
        JLabel JOB = new JLabel("JOB");
        JLabel EDLEVEL = new JLabel("EDLEVEL");
        JLabel SEX = new JLabel("SEX");
        JLabel BIRTHDATE = new JLabel("BIRTHDATE");
        JLabel SALARY = new JLabel("SALARY");
        JLabel BONUS = new JLabel("BONUS");
        JLabel COMM = new JLabel("COMM");
        EMPNO.setPreferredSize(new Dimension(120, 30));
        FIRSTNME.setPreferredSize(new Dimension(120, 30));
        MIDINIT.setPreferredSize(new Dimension(120, 30));
        LASTNAME.setPreferredSize(new Dimension(120, 30));
        WORKDEPT.setPreferredSize(new Dimension(120, 30));
        PHONENO.setPreferredSize(new Dimension(120, 30));
        HIREDATE.setPreferredSize(new Dimension(120, 30));
        JOB.setPreferredSize(new Dimension(120, 30));
        EDLEVEL.setPreferredSize(new Dimension(120, 30));
        SEX.setPreferredSize(new Dimension(120, 30));
        BIRTHDATE.setPreferredSize(new Dimension(120, 30));
        SALARY.setPreferredSize(new Dimension(120, 30));
        BONUS.setPreferredSize(new Dimension(120, 30));
        COMM.setPreferredSize(new Dimension(120, 30));
        JTextField getEMPNO = new JTextField();
        JTextField getFIRSTNME = new JTextField();
        JTextField getMIDINIT = new JTextField();
        JTextField getLASTNAME = new JTextField();
        JTextField getWORKDEPT = new JTextField();
        JTextField getPHONENO = new JTextField();
        JTextField getHIREDATE = new JTextField();
        JTextField getJOB = new JTextField();
        JTextField getEDLEVEL = new JTextField();
        JTextField getSEX = new JTextField();
        JTextField getBIRTHDATE = new JTextField();
        JTextField getSALARY = new JTextField();
        JTextField getBONUS = new JTextField();
        JTextField getCOMM = new JTextField();
        getEMPNO.setColumns(40);
        getFIRSTNME.setColumns(40);
        getMIDINIT.setColumns(40);
        getLASTNAME.setColumns(40);
        getWORKDEPT.setColumns(40);
        getPHONENO.setColumns(40);
        getHIREDATE.setColumns(40);
        getJOB.setColumns(40);
        getEDLEVEL.setColumns(40);
        getSEX.setColumns(40);
        getBIRTHDATE.setColumns(40);
        getSALARY.setColumns(40);
        getBONUS.setColumns(40);
        getCOMM.setColumns(40);

        getInput.setBounds(500, 100, 600, 800);
        getInput.add(EMPNO);
        getInput.add(getEMPNO);
        getInput.add(FIRSTNME);
        getInput.add(getFIRSTNME);
        getInput.add(MIDINIT);
        getInput.add(getMIDINIT);
        getInput.add(LASTNAME);
        getInput.add(getLASTNAME);
        getInput.add(WORKDEPT);
        getInput.add(getWORKDEPT);
        getInput.add(PHONENO);
        getInput.add(getPHONENO);
        getInput.add(HIREDATE);
        getInput.add(getHIREDATE);
        getInput.add(JOB);
        getInput.add(getJOB);
        getInput.add(EDLEVEL);
        getInput.add(getEDLEVEL);
        getInput.add(SEX);
        getInput.add(getSEX);
        getInput.add(BIRTHDATE);
        getInput.add(getBIRTHDATE);
        getInput.add(SALARY);
        getInput.add(getSALARY);
        getInput.add(BONUS);
        getInput.add(getBONUS);
        getInput.add(COMM);
        getInput.add(getCOMM);

        JButton insert = new JButton("����");
        insert.addActionListener(e1 -> {
            data[0] = getEMPNO.getText();
            data[1] = getFIRSTNME.getText();
            data[2] = getMIDINIT.getText();
            data[3] = getLASTNAME.getText();
            data[4] = getWORKDEPT.getText();
            data[5] = getPHONENO.getText();
            data[6] = getHIREDATE.getText();
            data[7] = getJOB.getText();
            data[8] = getEDLEVEL.getText();
            data[9] = getSEX.getText();
            data[10] = getBIRTHDATE.getText();
            data[11] = getSALARY.getText();
            data[12] = getBONUS.getText();
            data[13] = getCOMM.getText();
            try {
                Connection connection = DriverManager.getConnection("jdbc:db2:sample", "db2admin",
                        "db2admin");
                Statement stmt = connection.createStatement();
                String sql = "INSERT INTO EMPLOYEE (EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM)"
                        + " VALUES(" + "'" + data[0] + "'" + ", " + "'" + data[1] + "'" + ", " + "'" + data[2] + "'"
                        + ", " + "'" + data[3] + "'" + ", " + "'" + data[4] + "'" + ", " + "'" + data[5] + "'" + ", "
                        + "'" + data[6] + "'" + ", " + "'" + data[7] + "'" + ", " + data[8] + ", " + "'" + data[9] + "'"
                        + ", " + "'" + data[10] + "'" + ", " + data[11] + ", " + data[12] + ", " + data[13] + ")";
                int k = stmt.executeUpdate(sql);
                System.out.println("ִ�����");
                stmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "����", JOptionPane.WARNING_MESSAGE);
            }
        });

        getInput.add(insert);
        getInput.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getInput.setLayout(new FlowLayout());
        getInput.setVisible(true);
    }

    // ���в���
    public void InsertManyRow() {
        JFrame getInput = new JFrame("����");

        String[][] inputdata = new String[100][14];

        JLabel EMPNO = new JLabel("EMPNO");
        JLabel FIRSTNME = new JLabel("FIRSTNME");
        JLabel MIDINIT = new JLabel("MIDINIT");
        JLabel LASTNAME = new JLabel("LASTNAME");
        JLabel WORKDEPT = new JLabel("WORKDEPT");
        JLabel PHONENO = new JLabel("PHONENO");
        JLabel HIREDATE = new JLabel("HIREDATE");
        JLabel JOB = new JLabel("JOB");
        JLabel EDLEVEL = new JLabel("EDLEVEL");
        JLabel SEX = new JLabel("SEX");
        JLabel BIRTHDATE = new JLabel("BIRTHDATE");
        JLabel SALARY = new JLabel("SALARY");
        JLabel BONUS = new JLabel("BONUS");
        JLabel COMM = new JLabel("COMM");
        EMPNO.setPreferredSize(new Dimension(120, 30));
        FIRSTNME.setPreferredSize(new Dimension(120, 30));
        MIDINIT.setPreferredSize(new Dimension(120, 30));
        LASTNAME.setPreferredSize(new Dimension(120, 30));
        WORKDEPT.setPreferredSize(new Dimension(120, 30));
        PHONENO.setPreferredSize(new Dimension(120, 30));
        HIREDATE.setPreferredSize(new Dimension(120, 30));
        JOB.setPreferredSize(new Dimension(120, 30));
        EDLEVEL.setPreferredSize(new Dimension(120, 30));
        SEX.setPreferredSize(new Dimension(120, 30));
        BIRTHDATE.setPreferredSize(new Dimension(120, 30));
        SALARY.setPreferredSize(new Dimension(120, 30));
        BONUS.setPreferredSize(new Dimension(120, 30));
        COMM.setPreferredSize(new Dimension(120, 30));

        JTextField getEMPNO = new JTextField();
        JTextField getFIRSTNME = new JTextField();
        JTextField getMIDINIT = new JTextField();
        JTextField getLASTNAME = new JTextField();
        JTextField getWORKDEPT = new JTextField();
        JTextField getPHONENO = new JTextField();
        JTextField getHIREDATE = new JTextField();
        JTextField getJOB = new JTextField();
        JTextField getEDLEVEL = new JTextField();
        JTextField getSEX = new JTextField();
        JTextField getBIRTHDATE = new JTextField();
        JTextField getSALARY = new JTextField();
        JTextField getBONUS = new JTextField();
        JTextField getCOMM = new JTextField();
        getEMPNO.setColumns(40);
        getFIRSTNME.setColumns(40);
        getMIDINIT.setColumns(40);
        getLASTNAME.setColumns(40);
        getWORKDEPT.setColumns(40);
        getPHONENO.setColumns(40);
        getHIREDATE.setColumns(40);
        getJOB.setColumns(40);
        getEDLEVEL.setColumns(40);
        getSEX.setColumns(40);
        getBIRTHDATE.setColumns(40);
        getSALARY.setColumns(40);
        getBONUS.setColumns(40);
        getCOMM.setColumns(40);

        getInput.setBounds(500, 100, 600, 800);
        getInput.add(EMPNO);
        getInput.add(getEMPNO);
        getInput.add(FIRSTNME);
        getInput.add(getFIRSTNME);
        getInput.add(MIDINIT);
        getInput.add(getMIDINIT);
        getInput.add(LASTNAME);
        getInput.add(getLASTNAME);
        getInput.add(WORKDEPT);
        getInput.add(getWORKDEPT);
        getInput.add(PHONENO);
        getInput.add(getPHONENO);
        getInput.add(HIREDATE);
        getInput.add(getHIREDATE);
        getInput.add(JOB);
        getInput.add(getJOB);
        getInput.add(EDLEVEL);
        getInput.add(getEDLEVEL);
        getInput.add(SEX);
        getInput.add(getSEX);
        getInput.add(BIRTHDATE);
        getInput.add(getBIRTHDATE);
        getInput.add(SALARY);
        getInput.add(getSALARY);
        getInput.add(BONUS);
        getInput.add(getBONUS);
        getInput.add(COMM);
        getInput.add(getCOMM);

        JButton insert = new JButton("����");
        insert.addActionListener(e1 -> {
            inputdata[changerow][0] = getEMPNO.getText();
            inputdata[changerow][1] = getFIRSTNME.getText();
            inputdata[changerow][2] = getMIDINIT.getText();
            inputdata[changerow][3] = getLASTNAME.getText();
            inputdata[changerow][4] = getWORKDEPT.getText();
            inputdata[changerow][5] = getPHONENO.getText();
            inputdata[changerow][6] = getHIREDATE.getText();
            inputdata[changerow][7] = getJOB.getText();
            inputdata[changerow][8] = getEDLEVEL.getText();
            inputdata[changerow][9] = getSEX.getText();
            inputdata[changerow][10] = getBIRTHDATE.getText();
            inputdata[changerow][11] = getSALARY.getText();
            inputdata[changerow][12] = getBONUS.getText();
            inputdata[changerow][13] = getCOMM.getText();
            up();
        });

        JButton quit = new JButton("�ύ���ݿ�");
        quit.addActionListener(e2 -> {
            try {
                Statement stmt = null;
                Connection connection = DriverManager.getConnection("jdbc:db2:sample", "db2admin",
                        "db2admin");
                connection.setAutoCommit(false);
                stmt = connection.createStatement();
                while (changerow > 0) {
                    stmt.executeUpdate(
                            "INSERT INTO EMPLOYEE(EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM)"
                                    + "VALUES(" + "'" + inputdata[changerow][0] + "'" + ", " + "'"
                                    + inputdata[changerow][1] + "'" + ", " + "'" + inputdata[changerow][2] + "'" + ", "
                                    + "'" + inputdata[changerow][3] + "'" + ", " + "'" + inputdata[changerow][4] + "'"
                                    + ", " + "'" + inputdata[changerow][5] + "'" + ", " + "'" + inputdata[changerow][6]
                                    + "'" + ", " + "'" + inputdata[changerow][7] + "'" + ", " + inputdata[changerow][8]
                                    + ", " + "'" + inputdata[changerow][9] + "'" + ", " + "'" + inputdata[changerow][10]
                                    + "'" + ", " + inputdata[changerow][11] + ", " + inputdata[changerow][12] + ", "
                                    + inputdata[changerow][13] + ", ");
                    down();
                }
                connection.commit();
                stmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "����", JOptionPane.WARNING_MESSAGE);
            }
        });

        getInput.add(insert);
        getInput.add(quit);
        getInput.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getInput.setLayout(new FlowLayout());
        getInput.setVisible(true);

    }

    // �Ӳ�ѯ����
    public void InsertWithCheck() {
        JFrame getInput = new JFrame("����");
        getInput.setBounds(500, 100, 500, 600);

        JLabel label0 = new JLabel("�����ѯ����:");
        label0.setPreferredSize(new Dimension(100, 30));
        JTextField getcheck = new JTextField();
        getcheck.setColumns(30);

        JLabel label1 = new JLabel("�����ѯ��ֵ");
        label1.setPreferredSize(new Dimension(100, 30));
        JTextField get_check_value = new JTextField();
        get_check_value.setColumns(30);

        JLabel label2 = new JLabel("�����������");
        label2.setPreferredSize(new Dimension(100, 30));
        JTextField getinsert = new JTextField();
        getinsert.setColumns(30);

        JButton Insert = new JButton("����");
        Insert.addActionListener(e -> {
            String to_check = getcheck.getText();
            String to_check_value = get_check_value.getText();
            String to_insert = getinsert.getText();
            try {
                Connection connection = DriverManager.getConnection("jdbc:db2:sample", "db2admin",
                        "db2admin");
                Statement stmt = connection.createStatement();
                String sql = "INSERT INTO EMPLOYEE (" + "'" + to_insert + "'" + ")" + " VALUES(SELECT EMPLOYEE."
                        + to_check + " FROM EMPLOYEE WHERE EMPLOYEE." + to_check + "=" + to_check_value + ")";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, e1, "����", JOptionPane.WARNING_MESSAGE);
            }
        });

        getInput.add(label0);
        getInput.add(getcheck);
        getInput.add(label1);
        getInput.add(get_check_value);
        getInput.add(label2);
        getInput.add(getinsert);
        getInput.add(Insert);

        getInput.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getInput.setLayout(new FlowLayout());
        getInput.setVisible(true);
    }
}

class Update {
    Update() {
    };

    public void Update(Table l) {
        JFrame Change = new JFrame("�޸�");
        Change.setBounds(500, 100, 500, 600);
        JLabel label0 = new JLabel("�����޸ĵ�����");
        label0.setPreferredSize(new Dimension(100, 30));
        JTextField getLine = new JTextField();
        getLine.setColumns(30);

        JLabel label1 = new JLabel("�����µ���������");
        label1.setPreferredSize(new Dimension(100, 30));
        JTextField getDateName = new JTextField();
        getDateName.setColumns(30);

        JLabel label2 = new JLabel("�����µ���������");
        label2.setPreferredSize(new Dimension(100, 30));
        JTextField getDateValue = new JTextField();
        getDateValue.setColumns(30);

        JButton update = new JButton("�ϴ�");
        update.addActionListener(e -> {
            int row = Integer.parseInt(getLine.getText());
            int col = Integer.parseInt(getDateName.getText());
            String value = getDateValue.getText();
            String name = l.Data[row][1];
            l.Data[row][col] = value;
            try {
                Connection con = DriverManager.getConnection("jdbc:db2:sample", "db2admin",
                        "db2admin");
                Statement stmt = con.createStatement();
                String sql = "UPDATE EMPLOYEE SET" + l.Data[row][col] + " = " + value + " WHERE FIRSTNME" + " = "
                        + name;
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException sqlm) {
                JOptionPane.showMessageDialog(null, sqlm, "����", JOptionPane.WARNING_MESSAGE);
            }
        });

        Change.add(label0);
        Change.add(getLine);
        Change.add(label1);
        Change.add(getDateName);
        Change.add(label2);
        Change.add(getDateValue);
        Change.add(update);

        Change.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Change.setLayout(new FlowLayout());
        Change.setVisible(true);
    }
}

public class Task8 {
    static {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (Exception e) {
            System.out.println("\n Error loading DB2 Driver... \n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Table k = new Table();
        JFrame MainWindow = new JFrame("��");
        MainWindow.setBounds(500, 100, 700, 800);
        MainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainWindow.setLayout(new BorderLayout());

        // ���沼��
        JPanel JP1 = new JPanel();
        JP1.setPreferredSize(new Dimension(600, 50));
        JPanel JP2 = new JPanel();
        JP2.setPreferredSize(new Dimension(600, 700));
        JPanel JP3 = new JPanel();
        JP3.setPreferredSize(new Dimension(100, 700));
        JPanel JP4 = new JPanel();
        JP4.setPreferredSize(new Dimension(600, 50));

        // JP1
        /*
         * JP1,���ϲ���� �����ť���ȡ���ݿ���Ϣ������
         */
        JLabel info = new JLabel("�����Ϣ��SAMPLE-EMPLOYEE");
        info.setPreferredSize(new Dimension(200, 40));
        JButton LoadDataBase = new JButton("�������ݿ�");
        LoadDataBase.setPreferredSize(new Dimension(100, 40));
        LoadDataBase.addActionListener(e -> {
            k.refreshData();
        });
        JP1.add(info);
        JP1.add(LoadDataBase);

        // JP2
        // JP2�б�����ʾ
        JTable thisTabel = k.getTheTable();
        JScrollPane sp = new JScrollPane(thisTabel);
        sp.setPreferredSize(new Dimension(550, 650));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JP2.add(sp);

        /*
         * JP3�в����� 1.���в��� 2.���в��� 3.�Ӳ�ѯ����
         */
        // ���в���
        JButton InsertOneRow = new JButton("���в���");
        InsertOneRow.addActionListener(e -> {
            InsertFunction insert = new InsertFunction();
            insert.InsertOneRow();
        });

        // ���в���
        JButton InsertManyRows = new JButton("���в���");
        InsertManyRows.addActionListener(e -> {
            InsertFunction insert = new InsertFunction();
            insert.InsertManyRow();
        });

        // �Ӳ�ѯ����
        JButton InsertByCheck = new JButton("�Ӳ�ѯ����");
        InsertByCheck.addActionListener(e -> {
            InsertFunction insert = new InsertFunction();
            insert.InsertWithCheck();
        });

        JButton update = new JButton("�޸�");
        update.addActionListener(e -> {
            Update u = new Update();
            u.Update(k);
        });

        JP3.add(InsertOneRow);
        JP3.add(InsertManyRows);
        JP3.add(InsertByCheck);
        JP3.add(update);

        MainWindow.add(JP1, BorderLayout.NORTH);
        MainWindow.add(JP2, BorderLayout.WEST);
        MainWindow.add(JP3, BorderLayout.EAST);
        MainWindow.add(JP4, BorderLayout.SOUTH);
        MainWindow.setVisible(true);
    }
}
