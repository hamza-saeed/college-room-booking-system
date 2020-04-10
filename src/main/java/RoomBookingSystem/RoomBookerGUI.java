package RoomBookingSystem;

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
 *
 * @author Hamza
 */
public class RoomBookerGUI extends javax.swing.JFrame implements Runnable, Observer {

    private SharedData sharedData;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
        SimpleDateFormat spinDateModel = new SimpleDateFormat("dd/MM/yyyy");
        spinDateFilter = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnFindRooms = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNotes = new javax.swing.JTextField();
        btnBookSelectedRoom = new javax.swing.JButton();

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

        spinDateFilter.setModel(new javax.swing.SpinnerDateModel());
        spinDateFilter.setEditor(new javax.swing.JSpinner.DateEditor(spinDateFilter,spinDateModel.toPattern()));

        jLabel3.setText("Room Booking Date");

        btnFindRooms.setText("Find Rooms");
        btnFindRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindRoomsActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                    .addComponent(txtEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(txtNotes)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(spinDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnFindRooms))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(343, 343, 343)
                                .addComponent(btnBookSelectedRoom)))
                        .addGap(0, 193, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnFindRooms))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBookSelectedRoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        //get available rooms
        ArrayList<AvailableRoom> availableRooms = RoomBookingFunctions.getAvailableBookingsOnDay(sharedData.getTheBookings(), sharedData.getTheRooms(), sharedData.getTheTerms(), sharedData.getTheUnavailabilities(), textDateFilter);
        //populate table with available rooms
        for (AvailableRoom availRoom : availableRooms) {
            model.addRow(new Object[]{availRoom.getRoom().getRoomName(), textDateFilter, availRoom.getDayTime(), availRoom.getRoom().getSpaces(), availRoom.getRoom().getTypeOfRoom()});
        }
    }
    
    private void clearTextBoxes()
    {
        //clear inputs
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtNotes.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookSelectedRoom;
    private javax.swing.JButton btnFindRooms;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinDateFilter;
    private javax.swing.JTable tableAvailability;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNotes;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

}
