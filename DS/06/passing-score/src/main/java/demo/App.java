package demo;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    // In the course syllabus, there's a mapping
    // from numbers to letter grades.

    // An F is a failing grade, anything else passes.
    
    // Design a method that takes a score and determines
    // if that score will pass or not, called passingScore.

    /**
     * Determines whether or not a score is a passing grade
     * 
     * @param  score  A sudent's score, probably in 0.0-100.0
     * @return        Whether the student passed.
     */
    static boolean passingScore(float score) {
        return score >= 60;
    }

    // Examples:
    //    87.0 => true
    //    25.0 => false

}
