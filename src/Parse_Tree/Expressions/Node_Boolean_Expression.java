package Parse_Tree.Expressions;

import Parse_Tree.Tokens.Lexemes;

public class Node_Boolean_Expression {

    // Parent
    private String boolean_expression;

    // Children
    private Node_Arithmetic_Expression child_node_arithmetic_expression1, child_node_arithmetic_expression2;

    // Variables
    private String child_arithmetic_expression1;
    private String child_arithmetic_expression2;
    private String child_relative_op;
    private boolean syntax_error;

    // Constructors
    public Node_Boolean_Expression(){}
    public Node_Boolean_Expression(String boolean_expression){
        // Store block string
        this.boolean_expression = boolean_expression.trim();

        // identify children
        if(this.boolean_expression.contains(Lexemes.le_operator)) {
            child_arithmetic_expression1 = this.boolean_expression.substring(0, this.boolean_expression.indexOf(Lexemes.le_operator)).trim();
            child_relative_op = "le_operator";
            child_arithmetic_expression1 = this.boolean_expression.substring(this.boolean_expression.indexOf(Lexemes.le_operator) + Lexemes.le_operator.length() + 1).trim();
        } else if (this.boolean_expression.contains(Lexemes.lt_operator)) {
            child_arithmetic_expression1 = this.boolean_expression.substring(0, this.boolean_expression.indexOf(Lexemes.lt_operator)).trim();
            child_relative_op = "lt_operator";
            child_arithmetic_expression1 = this.boolean_expression.substring(this.boolean_expression.indexOf(Lexemes.lt_operator)+Lexemes.lt_operator.length()+1).trim();
        } else if (this.boolean_expression.contains(Lexemes.ge_operator)){
            child_arithmetic_expression1 = this.boolean_expression.substring(0, this.boolean_expression.indexOf(Lexemes.ge_operator)).trim();
            child_relative_op = "ge_operator";
            child_arithmetic_expression1 = this.boolean_expression.substring(this.boolean_expression.indexOf(Lexemes.ge_operator)+Lexemes.ge_operator.length()+1).trim();
        } else if (this.boolean_expression.contains(Lexemes.gt_operator)){
            child_arithmetic_expression1 = this.boolean_expression.substring(0, this.boolean_expression.indexOf(Lexemes.gt_operator)).trim();
            child_relative_op = "gt_operator";
            child_arithmetic_expression1 = this.boolean_expression.substring(this.boolean_expression.indexOf(Lexemes.gt_operator)+Lexemes.gt_operator.length()+1).trim();
        } else if (this.boolean_expression.contains(Lexemes.ne_operator)){
            child_arithmetic_expression1 = this.boolean_expression.substring(0, this.boolean_expression.indexOf(Lexemes.ne_operator)).trim();
            child_relative_op = "ne_operator";
            child_arithmetic_expression1 = this.boolean_expression.substring(this.boolean_expression.indexOf(Lexemes.ne_operator)+Lexemes.ne_operator.length()+1).trim();
        } else if (this.boolean_expression.contains(Lexemes.eq_operator)){
            child_arithmetic_expression1 = this.boolean_expression.substring(0, this.boolean_expression.indexOf(Lexemes.eq_operator)).trim();
            child_relative_op = "eq_operator";
            child_arithmetic_expression1 = this.boolean_expression.substring(this.boolean_expression.indexOf(Lexemes.eq_operator)+Lexemes.eq_operator.length()+1).trim();
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
