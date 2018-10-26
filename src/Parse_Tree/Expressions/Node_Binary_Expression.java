package Parse_Tree.Expressions;

import Parse_Tree.Tokens.Lexemes;

public class Node_Binary_Expression {

    // Parent
    private String binary_expression;

    // Children
    private Node_Arithmetic_Expression child_node_arithmetic_expression1, child_node_arithmetic_expression2;

    // Variables
    private String child_arithmetic_expression1;
    private String child_arithmetic_op;
    private String child_arithmetic_expression2;
    private boolean syntax_error;

    public Node_Binary_Expression(){}
    public Node_Binary_Expression(String binary_expression){
        this.binary_expression = binary_expression;
        // identify children
        if(this.binary_expression.contains(Lexemes.add_operator)) {
            child_arithmetic_expression1 = this.binary_expression.substring(0, this.binary_expression.indexOf(Lexemes.add_operator)).trim();
            child_arithmetic_op = "add_operator";
            child_arithmetic_expression2 = this.binary_expression.substring(this.binary_expression.indexOf(Lexemes.add_operator) + 1).trim();
        } else if (this.binary_expression.contains(Lexemes.sub_operator)) {
            child_arithmetic_expression1 = this.binary_expression.substring(0, this.binary_expression.indexOf(Lexemes.sub_operator)).trim();
            child_arithmetic_op = "sub_operator";
            child_arithmetic_expression2 = this.binary_expression.substring(this.binary_expression.indexOf(Lexemes.sub_operator) + 1).trim();
        } else if (this.binary_expression.contains(Lexemes.mul_operator)) {
            child_arithmetic_expression1 = this.binary_expression.substring(0, this.binary_expression.indexOf(Lexemes.mul_operator)).trim();
            child_arithmetic_op = "mul_operator";
            child_arithmetic_expression2 = this.binary_expression.substring(this.binary_expression.indexOf(Lexemes.mul_operator) + 1).trim();
        } else if (this.binary_expression.contains(Lexemes.div_operator)) {
            child_arithmetic_expression1 = this.binary_expression.substring(0, this.binary_expression.indexOf(Lexemes.div_operator)).trim();
            child_arithmetic_op = "div_operator";
            child_arithmetic_expression2 = this.binary_expression.substring(this.binary_expression.indexOf(Lexemes.sub_operator) + 1).trim();
        } else if (this.binary_expression.contains(Lexemes.mod_operator)) {
            child_arithmetic_expression1 = this.binary_expression.substring(0, this.binary_expression.indexOf(Lexemes.mod_operator)).trim();
            child_arithmetic_op = "mod_operator";
            child_arithmetic_expression2 = this.binary_expression.substring(this.binary_expression.indexOf(Lexemes.mod_operator) + 1).trim();
        } else if (this.binary_expression.contains(Lexemes.rev_div_operator)) {
            child_arithmetic_expression1 = this.binary_expression.substring(0, this.binary_expression.indexOf(Lexemes.rev_div_operator)).trim();
            child_arithmetic_op = "rev_div_operator";
            child_arithmetic_expression2 = this.binary_expression.substring(this.binary_expression.indexOf(Lexemes.rev_div_operator) + 1).trim();
        } else if (this.binary_expression.contains(Lexemes.exp_operator)) {
            child_arithmetic_expression1 = this.binary_expression.substring(0, this.binary_expression.indexOf(Lexemes.exp_operator)).trim();
            child_arithmetic_op = "exp_operator";
            child_arithmetic_expression2 = this.binary_expression.substring(this.binary_expression.indexOf(Lexemes.exp_operator) + 1).trim();
        }

        expand();
    }

    private boolean syntax_error(){
        return syntax_error;
    }

    // Create children
    private void expand(){

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
