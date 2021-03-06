package com.adolfo.model;

import com.adolfo.controller.AppController;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {


    private static AppController app;

    public Menu() {

        app = new AppController();
        app.loadGuns();

    }


//     I call here the first menu, where they can choose "add", "delete" or "show"


    public static void initialMenu() {

        int option;


        while ((option = showInitialMenu()) != 0) {

            switch (option) {

                case 1:
                    addWeapon();
                    break;
                case 2:
                    deleteWeapon();
                    break;
                case 3:
                    showWeapon();
                    break;
                case 4:
                    modifyWeapon();
                    break;
                case 5:
                    ordinateWeaponByGauge();
                    break;
                case 6:
                    alphabeticOrdination();
                    break;
                case 7:
                    ordinationByAmmoInMagazine();
                    break;
                case 8:
                    alphabeticOrdinationByCountry();
            }
        }
        app.saveWeapons();
    }


//    This is the first menu we will show

    private static int showInitialMenu() {

        Scanner input = new Scanner(System.in);

        int option = 0;

        System.out.println("*********************************");
        System.out.println("*      Choose one option        *");
        System.out.println("*                               *");
        System.out.println("*      1 - Add weapon           *");
        System.out.println("*      2 - Delete weapon        *");
        System.out.println("*      3 - Show weapons         *");
        System.out.println("*      4 - Modify weapon        *");
        System.out.println("*      5 - Sort by gauge        *");
        System.out.println("*      6 - Sort by name         *");
        System.out.println("*      7 - Sort by magazine     *");
        System.out.println("*      8 - Sort by country      *");
        System.out.println("*      0 - Exit                 *");
        System.out.println("*********************************");
        System.out.println("Option: ");

        try {
            option = input.nextInt();
            input.nextLine();
            if (option < 0) {
                System.out.println("Choose a valid value, please.");
            } else if (option > 8) {
                System.out.println("Choose a valid value, please.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid value, choose one that is in the list");
            initialMenu();
        }
        return option;

    }

//      This one is the menu were the client choose the type of weapon he/she wants to "add", "delete" or "show"

    public static int selectWeapons() {
        Scanner input = new Scanner(System.in);

        int option = 0;

        System.out.println("***********************************************");
        System.out.println("*              What kind of weapon?           *");
        System.out.println("*                                             *");
        System.out.println("*              1 - Assault Rifles             *");
        System.out.println("*              2 - Rifles                     *");
        System.out.println("*              3 - Sub-Machine guns           *");
        System.out.println("*              4 - Sniper Rifles              *");
        System.out.println("*              0 - Go back                    *");
        System.out.println("***********************************************");
        try {
            System.out.println("Option: ");
            option = input.nextInt();
            input.nextLine();
            if (option < 0) {
                System.out.println("Choose a valid value, please.");
            } else if (option > 4) {
                System.out.println("Choose a valid value, please.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid value, we return you to the main menu.");
        }
        return option;
    }


    // Menu to choose what you want to edit from the weapon

    public static int modifyWeaponMenu(){
        Scanner input = new Scanner(System.in);

        int option = 0;

        System.out.println("***********************************************");
        System.out.println("*         What do you want to change?         *");
        System.out.println("*                                             *");
        System.out.println("*              1 - Name                       *");
        System.out.println("*              2 - Origin Country             *");
        System.out.println("*              3 - Ammo in the clip           *");
        System.out.println("*              4 - Gauge                      *");
        System.out.println("*              0 - Go back                    *");
        System.out.println("***********************************************");

        try {
            System.out.println("Option: ");
            option = input.nextInt();
            input.nextLine();
            if (option < 0) {
                System.out.println("Choose a valid option, please.");
            } else if (option > 4) {
                System.out.println("Choose a valid option, please.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid value, we return you to the main menu.");
        }

        return option;
    }


//    With these two methods we know in what category we are gonna add the weapon you want

    private static int menuAddWeapon() {

        int option;
        option = selectWeapons();
        return option;

    }

    public static void addWeapon() {

        int option;

        while ((option = menuAddWeapon()) != 0) {

            switch (option) {
                case 1:
                    app.addAssaultRifle();
                    break;
                case 2:
                    app.addRifle();
                    break;
                case 3:
                    app.addSubMachine();
                    break;
                case 4:
                    app.addSniperRifle();
                    break;
            }
        }
    }

//    With these two methods we know what category weapons we are gonna show

    private static int menuShowWeapon() {
        int option;
        option = selectWeapons();
        return option;

    }

    public static void showWeapon() {

        int option;

        while ((option = menuShowWeapon()) != 0) {
            switch (option) {
                case 1:
                    app.showAssaultRifleList();
                    break;
                case 2:
                    app.showRifleList();
                    break;
                case 3:
                    app.showSubMachineList();
                    break;
                case 4:
                    app.showSniperRifleList();
                    break;
            }
        }
    }

//   With these two methods we know from what category you want to delete a weapon

    private static int menuDeleteWeapon() {
        int option;
        option = selectWeapons();
        return option;
    }

    public static void deleteWeapon() {

        int option;

        while ((option = menuDeleteWeapon()) != 0) {

            switch (option) {

                case 1:
                    app.deleteAssaultRifle();
                    break;
                case 2:
                    app.deleteRifle();
                    break;
                case 3:
                    app.deleteSubMachine();
                    break;
                case 4:
                    app.deleteSniperRifle();
                    break;
            }
        }
    }

//  With these two methods we know from what category you want to modify a weapon

    private static int menuModifyWeapon() {
        int option;
        option = selectWeapons();
        return option;

    }


    public static void modifyWeapon() {
        int option;

        while ((option = menuModifyWeapon()) != 0) {

            switch (option) {

                case 1:
                    app.modifyAssaultRifle();
                    break;
                case 2:
                    app.modifyRifle();
                    break;
                case 3:
                    app.modifySubMachineGun();
                    break;
                case 4:
                    app.modifySniperRifle();
                    break;
            }
        }
    }

//  With these methods we know what category weapons we have to show ordered by the gauge

    private static int menuOrdinateWeaponByGauge() {
        int option;
        option = selectWeapons();
        return option;

    }

    public static void ordinateWeaponByGauge() {

        int option;

        while ((option = menuOrdinateWeaponByGauge()) != 0) {

            switch (option) {

                case 1:
                    app.ordinationAssaultRiflesByGauge();
                    break;
                case 2:
                    app.ordinationRiflesByGauge();
                    break;
                case 3:
                    app.ordinationSubMachineByGauge();
                    break;
                case 4:
                    app.ordinationSniperRiflesByGauge();
                    break;
            }
        }
    }

//  With these methods we know what category weapons we have to show ordered alphabetically by their names

    private static int menuAlphabeticOrdination() {
        int option;
        option = selectWeapons();
        return option;
    }

    public static void alphabeticOrdination() {

        int option;

        while ((option = menuAlphabeticOrdination()) != 0) {

            switch (option) {

                case 1:
                    app.alphabeticOrdinationAssaultRiflesByName();
                    break;
                case 2:
                    app.alphabeticOrdinationRiflesByName();
                    break;
                case 3:
                    app.alphabeticOrdinationSubMachineByName();
                    break;
                case 4:
                    app.alphabeticOrdinationSniperRiflesByName();
                    break;
            }
        }
    }

//  With these methods we know what category weapons we have to show ordered alphabetically by the origin country

    private static int menuAlphabeticOrdinationByCountry() {
        int option;
        option = selectWeapons();
        return option;
    }

    public static void alphabeticOrdinationByCountry() {

        int option;

        while ((option = menuAlphabeticOrdinationByCountry()) != 0) {

            switch (option) {

                case 1:
                    app.alphabeticOrdinationAssaultRiflesByCountry();
                    break;
                case 2:
                    app.alphabeticOrdinationRiflesByCountry();
                    break;
                case 3:
                    app.alphabeticOrdinationSubMachineByCountry();
                    break;
                case 4:
                    app.alphabeticOrdinationSniperRiflesByCountry();
                    break;
            }
        }
    }

//  With these methods we know what category weapons we have to show ordered by the amount of ammo in the magazine

    private static int menuOrdinationByAmountOfCharger() {
        int option;
        option = selectWeapons();
        return option;
    }

    public static void ordinationByAmmoInMagazine() {

        int option;

        while ((option = menuOrdinationByAmountOfCharger()) != 0) {

            switch (option) {

                case 1:
                    app.ordinationAssaultRiflesByAmmoInMagazine();
                    break;
                case 2:
                    app.ordinationRiflesByAmmoInMagazine();
                    break;
                case 3:
                    app.ordinationSubMachineByAmmoInMagazine();
                    break;
                case 4:
                    app.ordinationSniperRiflesByAmmoInMagazine();
                    break;
            }
        }
    }


}

