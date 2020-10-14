package com.example.micrometerprometheus;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author liyulong
 * @date 2020-10-08 9:31 下午
 */
@RestController
public class MetricController {

    private static int metric = 0;

    @Autowired
    private MetricManager metricManager;

    @Autowired
    private SampleStore sampleStore;


    @GetMapping("/test")
    public int getMetric() {
        sampleStore.set(Timer.start(Clock.SYSTEM));
        int inc = new Random().nextInt(10);
        metric += inc;
        metricManager.trackCounterMetrics("metric.count", String.valueOf(inc), "sampleAttr", "Attr1");
        metricManager.trackTimerMetrics("metric.transcation", "sampleAttr", "Attr2");
        return metric;
    }
}
