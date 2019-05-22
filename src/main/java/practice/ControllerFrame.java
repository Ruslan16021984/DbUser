package practice;

import jdbc.DB;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ControllerFrame {
    private Frame myFrame;
    private JButton buttonSaveDb;
    private JTextField txFirstName;
    private JTextField txLastName;
    private JTextField txEmail;
    private DB db;

    private Box mainBox;
    private Box firstBox;
    private Box secondBox;
    private Box threeBox;

    public ControllerFrame() {
        db = new DB();
        initAllFilds();
        addTxtListener();
        addButtonListener();
        myFrame.setVisible(true);
    }

    private void initAllFilds() {
        myFrame = new Frame("База пользователей", 300, 260);
        mainBox = Box.createVerticalBox();
        txFirstName = new JTextField();
        txFirstName.setBorder(new TitledBorder("Введите имя"));

        txLastName = new JTextField();
        txLastName.setBorder(new TitledBorder("Введите фамилия"));

        txEmail = new JTextField();
        txEmail.setBorder(new TitledBorder("Введите email"));

        buttonSaveDb = new JButton("Добавить");
        buttonSaveDb.setEnabled(false);

        firstBox = new Box(BoxLayout.PAGE_AXIS);
        firstBox.add(txFirstName);
        firstBox.add(Box.createVerticalStrut(30));

        secondBox = new Box(BoxLayout.PAGE_AXIS);
        secondBox.add(txLastName);
        secondBox.add(Box.createVerticalStrut(30));

        threeBox = new Box((BoxLayout.PAGE_AXIS));
        threeBox.add(txEmail);
        threeBox.add(buttonSaveDb);
        threeBox.add(Box.createHorizontalStrut(80));
        threeBox.add(Box.createVerticalStrut(30));


        mainBox.add(firstBox);
        mainBox.add(secondBox);
        mainBox.add(threeBox);

        myFrame.setContentPane(mainBox);


    }

    private void addButtonListener() {
        buttonSaveDb.addActionListener(e -> {
            String firstName = txFirstName.getText();
            String lastName = txLastName.getText();
            String email = txEmail.getText();
            db.addUser(new User(firstName, lastName, email));

        });
    }

    private void addTxtListener() {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkListener();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkListener();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };

        txFirstName.getDocument().addDocumentListener(documentListener);
        txLastName.getDocument().addDocumentListener(documentListener);
        txEmail.getDocument().addDocumentListener(documentListener);
    }

    private void checkListener() {
        if (!txFirstName.getText().isEmpty() && !txLastName.getText().isEmpty() && !txEmail.getText().isEmpty())
            buttonSaveDb.setEnabled(true);
        else
            buttonSaveDb.setEnabled(false);
    }
}

