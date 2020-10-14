package com.example.micrometerprometheus;

/**
 * @author liyulong
 * @date 2020-10-08 9:14 下午
 */
public interface MetricManager {


    /**
     * 监控数量和时间
     *
     * @param metricName
     * @param args
     */
    void trackTimerMetrics(String metricName, String... args);


    /**
     * 监控增长量
     *
     * @param metricName
     * @param args
     */
    void trackCounterMetrics(String metricName, String... args);


}
