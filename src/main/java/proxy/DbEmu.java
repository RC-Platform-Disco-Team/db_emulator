package proxy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Maxim Neverov
 */
@Controller
@RequestMapping("/id")
public class DbEmu {

    /**
     * Should be guarded by global lock
     */
    private static int counter = 0;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String getId() throws Exception {
        return Integer.toString(counter++);
    }
}
