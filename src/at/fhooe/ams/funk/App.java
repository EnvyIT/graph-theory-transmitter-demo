package at.fhooe.ams.funk;

import at.fhooe.ams.funk.algorithm.NetworkTransmissionController;
import at.fhooe.ams.funk.util.Parser;
import java.util.Map;

public class App {

  public static void main(String[] args) {
    System.out.println("======= Transmitter Radius Calculation =======");
    if(args.length != 1) {
      System.out.println("You must call the program with args: [co-ordinates]");
      return;
    }
    String input =  args[0];
    Map<Integer, Double> actualRadii = NetworkTransmissionController.getMinimumRadiusPerTransmitter(Parser.parseGraph(input));
    NetworkTransmissionController.print(actualRadii);

  }

}
