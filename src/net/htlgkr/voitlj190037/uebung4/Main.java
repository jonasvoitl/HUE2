package net.htlgkr.voitlj190037.uebung4;

import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            System.out.println("Choose calculator:\n1 - Rational calculator\n2 - Vector calculator\n3 - Complex calculator\n4 - Exit program");
            String userInput = s.nextLine();

            switch (userInput) {
                case "1":
                    RationalCalculator rc = createRationalCalculator();

                    //Schleife wird nur 1 mal durchlaufen außer i wird bei case 5 um 1 erhöht weil die Zahlen neu eingegeben werden müssen
                    for (int i = 1; i > 0; i--) {
                        Number x = askForNumber("x");
                        Number y = askForNumber("y");
                        String operationID = askForOperation();
                        Number solution;
                        switch (operationID) {
                            case "1" -> {
                                solution = rc.add(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "2" -> {
                                solution = rc.subtract(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "3" -> {
                                solution = rc.multiply(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "4" -> {
                                solution = rc.divide(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "5" -> i++;
                        }
                    }
                    break;
                case "2":
                    VectorCalculator vc = createVectorCalculator();

                    //Schleife wird nur 1 mal durchlaufen außer i wird bei case 5 um 1 erhöht weil die Zahlen neu eingegeben werden müssen
                    for (int i = 1; i > 0; i--) {
                        Number x = askForNumber("x");
                        Number y = askForNumber("y");
                        String operationID = askForOperation();
                        Number solution;
                        switch (operationID) {
                            case "1" -> {
                                solution = vc.add(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "2" -> {
                                solution = vc.subtract(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "3" -> {
                                solution = vc.multiply(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "4" -> {
                                solution = vc.divide(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "5" -> i++;
                        }
                    }
                    break;
                case "3":
                    ComplexCalculator cc = createComplexCalculator();

                    //Schleife wird nur 1 mal durchlaufen außer i wird bei case 5 um 1 erhöht weil die Zahlen neu eingegeben werden müssen
                    for (int i = 1; i > 0; i--) {
                        Number x = askForNumber("x");
                        Number y = askForNumber("y");
                        String operationID = askForOperation();
                        Number solution;
                        switch (operationID) {
                            case "1" -> {
                                solution = cc.add(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "2" -> {
                                solution = cc.subtract(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "3" -> {
                                solution = cc.multiply(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "4" -> {
                                solution = cc.divide(x, y);
                                System.out.println("Solution:\na = " + solution.getA() + "\nb = " + solution.getB());
                            }
                            case "5" -> i++;
                        }
                    }
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect input.");
                    break;
            }
        }
    }

    private static RationalCalculator createRationalCalculator() {
        CalculateOperation rcAdd = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            double xBtemp = xB;
            double yBtemp = yB;

            //gibt an wie oft der Nenner von x (xBtemp) multipliert worden ist um das kgV zu finden
            int xBtempMultiples = 1;

            //gibt an wie oft der Nenner von y (yBtemp) multipliert worden ist um das kgV zu finden
            int yBtempMultiples = 1;

            //Berechnung des kgV
            while (xBtemp != yBtemp) {
                if (xBtemp < yBtemp) {
                    xBtemp += xB;
                    xBtempMultiples++;
                } else {
                    yBtemp += yB;
                    yBtempMultiples++;
                }
            }

            Number solution = new Number();
            solution.setA((xA * xBtempMultiples) + (yA * yBtempMultiples));
            solution.setB(xBtemp);
            return solution;
        };

        CalculateOperation rcSubtract = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            double xBtemp = xB;
            double yBtemp = yB;

            //gibt an wie oft der Nenner von x (xBtemp) multipliert worden ist um das kgV zu finden
            int xBtempMultiples = 1;

            //gibt an wie oft der Nenner von y (yBtemp) multipliert worden ist um das kgV zu finden
            int yBtempMultiples = 1;

            //Berechnung des kgV
            while (xBtemp != yBtemp) {
                if (xBtemp < yBtemp) {
                    xBtemp += xB;
                    xBtempMultiples++;
                } else {
                    yBtemp += yB;
                    yBtempMultiples++;
                }
            }

            Number solution = new Number();
            solution.setA((xA * xBtempMultiples) - (yA * yBtempMultiples));
            solution.setB(xBtemp);
            return solution;
        };

        CalculateOperation rcMultiply = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA(xA * yA);
            solution.setB(xB * yB);
            return solution;
        };

        CalculateOperation rcDivide = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA(xA * yB);
            solution.setB(xB * yA);
            return solution;
        };

        return new RationalCalculator(rcAdd, rcSubtract, rcMultiply, rcDivide);
    }

    private static VectorCalculator createVectorCalculator() {
        CalculateOperation vcAdd = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA(xA + yA);
            solution.setB(xB + yB);
            return solution;
        };

        CalculateOperation vcSubtract = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA(xA - yA);
            solution.setB(xB - yB);
            return solution;
        };

        CalculateOperation vcMultiply = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA(xA * yB);     //Kreuzprodukt von 2 dimensionalen Vektoren ist mathematisch nicht möglich
            solution.setB(xB * yA);
            return solution;
        };

        CalculateOperation vcDivide = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA((xA * yA) / xB);      //basiert nicht auf Skalarprodukt sondern auf skalare Multiplikation
            solution.setB((xA * yB) / xB);
            return solution;
        };
        return new VectorCalculator(vcAdd, vcSubtract, vcMultiply, vcDivide);
    }

    private static ComplexCalculator createComplexCalculator() {
        CalculateOperation ccAdd = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA(xA + yA);
            solution.setB(xB + yB);
            return solution;
        };

        CalculateOperation ccSubtract = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA(xA - yA);
            solution.setB(xB - yB);
            return solution;
        };

        CalculateOperation ccMultiply = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();


            double[] interimResults = new double[4];

            //Beispiel Rechnung: (5-2i) * (3+4i)
            //Schritt 1: Jedes mit jedem multiplizieren
            //5 * 3 + 5 * 4i + (-2i) * 3 + (-2i) * 4i =
            //15 + 20i -6i -8i²
            interimResults[0] = xA * yA;
            interimResults[1] = xA * yB;
            interimResults[2] = xB * yA;
            interimResults[3] = xB * yB;

            //Schritt 2: Imaginärteil addieren
            //15 + 14i - 8i²
            interimResults[1] = interimResults[1] + interimResults[2];

            //Schritt 3: das i² durch -1 ersetzen: -8i² = -8 * (-1)
            //15 + 14i + 8
            interimResults[2] = interimResults[3] * (-1);

            //Schritt 4: 15 und 8 addieren
            //23 + 14i
            interimResults[0] = interimResults[0] + interimResults[2];

            Number solution = new Number();
            solution.setA(interimResults[0]);   //23
            solution.setB(interimResults[1]);   //14i
            return solution;
        };

        CalculateOperation ccDivide = (x, y) -> {
            double xA = x.getA();
            double xB = x.getB();
            double yA = y.getA();
            double yB = y.getB();

            Number solution = new Number();
            solution.setA((xA * yA) / xB);      //basiert nicht auf Skalarprodukt sondern auf skalare Multiplikation
            solution.setB((xA * yB) / xB);
            return solution;
        };
        return new ComplexCalculator(ccAdd, ccSubtract, ccMultiply, ccDivide);
    }

    //Abfrage der Nummern in Methode ausgelagert um Redundanz zu vermeiden
    private static Number askForNumber(String name) {
        System.out.println("Enter number " + name + " a");
        double a = Double.parseDouble(s.nextLine());
        System.out.println("Enter number " + name + " b");
        double b = Double.parseDouble(s.nextLine());
        Number num = new Number();
        num.setA(a);
        num.setB(b);
        return num;
    }

    //Abfrage der Operation in Methode ausgelagert um Redundanz zu vermeiden
    private static String askForOperation() {
        System.out.println("Choose operation:\n1 - add\n2 - subtract\n3 - multiply\n4 - divide\n5 - enter numbers again");
        return s.nextLine();
    }
}

