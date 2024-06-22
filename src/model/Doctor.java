package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    //Atributos
    private String speciality;

    // Constructor heredando las propiedades de la super class model.User
    public Doctor(String name, String email, String speciality){

        super(name, email);
        this.speciality = speciality;
    }

    //Comportamientos

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setAvailableAppointments(ArrayList<AvailableAppointment> availableAppointments) {
        this.availableAppointments = availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality +"\nAvailable Appointments: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("hola, soy un metodo override");
    }

    //Clase anidada de model.Doctor
    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat ("dd/mm/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (Exception e){
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate(String DATE) {
            return format.format(date);
        }

        public void setDate(String date) throws ParseException {//no sé que pedo aquí
            this.date = format.parse(date);
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Date: " + date + "\nTime: " + time;
        }
    }
}


