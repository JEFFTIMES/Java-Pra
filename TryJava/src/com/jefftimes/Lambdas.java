package com.jefftimes;

/**
 * declaring an interface with single method, the method takes the same types and numbers of parameters
 * as that of the lambda will be taken as the parameter.
 * declaring it with FunctionalInterface notation.
 */
@FunctionalInterface
interface InterfaceStringConcat {
    String concat(String m, String n);
}

/**
 * declaring a new class to enclose the definition of lambda expression
 * assigns the lambda expression to an variable type of the defined interface
 * and define a method to take the interface as a parameter
 */
class ConcatStringWithLambda {
    //define a lambda expression inside the class, assign it to an attribute.
    InterfaceStringConcat lambdaAttr = (m, n) -> m + n;
    //declaring a method with the parameters to be processed with the lambda expr
    //and the lambda parameter together.
    //in this method, call the method of the functional interface with the lambda attribute.
    protected String concatString(String m, String n, InterfaceStringConcat lambda){

        return lambda.concat(m, n);

    }

}


