package com.company;
import java.awt.List;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Window extends JFrame implements ActionListener {
    protected static JLabel empty = new JLabel("");
    private JButton show_name = new JButton("Show by name");
    private JButton show_group = new JButton("Show by groups");
    private JButton show_course = new JButton("Show by course");
    private JButton edit = new JButton("Edit");
    private JButton add = new JButton("Add");
    private JLabel label = new JLabel("Students:");
    private List list = new List();
    private List list2 = new List();
    private ArrayList<Student> a;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    public Window(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuItem = new JMenuItem("Open");
        menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        Box b = new Box(2);

        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, 1));
        JPanel jPanel = new JPanel();
        jPanel.add(label);

        b.add(jPanel);
        b.add(list);
        b.add(list2);
        container.add(b);

        Box b2 = new Box(2);

        show_name.addActionListener(this);
        show_group.addActionListener(this);
        show_course.addActionListener(this);
        JPanel jPanel1 = new JPanel();
        jPanel1.add(show_name);
        jPanel1.add(show_group);
        jPanel1.add(show_course);
        b2.add(jPanel1);

        edit.addActionListener(this);
        JPanel jPanel2 = new JPanel();
        jPanel2.add(edit);
        b2.add(jPanel2);

        add.addActionListener(this);
        JPanel jPanel3 = new JPanel();
        jPanel3.add(add);
        b2.add(jPanel3);

        container.add(b2);
        read("input.txt");
        show(list, a);
        setSize(550, 220);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show_name)
        {
            show(list, a);
            TreeSet<Student> set1 = new TreeSet<>(new MyComparator());
            TreeSet<Student> set2 = new TreeSet<>(new MyComparator());

            for (Student el : a)
                if (set1.contains(el))
                    set2.add(el);
                else
                    set1.add(el);
            show(list2, set2);
        }
        else if (e.getSource() == show_group) {
                show(list, a);
                TreeSet<Student> set1 = new TreeSet<>(new MyComparator2());
                for (Student el : a)
                        set1.add(el);

                show(list2, set1);
            }
        else if (e.getSource() == show_course) {
            show(list, a);
            TreeSet<Student> set1 = new TreeSet<>(new MyComparator3());
            TreeSet<Student> set2 = new TreeSet<>(new MyComparator3());

            for (Student el : a)
                set1.add(el);

            show(list2, set1);
        }
         else if (e.getSource() == menuItem) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            chooser.setFileFilter(filter);
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                read(chooser.getSelectedFile().getName());
                show(list, a);
                list2.removeAll();
            }

        } else if (e.getSource() == add) {
            Student tempStudent = new Student();
            new Dialog(this, "add Student", tempStudent);

            if (!tempStudent.equals(new Student())) {
                a.add(tempStudent);
                show(list, a);
            }
        } else if (e.getSource() == edit) {
            int ind = list.getSelectedIndex();
            if (ind != -1) {
                new Dialog(this, "edit Student", a.get(ind));
                show(list, a);
            } else {
                JOptionPane.showMessageDialog(this, "Select element!", "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private void read(String filename) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(filename));
            a = new ArrayList<>();
            while (sc.hasNext())
                a.add(new Student(sc.nextInt(),sc.next(),sc.nextInt(), sc.nextInt()));
        } catch (FileNotFoundException err) {
            JOptionPane.showMessageDialog(this, err, "Error!", JOptionPane.PLAIN_MESSAGE);
        } finally {
            if (sc != null)
                sc.close();
        }
    }

    private void show(List list, Collection<Student> a) {
        if (a != null) {
            list.removeAll();
            for (Student el : a)
                list.add(el.toString());
        } else {
            JOptionPane.showMessageDialog(this, "There are no elements!", "Error!", JOptionPane.PLAIN_MESSAGE);
        }

    }
}
