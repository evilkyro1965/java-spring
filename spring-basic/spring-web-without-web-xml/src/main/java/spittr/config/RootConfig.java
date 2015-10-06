package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 10/6/15.
 */

@Configuration
@ComponentScan(
        basePackages = {"spittr"}
)
public class RootConfig {
}
