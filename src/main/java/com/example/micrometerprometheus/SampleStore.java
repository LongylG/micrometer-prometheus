package com.example.micrometerprometheus;

import io.micrometer.core.instrument.Timer;
import org.springframework.context.annotation.Configuration;

/**
 * Timer管理器，提供线程安全计时器
 *
 * @author liyulong
 * @date 2020-10-08 9:25 下午
 */
@Configuration
public class SampleStore {

    private static final InheritableThreadLocal<Timer.Sample> threadlocal = new InheritableThreadLocal<>();

    public void set(Timer.Sample sample) {
        threadlocal.set(sample);
    }

    public Timer.Sample get() {
        return threadlocal.get();
    }
}
