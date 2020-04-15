package RoomBookingSystem;

import DataStructures.*;
import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 * Room Booker GUI
 *
 * @author Hamza
 */
public class RoomBookerGUI extends javax.swing.JFrame implements Runnable, Observer {

    private SharedData sharedData;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    boolean updateTableForSpecificDay = false;

    public RoomBookerGUI(SharedData initialBookings) {
        super();
        sharedData = initialBookings;
        sharedData.addObserver(this);
        initComponents();
        updateSharedData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAvailability = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNotes = new javax.swing.JTextField();
        btnBookSelectedRoom = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SimpleDateFormat spinDateModel = new SimpleDateFormat("dd/MM/yyyy");
        spinDateFilter = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        comboRoomType = new javax.swing.JComboBox<>();
        btnFindRooms = new javax.swing.JButton();
        btnAllAvailabilitiesTwoWeeks = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Room Booker");

        tableAvailability.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date", "Time", "Spaces", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAvailability);

        jLabel4.setText("Name:");

        jLabel5.setText("Email:");

        jLabel6.setText("Phone:");

        jLabel7.setText("Notes:");

        btnBookSelectedRoom.setText("Book Selected Room");
        btnBookSelectedRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookSelectedRoomActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Filter");

        jLabel3.setText("Room Booking Date:");

        spinDateFilter.setModel(new javax.swing.SpinnerDateModel());
        spinDateFilter.setEditor(new javax.swing.JSpinner.DateEditor(spinDateFilter,spinDateModel.toPattern()));

        jLabel2.setText("Type:");

        comboRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "COMPUTER_LAB", "TUTORIAL_ROOM", "LECTURE_THEATRE" }));

        btnFindRooms.setText("Find Rooms");
        btnFindRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindRoomsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFindRooms)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindRooms))
                .addContainerGap())
        );

        btnAllAvailabilitiesTwoWeeks.setText("Show All Available Rooms In The Next 2 Weeks");
        btnAllAvailabilitiesTwoWeeks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllAvailabilitiesTwoWeeksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(btnAllAvailabilitiesTwoWeeks)
                        .addGap(283, 283, 283))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone)
                                    .addComponent(txtNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
            .addGroup(layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(btnBookSelectedRoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAllAvailabilitiesTwoWeeks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnBookSelectedRoom)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookSelectedRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookSelectedRoomActionPerformed
        //get text from textbox
        String bookerName = txtName.getText();
        String bookerEmail = txtEmail.getText();
        String bookerPhone = txtPhone.getText();
        String bookingNotes = txtNotes.getText();
        //get currently selected row to extract data from table
        int row = tableAvailability.getSelectedRow();
        //make sure textboxes aren't empty
        if (bookerName.trim().isEmpty() || bookerEmail.trim().isEmpty() || bookerPhone.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Booking Not Added! Name, Email and Phone Info must be entered!");
            return;
        }
        //if a row was not selected
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Booking Not Added! A Booking Date/Time Must Be Selected From The Table!");
            return;
        }
        //get data from table
        String roomName = tableAvailability.getModel().getValueAt(row, 0).toString();
        LocalDate bookingDate = LocalDate.parse(tableAvailability.getModel().getValueAt(row, 1).toString(), formatter);
        String time = tableAvailability.getModel().getValueAt(row, 2).toString();
        TimeOfDay bookingTime = RoomBookingFunctions.returnTimeFromString(time);
        if (RoomBookingFunctions.doesBookingExist(sharedData.getTheBookings(), roomName, bookingDate, bookingTime)) {
            //this shouldn't occur due to the observer design pattern automatically updating the gui
            JOptionPane.showMessageDialog(null, "Booking Not Added! Someone already booked this!");
            return;
        }
        //Add booking
        OneBooking newBooking = new OneBooking(roomName, bookerName, bookerEmail, bookerPhone, bookingNotes, bookingDate, bookingTime);
        sharedData.addBooking(newBooking);
        JOptionPane.showMessageDialog(null, "Booking Added!");
        clearTextBoxes();
    }//GEN-LAST:event_btnBookSelectedRoomActionPerformed

    private void btnFindRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindRoomsActionPerformed

        updateTableForSpecificDay = true;
        //get text from spinner and convert into LocalDate
        String textDateFilter = ((JSpinner.DefaultEditor) spinDateFilter.getEditor()).getTextField().getText();
        LocalDate dateFilter = LocalDate.parse(textDateFilter, formatter);

        //make sure date isn't in the past
        if (dateFilter.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "Selected date is in the past. Please enter a valid date.");
            return;
        }
        //call function to find available rooms and add into table
        updateSharedData();
        //show message
        if (tableAvailability.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Sorry, no available rooms found on the entered date. Please try another date.");
        } else {
            JOptionPane.showMessageDialog(null, "Available rooms found!");
        }
    }//GEN-LAST:event_btnFindRoomsActionPerformed

    private void btnAllAvailabilitiesTwoWeeksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllAvailabilitiesTwoWeeksActionPerformed
        updateTableForSpecificDay = false;
        updateSharedData();
    }//GEN-LAST:event_btnAllAvailabilitiesTwoWeeksActionPerformed

    @Override
    public void run() {
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        updateSharedData();
    }

    public void updateSharedData() {
        String textDateFilter = ((JSpinner.DefaultEditor) spinDateFilter.getEditor()).getTextField().getText();
        DefaultTableModel model = (DefaultTableModel) tableAvailability.getModel();
        model.setRowCount(0);
        ArrayList<OneAvailableRoom> availableRooms = null;
        //get available rooms
        if (updateTableForSpecificDay) {
            availableRooms = RoomBookingFunctions.getAvailableBookingsOnDay(sharedData.getTheBookings(), sharedData.getTheRooms(), sharedData.getTheTerms(), sharedData.getTheUnavailabilities(), textDateFilter, comboRoomType.getSelectedItem().toString());
        } else {
            availableRooms = RoomBookingFunctions.getAvailableBookingsWithinAFortnight(sharedData.getTheBookings(), sharedData.getTheRooms(), sharedData.getTheTerms(), sharedData.getTheUnavailabilities());
        }
        //populate table with available rooms
        for (OneAvailableRoom availRoom : availableRooms) {
            model.addRow(new Object[]{availRoom.getRoom().getRoomName(), availRoom.getDate().format(formatter), availRoom.getDayTime(), availRoom.getRoom().getSpaces(), availRoom.getRoom().getTypeOfRoom()});
        }
    }

    private void clearTextBoxes() {
        //clear inputs
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtNotes.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllAvailabilitiesTwoWeeks;
    private javax.swing.JButton btnBookSelectedRoom;
    private javax.swing.JButton btnFindRooms;
    private javax.swing.JComboBox<String> comboRoomType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinDateFilter;
    private javax.swing.JTable tableAvailability;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNotes;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

}
