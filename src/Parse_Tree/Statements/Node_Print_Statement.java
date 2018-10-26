package Parse_Tree.Statements;

import Parse_Tree.Expressions.Node_Arithmetic_Expression;

public class Node_Print_Statement {

    // Parent
    private String print_statement;

    // Children
    private Node_Arithmetic_Expression child_node_arithmetic_expression;

    private String child_print;
    private String child_arithmetic_expression;
    private boolean syntax_error;

    public Node_Print_Statement(String print_statement){
        syntax_error = false;
        this.print_statement = print_statement.trim();

        // identify children
        if(this.print_statement.contains("(")&& this.print_statement.contains(")")) {
            child_print = this.print_statement.substring(0, this.print_statement.indexOf("(")).trim();
            child_arithmetic_expression = this.print_statement.substring(this.print_statement.indexOf("(")+1, this.print_statement.indexOf(")")).trim();
            syntax_error();
        }
        else
            syntax_error=true;

        if(!syntax_error)
            expand();
    }

    private boolean syntax_error(){
        syntax_error = print_error() || arithmetic_expression_error();
        return syntax_error;
    }
    private boolean print_error(){
        if(!child_print.equals("print"))
            return true;
        return false;
    }
    private boolean arithmetic_expression_error(){
        return false;
    }

    // Create children
    private void expand(){
        child_node_arithmetic_expression = new Node_Arithmetic_Expression(child_arithmetic_expression);
    }

    // Output
    public void display_node(){

    }
    private void display_error(){
        if(!syntax_error());

        else {

        }
    }
}
