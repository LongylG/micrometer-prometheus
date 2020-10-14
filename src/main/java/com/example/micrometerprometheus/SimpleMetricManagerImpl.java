package com.example.micrometerprometheus;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyulong
 * @date 2020-10-08 9:21 下午
 */
@Service
public class SimpleMetricManagerImpl implements MetricManager {
    @Autowired
    private MeterRegistry meterRegistry;

    @Autowired
    private SampleStore sampleStore;

    @Override
    public void trackTimerMetrics(String metricName, String... args) {
        Timer timer = meterRegistry.timer(metricName, args);
        sampleStore.get().stop(timer);
    }

    @Override
    public void trackCounterMetrics(String metricName, String... args) {

    }
}
