public class ReportCard {

    private static char convertGrades(int testResult){
        char grade;

        if (testResult >=90)
        {
            grade = 'A';
        }
        else
            if (testResult >= 80 && testResult <90)
            {
            grade = 'B';
            }
            else
                if (testResult >=70 && testResult <80)
                {
                grade = 'C';
                }
            else {
            grade = 'D';
            }
        return grade;
    }

    public static void main (String[] args) {

//        ReportCard rc = new ReportCard();
        char yourGrade = convertGrades(77);
//
        System.out.println("Yours first grade is " + yourGrade);
//
//        yourGrade = rc.convetGrade(93);
//        System.out.println("Yours second grade is " + yourGrade);

        switch (yourGrade) {
            case 'A':
                System.out.println("Excellent work!");
                break;

            case 'B':
                System.out.println("Good job!");
                break;

            case 'C':
                System.out.println("You should work harder!");
                break;

            case 'D':
                System.out.println("You should take it serious!");
                break;
        }
    }
}
