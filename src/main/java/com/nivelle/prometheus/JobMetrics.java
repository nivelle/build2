package com.nivelle.prometheus;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2022/02/12
 */
@Component
public class JobMetrics implements MeterBinder {
    public Counter job1Counter;
    public Counter job2Counter;

    public Map<String, Double> map;

    JobMetrics() {
        map = new HashMap<>();
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.job1Counter = Counter.builder("counter_builder_job_counter1")
                .tags(new String[]{"name", "tag_job_counter1"})
                .description("description-Job counter1 execute count").register(meterRegistry);

        this.job2Counter = Counter.builder("counter_builder_job_counter2")
                .tags(new String[]{"name", "tag_job_counter2"})
                .description("description-Job counter2 execute count ").register(meterRegistry);

        Gauge.builder("gauge_builder_job_gauge", map, x -> x.get("x"))
                .tags("name", "tag_job_gauge")
                .description("description-Job gauge")
                .register(meterRegistry);
    }

}
