package Parse_Tree;

public class Node_Program {

    // Variables
    private String program;
    private String function;
    private String function_statement;
    private String function_id;
    private String block;
    private String end;
    private boolean syntax_error;

    // Constructors
    public Node_Program(){ }
    public Node_Program(String program){
        this.program = program.trim();
        function_statement = this.program.substring(0, this.program.indexOf("\n"));
        function = function_statement.substring(0, function_statement.indexOf(" "));
        function_id = function_statement.substring(program.indexOf(" ")).trim();

        block = program.substring(program.indexOf("\n"), program.lastIndexOf(" ")).trim();
        end = this.program.substring(Math.max(this.program.lastIndexOf(" "), program.lastIndexOf("\n") )+1);

        syntax_error = function_error() || function_id_error() || end_error();
    }

    // Methods

    // Syntax check
    private boolean syntax_error(){
        return syntax_error;
    }
    private boolean function_error(){
        if(function.equals("function"))
            return false;
        else
            return true;
    }
    private boolean function_id_error(){
        if(true)
            return false;
        else
            return true;
    }
    private boolean end_error(){
        if(true)
            return false;
        else
            return true;
    }

    // Output
    public void display_node(){
        if(!syntax_error())
            System.out.println("No errors found in Program Node");
        else {
            if(function_error()) {
                System.out.println("Error in function statement");
                System.out.printf("\tfunction: \'%s\' where it\'s supposed to be \'function'\n", function);
            }
            if(function_id_error()) {
                System.out.println("Error in function id");
                System.out.printf("\tfunction id: \'%s\'\n", function_id);
            }
            if(end_error()) {
                System.out.println("Error in end statement");
                System.out.printf("\tend: \'%s\'\n", end);
            }
        }
    }
}
