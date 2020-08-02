package at.fhooe.ams.funk.algorithm;

import at.fhooe.ams.funk.util.Parser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jgrapht.alg.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NetworkTransmissionControllerTest {

  private final static double DELTA = 0.0001;

  @Test
  public void simpleFunctionalTransmitterTestFromSheet() {
    String input = "{(1, 1.0), (2.5, 2.5), (4.0, 2.5)}";

    Pair<Integer, Double> transmitter1 = new Pair<>(1, 2.12132);
    Pair<Integer, Double> transmitter2 = new Pair<>(2, 2.12132);
    Pair<Integer, Double> transmitter3 = new Pair<>(3, 1.5);
    List<Pair<Integer, Double>> expectedRadii = createExpectedRadii(transmitter1, transmitter2, transmitter3);

    Map<Integer, Double> actualRadii = NetworkTransmissionController.getMinimumRadiusPerTransmitter(Parser.parseGraph(input));

    assertNetwork(expectedRadii, actualRadii);
  }

  @Test
  public void centerTransmitterCanReachAllOthers() {
    String input = "{(1,2), (2,3), (3,2), (2,1) , (2,2)}";

    Pair<Integer, Double> transmitter1 = new Pair<>(1, 1.0);
    Pair<Integer, Double> transmitter2 = new Pair<>(2, 1.0);
    Pair<Integer, Double> transmitter3 = new Pair<>(3, 1.0);
    Pair<Integer, Double> transmitter4 = new Pair<>(4, 1.0);
    Pair<Integer, Double> transmitter5 = new Pair<>(5, 1.0);
    List<Pair<Integer, Double>> expectedRadii = createExpectedRadii(transmitter1, transmitter2, transmitter3, transmitter4,
        transmitter5);

    Map<Integer, Double> actualRadii = NetworkTransmissionController.getMinimumRadiusPerTransmitter(Parser.parseGraph(input));

    assertNetwork(expectedRadii, actualRadii);
  }

  @Test
  public void centerTransmitterReachingTwoOthersAndOneOtherTransmitterReachingCenter() {
    String input = "{(1,1), (1,3), (2.5, 2), (5, 2)}";

    Pair<Integer, Double> transmitter1 = new Pair<>(1, 1.802776);
    Pair<Integer, Double> transmitter2 = new Pair<>(2, 1.802776);
    Pair<Integer, Double> transmitter3 = new Pair<>(3, 2.5);
    Pair<Integer, Double> transmitter4 = new Pair<>(4, 2.5);
    List<Pair<Integer, Double>> expectedRadii = createExpectedRadii(transmitter1, transmitter2, transmitter3, transmitter4);

    Map<Integer, Double> actualRadii = NetworkTransmissionController.getMinimumRadiusPerTransmitter(Parser.parseGraph(input));

    assertNetwork(expectedRadii, actualRadii);
  }

  @Test
  public void centerTransmitterWithSameShortestEdgesNotConnectedWithCenterTransmitter() {
    String input = "{(1,2), (2,3), (3,2), (2,1), (2,2), (2,4)}";

    Pair<Integer, Double> transmitter1 = new Pair<>(1, 1.0);
    Pair<Integer, Double> transmitter2 = new Pair<>(2, 1.0);
    Pair<Integer, Double> transmitter3 = new Pair<>(3, 1.0);
    Pair<Integer, Double> transmitter4 = new Pair<>(4 ,1.0);
    Pair<Integer, Double> transmitter5 = new Pair<>(5, 1.0);
    Pair<Integer, Double> transmitter6 = new Pair<>(6, 1.0);
    List<Pair<Integer, Double>> expectedRadii = createExpectedRadii(transmitter1, transmitter2, transmitter3, transmitter4,
        transmitter5, transmitter6);

    Map<Integer, Double> actualRadii = NetworkTransmissionController.getMinimumRadiusPerTransmitter(Parser.parseGraph(input));

    assertNetwork(expectedRadii, actualRadii);
  }


  @Test
  public void proofTest1() {
    String input = "{(54.2308, -66.0395), (-44.7392, 24.194), (-53.3391, -22.3683), (10.9936, 99.1662), (-90.4302, 99.2572), (43.2174, 28.7044), (-2.87929, -13.0876), (-86.1593, -32.9225), (-51.6195, 21.8886), (74.1398, -68.3909)}";

    Pair<Integer, Double> transmitter1 = new Pair<>(1, 77.881102);
    Pair<Integer, Double> transmitter2 = new Pair<>(2, 7.256266);
    Pair<Integer, Double> transmitter3 = new Pair<>(3, 51.306177);
    Pair<Integer, Double> transmitter4 = new Pair<>(4, 77.480569);
    Pair<Integer, Double> transmitter5 = new Pair<>(5, 86.557326);
    Pair<Integer, Double> transmitter6 = new Pair<>(6, 77.480569);
    Pair<Integer, Double> transmitter7 = new Pair<>(7, 77.881102);
    Pair<Integer, Double> transmitter8 = new Pair<>(8, 34.47545);
    Pair<Integer, Double> transmitter9 = new Pair<>(9, 86.557326);
    Pair<Integer, Double> transmitter10 = new Pair<>(10, 20.047378);

    List<Pair<Integer, Double>> expectedRadii = createExpectedRadii(transmitter1, transmitter2, transmitter3, transmitter4, transmitter5, transmitter6,
        transmitter7, transmitter8, transmitter9, transmitter10);

    Map<Integer, Double> actualRadii = NetworkTransmissionController.getMinimumRadiusPerTransmitter(Parser.parseGraph(input));

    assertNetwork(expectedRadii, actualRadii);
  }

  @Test
  public void proofTest2() {
    String input = "{(37.422, 40.4765), (63.2074, 33.0738), (75.0672, -53.5489), (-58.5362, 61.7153), (79.5671, 47.7554), (-10.4674, -64.9431), (10.5029, 12.2015), (7.95411, 65.3106), (14.3933, 19.3375), (-68.0097, 9.59374), (-58.0166, -23.7617), (87.8535, 75.6413), (37.4332, -70.7258), (79.6191, -68.3275), (-65.5384, -73.7769), (-16.0501, -63.3009), (-36.0858, -97.8464), (11.5004, -75.6496), (55.2117, 5.78339), (66.4852, -91.2327)}";
    Pair<Integer, Double> transmitter1 = new Pair<>(1, 38.536853);
    Pair<Integer, Double> transmitter2 = new Pair<>(2, 28.437611);
    Pair<Integer, Double> transmitter3 = new Pair<>(3, 62.566457);
    Pair<Integer, Double> transmitter4 = new Pair<>(4, 52.975506);
    Pair<Integer, Double> transmitter5 = new Pair<>(5, 29.091027);
    Pair<Integer, Double> transmitter6 = new Pair<>(6, 24.43795);
    Pair<Integer, Double> transmitter7 = new Pair<>(7, 8.127589);
    Pair<Integer, Double> transmitter8 = new Pair<>(8, 38.536853);
    Pair<Integer, Double> transmitter9 = new Pair<>(9, 31.259852);
    Pair<Integer, Double> transmitter10 = new Pair<>(10, 52.975506);
    Pair<Integer, Double> transmitter11= new Pair<>(11, 50.57764);
    Pair<Integer, Double> transmitter12= new Pair<>(12, 29.091027);
    Pair<Integer, Double> transmitter13= new Pair<>(13, 35.560535);
    Pair<Integer, Double> transmitter14= new Pair<>(14, 26.403551);
    Pair<Integer, Double> transmitter15= new Pair<>(15, 50.57764);
    Pair<Integer, Double> transmitter16= new Pair<>(16, 39.935208);
    Pair<Integer, Double> transmitter17= new Pair<>(17, 39.935208);
    Pair<Integer, Double> transmitter18= new Pair<>(18, 26.396097);
    Pair<Integer, Double> transmitter19= new Pair<>(19, 62.566457);
    Pair<Integer, Double> transmitter20= new Pair<>(20, 35.560535);
    List<Pair<Integer, Double>> expectedRadii = createExpectedRadii(transmitter1, transmitter2, transmitter3, transmitter4, transmitter5, transmitter6,
        transmitter7, transmitter8, transmitter9, transmitter10, transmitter11, transmitter12, transmitter13, transmitter14, transmitter15, transmitter16,
        transmitter17, transmitter18, transmitter19, transmitter20);

    Map<Integer, Double> actualRadii = NetworkTransmissionController.getMinimumRadiusPerTransmitter(Parser.parseGraph(input));

    assertNetwork(expectedRadii, actualRadii);
  }


  private void assertNetwork(List<Pair<Integer, Double>> expectedRadius, Map<Integer, Double> actualRadii) {
    NetworkTransmissionController.print(actualRadii);

    Assertions.assertEquals(expectedRadius.size(), actualRadii.size(),
        String.format("Result map should be of size %d", expectedRadius.size()));
    expectedRadius.forEach(expected -> {
      int transmitter = expected.getFirst();
      Assertions.assertTrue(actualRadii.containsKey(transmitter));
      Assertions.assertEquals(expected.getSecond(), actualRadii.get(transmitter), DELTA);
    });
  }

  @SafeVarargs
  private final List<Pair<Integer, Double>> createExpectedRadii(Pair<Integer, Double>... transmitter) {
    List<Pair<Integer, Double>> expected = new ArrayList<>(transmitter.length);
    Collections.addAll(expected, transmitter);
    return expected;
  }

}
