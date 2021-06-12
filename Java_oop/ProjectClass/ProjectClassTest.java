public class ProjectClassTest{
    public static void main(String[] args){
        ProjectClass project1 = new ProjectClass();
        ProjectClass project2 = new ProjectClass("Python");
        ProjectClass project3 = new ProjectClass("Java", "Java Project");
        ProjectClass project4 = new ProjectClass("MERN", "MERN Project", 1000);

        project1.elevatorPitch();
        project2.elevatorPitch();
        project3.elevatorPitch();
        project4.elevatorPitch();
        System.out.println(project1.elevatorPitch());
        System.out.println(project2.elevatorPitch());
        System.out.println(project3.elevatorPitch());
        System.out.println(project4.elevatorPitch());

        //set project name, description, and initialCost
        project1.setName("1st Project");
        project1.setDescription("Project I Description");
        project1.setInitialCost(2000);
        System.out.println("Project I : "+ project1.elevatorPitch());
        project2.setInitialCost(4200);
        project2.setDescription("Project II Description !!");
        project3.setInitialCost(1200);

        System.out.println(project1.getInitialCost());
        System.out.println(project1.getProjectName());
        System.out.println(project1.getDescription());

        Portfolio portfolioNew = new Portfolio();
        portfolioNew.addProject(project1);
        portfolioNew.addProject(project2);
        portfolioNew.addProject(project3);
        portfolioNew.addProject(project4);

        System.out.println(portfolioNew.getPortfolioCost());
        portfolioNew.showPortfolio();
    }

}