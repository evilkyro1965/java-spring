package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 10/6/15.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hellopage")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Hello Reader!");
        mv.setViewName("hello");
        return mv;
    }

}
