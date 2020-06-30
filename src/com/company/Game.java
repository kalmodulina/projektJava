package com.company;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class Game {
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Project> projects = new ArrayList<Project>();
    private ArrayList<Project> availableProjects = new ArrayList<Project>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Employee> availableEmployees = new ArrayList<Employee>();
    private Company company = new Company();
    private LocalDate localDate = LocalDate.of(2020 , 1 , 1);
    private Locale polish = new Locale("pl", "PL");

    public Game() {
        this.addClientPool();
        this.addProjectPool();
        this.setupAvailableProjects();
        this.addContractorPool();
        this.addEmployeePool();
        this.setupAvailableEmployees();
        this.showMenu();
    }

    private void addClientPool() {
        clients.add(new Client("Adam Nowak", ClientType.EASY));
        clients.add(new Client("Jan Kowalski", ClientType.EASY));
        clients.add(new Client("Grzegorz Brzęczyszczykiewicz", ClientType.MEDIUM));
        clients.add(new Client("Allegro", ClientType.MEDIUM));
        clients.add(new Client("WP", ClientType.MEDIUM));
        clients.add(new Client("Onet", ClientType.EASY));
        clients.add(new Client("Facebook", ClientType.HARD));
        clients.add(new Client("Amazon", ClientType.HARD));
        clients.add(new Client("Google", ClientType.HARD));
        clients.add(new Client("Amazon", ClientType.HARD));
        clients.add(new Client("Zosia Wąsek", ClientType.EASY));
        clients.add(new Client("Edward Nożycoręki", ClientType.MEDIUM));
    }

    private Client getRandomClient()
    {
        Random random = new Random();
        return this.clients.get(random.nextInt(this.clients.size()));
    }

    private void addContractorPool() {
        Contractor contractor;
        contractor = new Contractor("Jan Nowak", ContractorType.EXPENSIVE);
        setupRandomTechnologiesToContractor(contractor);

        contractor = new Contractor("Zosia Kowalska", ContractorType.NORMAL);
        setupRandomTechnologiesToContractor(contractor);

        contractor = new Contractor("Pan Mądraliński", ContractorType.CHEAP);
        setupRandomTechnologiesToContractor(contractor);
    }

    private void setupRandomTechnologiesToContractor(Contractor contractor) {
        while (contractor.technologies.size() < new Random().nextInt(5) + 2) {
            Technology technology = Technology.values()[(new Random().nextInt(Technology.values().length))];
            if (!contractor.technologies.contains(technology)) {
                contractor.technologies.add(technology);
            }
        }
    }

    private void addEmployeePool() {
        Employee employee;
        employee = new Employee("Adam Waś", 6000.0, EmployeeType.PROGRAMMER);
        setupRandomTechnologiesToProgrammer(employee);
        employees.add(employee);

        employee = new Employee("Ewa Welon", 7200.0, EmployeeType.PROGRAMMER);
        setupRandomTechnologiesToProgrammer(employee);
        employees.add(employee);

        employee = new Employee("Zbigniew Rola", 4300.0, EmployeeType.PROGRAMMER);
        setupRandomTechnologiesToProgrammer(employee);
        employees.add(employee);

        employees.add(new Employee("Ewa Bal", 3100.0, EmployeeType.TESTER));
        employees.add(new Employee("Zosia Wilk", 4200.0, EmployeeType.TESTER));
        employees.add(new Employee("Piotr Szewc", 3600.0, EmployeeType.TESTER));

        employees.add(new Employee("Michał Lok", 3200.0, EmployeeType.SELLER));
        employees.add(new Employee("Renata Wał", 2600.0, EmployeeType.SELLER));
        employees.add(new Employee("Marcin Erka", 2900.0, EmployeeType.SELLER));

    }

    private void setupRandomTechnologiesToProgrammer(Employee employee) {
        while (employee.technologies.size() < new Random().nextInt(5) + 2) {
            Technology technology = Technology.values()[(new Random().nextInt(Technology.values().length))];
            if (!employee.technologies.contains(technology)) {
                employee.technologies.add(technology);
            }
        }
    }

    private void setupAvailableEmployees() {
        while (availableEmployees.size() < 2) {
            Employee employee = this.employees.get(new Random().nextInt(this.employees.size()));
            if (!availableEmployees.contains(employee)) {
                availableEmployees.add(employee);
            }
        }
    }

    private void addProjectPool() {
        Project project;
        project = new Project("Projekt  sklepu internetowego", getRandomClient(), new Random().nextInt(16) + 5,
                200.0, 2100.0, new Random().nextInt(9) + 2, ProjectType.EASY);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.PRESTASHOP, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt bazy danych", getRandomClient(), new Random().nextInt(16) + 5,
                300.0, 3000.0, new Random().nextInt(9) + 2, ProjectType.MEDIUM);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.DATABASE, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.BACKEND, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt aplikacji webowej", getRandomClient(), new Random().nextInt(16) + 5,
                1000.0, 20000.0, new Random().nextInt(9) + 2, ProjectType.HARD);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.BACKEND, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.DATABASE, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.FRONT_END, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt aplikacji mobilnej", getRandomClient(), new Random().nextInt(16) + 5,
                1200.0, 25000.0, new Random().nextInt(9) + 2, ProjectType.MEDIUM);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.MOBILE, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.BACKEND, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.DATABASE, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt aplikacji webowej i mobilnej", getRandomClient(), new Random().nextInt(16) + 5,
                2000.0, 40000.0, new Random().nextInt(9) + 2, ProjectType.HARD);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.FRONT_END, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.BACKEND, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.MOBILE, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.DATABASE, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt statycznej strony internetowej", getRandomClient(), new Random().nextInt(16) + 5,
                100.0, 1000.0, new Random().nextInt(9) + 2, ProjectType.EASY);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.WORDPRESS, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt dynamicznej strony internetowej", getRandomClient(), new Random().nextInt(16) + 5,
                200.0, 1500.0, new Random().nextInt(9) + 2, ProjectType.MEDIUM);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.FRONT_END, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.WORDPRESS, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt bazy danych dla aplikacji webowej", getRandomClient(), new Random().nextInt(16) + 5,
                250.0, 1500.0, new Random().nextInt(9) + 2, ProjectType.EASY);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.DATABASE, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt gry na urządzenia mobilne", getRandomClient(), new Random().nextInt(16) + 5,
                1200.0, 10000.0, new Random().nextInt(9) + 2, ProjectType.HARD);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.MOBILE, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.BACKEND, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.DATABASE, new Random().nextInt(9) + 2));
        projects.add(project);

        project = new Project("Projekt gry komuterowej", getRandomClient(), new Random().nextInt(16) + 5,
                2200.0, 15000.0, new Random().nextInt(9) + 2, ProjectType.MEDIUM);
        project.technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.BACKEND, new Random().nextInt(9) + 2));
        project.technologiesWithDays.add(new AbstractMap.SimpleEntry<Technology, Integer>(Technology.DATABASE, new Random().nextInt(9) + 2));
        projects.add(project);
    }

    private void setupAvailableProjects() {
        while (availableProjects.size() < 3) {
            Project project = this.projects.get(new Random().nextInt(this.projects.size()));
            if (!availableProjects.contains(project)) {
                availableProjects.add(project);
            }
        }
    }

    private void showMenu() {

        int choice;

        do
        {
            if(company.getBudget() < 0)
            {
                choice = 13;
                System.out.println("Przegrana ! Niestety stan konta Twojej firmy spadł poniżej 0 i przegrywasz.");
                System.out.println("-------------------------\n");
            }
            else {
                printMenuOptions(localDate, polish);

                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showAvailableProjects();
                        break;
                    case 2:
                        showAvailableEmployees();
                        break;
                    case 3:
                        System.out.println("Stan konta Twojej firmy: " + company.getBudget());
                        break;
                    case 4:
                        break;
                    case 5:
                        implementNewProject();
                        break;
                    case 6:
                        searchNewClients();
                        localDate = localDate.plusDays(1);
                        break;
                    case 7:
                        localDate = localDate.plusDays(1);
                        break;
                    case 8:
                        localDate = localDate.plusDays(1);
                        break;
                    case 9:
                        localDate = localDate.plusDays(1);
                        break;
                    case 10:
                        localDate = localDate.plusDays(1);
                        break;
                    case 11:
                        localDate = localDate.plusDays(1);
                        break;
                    case 12:
                        localDate = localDate.plusDays(1);
                        break;
                    case 13:
                        System.out.println("Szkoda, że już kończysz grę. Mam nadzieję, że zobaczymy się niedługo ponownie.");
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór opcji. Spróbuj jeszcze raz.");
                }
            }
        } while (choice != 13);
    }

    private static void printMenuOptions(LocalDate localDate, Locale polish) {
        System.out.println("\nDzisiejsza data: " + localDate);
        System.out.println("Dzień tygodnia: " + localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        System.out.println("-------------------------\n");
        System.out.println("Wybierz opcję wpisując odpowiednią cyfrę:\n");
        System.out.println("1 - Przejrzyj dostępne projekty");
        System.out.println("2 - Przejrzyj dostępnych pracowników");
        System.out.println("3 - Sprawdź stan konta");
        System.out.println("4 - Sprawdź stan realizacji poszczególnych projektów");
        System.out.println("5 - Podpisz umowę na realizację nowego projektu");
        System.out.println("6 - Szukaj klientów");
        System.out.println("7 - Programuj");
        System.out.println("8 - Testuj");
        System.out.println("9 - Oddaj gotowy projekt klientowi");
        System.out.println("10 - Zatrudnij nowego pracownika");
        System.out.println("11 - Zwolnij pracownika");
        System.out.println("12 - Rozlicz się z urzędami");
        System.out.println("13 - Wyjście\n");
    }

    private void showAvailableProjects() {
        if (this.availableProjects.size() == 0 ) {
            System.out.println("Brak dostępnych projektów");
            System.out.println("-------------------------\n");
        }
        else {
            System.out.println("Dostępne projekty:\n");
            for(Project project : this.availableProjects) {
                System.out.println(project);
            }
        }
    }

    private void showAvailableEmployees() {
        if (this.availableEmployees.size() == 0 ) {
            System.out.println("Brak dostępnych pracowników");
            System.out.println("-------------------------\n");
        }
        else {
            System.out.println("Dostępni pracownicy:\n");
            for(Employee employee : this.availableEmployees) {
                System.out.println(employee);
            }
        }
    }

    private void implementNewProject() {

        int index = 0;
        for (Project project : this.availableProjects) {
            System.out.println("Numer projektu: " + ++index + "\n" + project);
        }

        System.out.println("Podaj numer projektu: ");
        Scanner scanner = new Scanner(System.in);
        int projectNumber = scanner.nextInt();
        if (projectNumber <= this.availableProjects.size() && projectNumber > 0) {
            Project project = this.availableProjects.get(projectNumber - 1);
            if (project.getProjectType() == ProjectType.HARD && company.getEmployees().size() <= 0) {
                System.out.println("Wybrany przez Ciebie projekt należy do złożonych, aby go zrealizować musisz zatrudnić pracownika." +
                        "Nie mając pracowników możesz realizować tylko proste i średnie projekty.");
                System.out.println("-------------------------\n");
            }
            else {
                this.availableProjects.remove(this.availableProjects.get(projectNumber - 1));
                localDate = localDate.plusDays(1);
                System.out.println("Gratulacje ! Podpisałeś umowę na realizacje nowego projektu.");
                System.out.println("-------------------------\n");
            }
        }
        else {
            System.out.println("Brak dostępnego projektu o podanym przez Ciebie numerze.");
            System.out.println("-------------------------\n");
        }


    }

    private void searchNewClients() {
        Project newProject = this.projects.get(new Random().nextInt(this.projects.size()));
        this.availableProjects.add(newProject);
    }
}
