package Parse_Tree;

public class Node_Program {

    // Parent
    private String program;

    // Children
    private String function;
    private String function_id;
    private String block;
    private String end;

    // Variables
    private String function_statement;
    private boolean syntax_error;

    // Constructors
    public Node_Program(){ }
    public Node_Program(String program){
        // Store program string
        this.program = program.trim();

        // Identify children
        function_statement = this.program.substring(0, this.program.indexOf("\n"));
        function = function_statement.substring(0, function_statement.indexOf(" "));
        function_id = function_statement.substring(program.indexOf(" ")).trim();
        block = this.program.substring(this.program.indexOf("\n"), Math.max(this.program.lastIndexOf(" "), this.program.lastIndexOf("\n"))).trim();
        end = this.program.substring(Math.max(this.program.lastIndexOf(" "), this.program.lastIndexOf("\n") )+1);

        // Syntax check
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
        System.out.println("Program node, children:");
        System.out.printf("\tfunction: \'%s\'\n", function);
        System.out.printf("\tfunction id: \'%s\'\n", function_id);
        System.out.printf("\tblock: \'%s\'\n", block);
        System.out.printf("\tend: \'%s\'\n", end);
    }
    public void display_error(){
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
