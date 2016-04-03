package proxy;

import net.jcip.annotations.NotThreadSafe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Intentionally not-thread-safe endpoint
 *
 * @author Maxim Neverov
 */
@NotThreadSafe
@Controller
@RequestMapping("/id")
@SpringBootApplication
@EnableWebMvc
public class NotThreadSafeCounter {

    /**
     * Should be guarded by global lock
     */
    private static int counter = 0;

    /**
     * Endpoint that returns value from counter
     *
     * @return value from counter
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String getId() {
        return Integer.toString(counter++);
    }

    public static void main(String[] args) {
        SpringApplication.run(NotThreadSafeCounter.class, args);
    }

}
