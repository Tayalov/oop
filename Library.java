import java.util.ArrayList;

public class Library {
    private String name;
    private int maxBooks;
    private ArrayList<Department> departments;

    // Constructor
    public Library(String name, int maxBooks) {
        this.name = name;
        this.maxBooks = maxBooks;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Edition> searchPublicationsByYear(int year) {
        ArrayList<Edition> result = new ArrayList<>();
        for (Department department : departments) {
            for (Edition edition : department.getEditions()) {
                if (edition.getYear() == year) {
                    result.add(edition);
                }
            }
        }
        return result;
    }
    public void displayLibraryInfo() {
        System.out.println("Library: " + name);
        System.out.println("Departments:");
        for (Department department : departments) {
            department.displayDepartmentInfo();
        }
    }
}
