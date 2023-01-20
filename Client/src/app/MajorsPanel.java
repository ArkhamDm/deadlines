package app;

import data.Deadline;
import data.Major;
import app.models.deadline.DeadlineList;
import app.models.major.MajorList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MajorsPanel extends JPanel {
    public MajorsPanel(int is_admin) {
        MajorList majors = new MajorList();
        DeadlineList deadlines = new DeadlineList();

        JButton addButton = new JButton("Add Major");
        JButton delButton = new JButton("Del Major");
        JButton changeMajorButton = new JButton("Change Major");

        JButton addDeadlineButton = new JButton("Add Deadline");
        JButton delDeadlineButton = new JButton("Del Deadline");
        JButton changeDeadlineButton = new JButton("Change Deadline");

        //database update
        ArrayList<Major> m = ServiceManager.getInstance().getServices().getMajors();
        for (Major mag: m){
            majors.getMajorModel().addMajor(mag);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField name = new JTextField();
                JCheckBox is_exam = new JCheckBox();
                Object[] message = {
                        "Название предмета:", name,
                        "Экзамен:", is_exam
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Major", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    Major major = new Major();
                    major.setName(name.getText());
                    major.setIs_exam(is_exam.isSelected());

                    String id = ServiceManager.getInstance().getServices().addMajor(major);
                    major.setId(id);
                    majors.getMajorModel().addMajor(major);
                }
            }
        });

        addDeadlineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Major major = majors.getSelectedValue();
                JTextField description = new JTextField();
                JTextField date = new JTextField();
                Object[] message = {
                        "Описание задания:", description,
                        "Дедлайн: (12-12-2012)", date
                };
                int option = JOptionPane.showConfirmDialog(null, message, "Deadline", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION){
                    Deadline deadline = new Deadline();
                    deadline.setDescription(description.getText());
                    deadline.setDate(date.getText());

                    String id = ServiceManager.getInstance().getServices().addDeadline(deadline, major.getId());
                    deadline.setId(id);
                    deadlines.getDeadlineModel().addDeadline(deadline);
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Major major = majors.getSelectedValue();
                ServiceManager.getInstance().getServices().delMajor(major.getId());
                majors.getMajorModel().delMajor(major);
            }
        });

        delDeadlineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deadline deadline = deadlines.getSelectedValue();
                ServiceManager.getInstance().getServices().delDeadline(deadline.getId());
                deadlines.getDeadlineModel().delDeadline(deadline);
            }
        });

        changeMajorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField name = new JTextField();
                JCheckBox is_exam = new JCheckBox();
                Object[] message = {
                        "Изменить название предмета:", name,
                        "Экзамен:", is_exam
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Change Major", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    Major major = majors.getSelectedValue();
                    major.setName(name.getText());
                    major.setIs_exam(is_exam.isSelected());

                    ServiceManager.getInstance().getServices().changeMajor(major);
                    majors.setSelectedValue(major, false);
                }
            }
        });

        changeDeadlineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField description = new JTextField();
                JTextField date = new JTextField();
                Object[] message = {
                        "Изменить описание задачи:", description,
                        "Изменить дату: (12-12-2012)", date
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Change Deadline", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    Deadline deadline = deadlines.getSelectedValue();
                    deadline.setDate(date.getText());
                    deadline.setDescription(description.getText());

                    ServiceManager.getInstance().getServices().changeDeadline(deadline);
                    deadlines.setSelectedValue(deadline, false);
                }
            }
        });

        majors.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ArrayList<Deadline> empty = new ArrayList<Deadline>();
                deadlines.getDeadlineModel().setDeadlineList(empty);
                if (majors.getSelectedValue() != null) {
                    String id = majors.getSelectedValue().getId();
                    ArrayList<Deadline> deadline = ServiceManager.getInstance().getServices().getDeadlines(id);

                    for (Deadline dead : deadline) {
                        deadlines.getDeadlineModel().addDeadline(dead);
                    }

                    if (deadline.isEmpty()) {
                        Deadline dead = new Deadline();
                        dead.setDescription("Пока ничего нет");
                        dead.setDate("NONE");

                        deadlines.getDeadlineModel().addDeadline(dead);
                    }
                }
            }
        });

        JToolBar MajorToolBar = new JToolBar();
        MajorToolBar.setFloatable(false);
        MajorToolBar.add(addButton);
        MajorToolBar.add(delButton);
        MajorToolBar.add(changeMajorButton);

        JPanel leftPanel = new JPanel(new BorderLayout());
        if (is_admin == 1) leftPanel.add(MajorToolBar, BorderLayout.NORTH);
        leftPanel.add(majors, BorderLayout.CENTER);

        JToolBar DeadlineToolBar = new JToolBar();
        DeadlineToolBar.setFloatable(false);
        DeadlineToolBar.add(addDeadlineButton);
        DeadlineToolBar.add(delDeadlineButton);
        DeadlineToolBar.add(changeDeadlineButton);

        JPanel rightPanel = new JPanel(new BorderLayout());
        if (is_admin == 1) rightPanel.add(DeadlineToolBar, BorderLayout.NORTH);
        rightPanel.add(deadlines, BorderLayout.CENTER);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(350);

        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);

    }
}
