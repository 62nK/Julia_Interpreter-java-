package Parse_Tree.Statements;

import Parse_Tree.Expressions.Node_Boolean_Expression;
import Parse_Tree.Node_Block;

public class Node_If_Statement {

    // Parent
    private String if_statement;

    // Children
    private Node_Boolean_Expression child_node_boolean_expression;
    private Node_Block child_node_block1, child_node_block2;

    // Variables
    private String child_if;
    private String child_boolean_expression;
    private String child_block1;
    private String child_else;
    private String child_block2;
    private String child_end;
    private boolean syntax_error;

    // Constructors
    public Node_If_Statement(){}
    public Node_If_Statement(String if_statement){
        syntax_error = false;
        // Store block string
        this.if_statement = if_statement.trim();

        // identify children
        if(this.if_statement.contains("if") && this.if_statement.contains("else")) {
            child_if = this.if_statement.substring(0, this.if_statement.indexOf(" ")).trim();
            child_boolean_expression = this.if_statement.substring(this.if_statement.indexOf(" "), this.if_statement.indexOf("\n")).trim();
            child_block1 = this.if_statement.substring(this.if_statement.indexOf("\n")+1).trim();
            child_else = "else";
            child_block2 = "";
            child_end = this.if_statement.substring(Math.max(this.if_statement.lastIndexOf(" "), this.if_statement.lastIndexOf("\n") )+1).trim();
            syntax_error();
        }
        else
            syntax_error=true;
        if(!syntax_error)
            expand();
    }

    private boolean syntax_error(){
        syntax_error = if_error() || boolean_expression_error() || block_error() || else_error() || end_error();
        return syntax_error;
    }
    private boolean if_error(){
        if(child_if.equals("if"))
            return true;
        return false;
    }
    private boolean boolean_expression_error(){
        return false;
    }
    private boolean block_error(){ return false; }
    private boolean else_error(){
        if(!child_else.equals("else"))
            return true;
        return false;
    }
    private boolean end_error(){
        if(!child_end.equals("end"))
            return true;
        return false; }

    // Create children
    private void expand(){
        child_node_boolean_expression = new Node_Boolean_Expression(child_boolean_expression);
        child_node_block1 = new Node_Block(child_block1);
        child_node_block2 = new Node_Block(child_block2);
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
