package org.apache.hudi;

import org.apache.hudi.common.model.HoodieRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class QuickstartUtilsTest {
    private static Random rand = new Random(46474747);

    private int numExistingKeys = 0;

    @Test
    public void testGenerateUpdates() throws Exception {
        try {
            QuickstartUtils.DataGenerator dataGenerator = new QuickstartUtils.DataGenerator();
            List<HoodieRecord> hoodieRecords = dataGenerator.generateUpdates(10);
            System.out.println(hoodieRecords);
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }

    }

    @Test
    public void test03() {

        Stream<Integer> stream = IntStream.range(0, 100000000).boxed().map(i -> {
            numExistingKeys++;
            return 1;
        });
        stream.collect(Collectors.toList());

        System.out.println(numExistingKeys);
    }

    @Test
    public void test02() {
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextDouble());

    }

    @Test
    public void testConvertToStringList() throws IOException {
        QuickstartUtils.DataGenerator dataGenerator = new QuickstartUtils.DataGenerator();
        List<String> list = QuickstartUtils.convertToStringList(dataGenerator.generateInserts(10));
        System.out.println(list);
    }

    @Test
    public void testGenerateInserts() throws Exception {
        QuickstartUtils.DataGenerator dataGenerator = new QuickstartUtils.DataGenerator();
        List<HoodieRecord> hoodieRecords = dataGenerator.generateInserts(10);
        System.out.println(hoodieRecords);
    }
}
