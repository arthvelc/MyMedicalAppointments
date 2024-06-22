package ui;//package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MONTHS = {"Enero", "Febrero","Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. model.Doctor");
            System.out.println("2. model.Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("model.Doctor");
                    break;
                case 2:
                    response = 0;
                    showPatientMenu();

                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    static void showPatientMenu(){
        int response = 0;

        final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    authUser(1);
                    break;
                case 2:
                    System.out.println("::My appointments");
                    for(int i = 0; i < 3; i++){
                        System.out.println((i+1)+"."+MONTHS[i]);
                    }
                    authUser(2);
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez", "alejandro@gmail.com", "Pediadría"));
        doctors.add(new Doctor("Karen Sosa", "ksosa@gmail.com", "Cardiología"));
        doctors.add(new Doctor("Rocío Gomez", "rocio@gmail.com", "Neurología"));

        ArrayList<Patient> patients = new ArrayList<>();

        patients.add(new Patient("Pedro", "pedro@gmail.com"));
        patients.add(new Patient("Sandra", "sandra@gmail.com"));
        patients.add(new Patient("Román", "roman@gmail.com"));

        Boolean emailCorrect = false;
        do {
            System.out.println("\n\n");
            System.out.println("Insert your Email: ");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if(userType == 1){
                for(Doctor doctor: doctors){
                    if(doctor.getEmail().equals(email));
                    emailCorrect = true;
                    doctorLogged = doctor;
                    //showDoctorMenu
                }
            }
            if(userType == 2){
                for (Patient patient: patients){
                    if(patient.getEmail().equals(email));
                    emailCorrect = true;
                    patientLogged = patient;
                    //ShowPatientMenu
                }
            }
        }while(!emailCorrect);
    }
}
