package ui;

import model.Doctor.AvailableAppointment;
import model.Doctor;
import model.Patient;


import java.util.ArrayList;
import java.util.Scanner;


public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome" + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available appointment");
            System.out.println("2. My scheduled appointment");
            System.out.println("0. Log out");

            Scanner scanner = new Scanner(System.in);
            response = scanner.nextInt();

            switch (response) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while(response!=0);
    }

    private static void showAvailableAppointmentMenu(Doctor doctor){

        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Add available appointment");
            System.out.println("Select a Month: ");

            for(int i = 0; i < 3; i++){
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner scanner = new Scanner(System.in);
            response = scanner.nextInt();

            if(response > 0  || response <= 3){
                int monthSelected = response;
                System.out.println(monthSelected + ". " + UIMenu.MONTHS[monthSelected]);

                System.out.println("Insert the date available: [dd/mm/yyyy]");

                String date = scanner.nextLine();
                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responsoeDate = Integer.valueOf(scanner.nextLine());

                if(response == 2) continue;

                int responseTime = 0;
                String time = " ";

                do{
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = scanner.nextLine(); /// tengo que ver esta linea
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(scanner.nextLine());
                }while(responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);

            } else if(response == 0){
                showDoctorMenu();
            }else{
                System.out.println("Please select a correct answer");
            }
        }while(response!=0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
