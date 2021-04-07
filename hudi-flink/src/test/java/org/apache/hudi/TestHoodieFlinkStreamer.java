package org.apache.hudi;

import com.beust.jcommander.JCommander;
import org.junit.Test;

public class TestHoodieFlinkStreamer {


  @Test
  public void test01() {
      String[] args = {"--checkpoint-interval", "60000", "--flink-checkpoint-path", "hdfs://rt2/hudi/test/flink/checkpoint"};
      final HoodieFlinkStreamer.Config cfg = new HoodieFlinkStreamer.Config();
      JCommander cmd = new JCommander(cfg, null, args);
      System.out.println(cmd);
  }
}
