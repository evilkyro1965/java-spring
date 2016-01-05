package kyrosoft.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 1/5/16.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "hello")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Hello Reader!");
        mv.setViewName("hello");
        return mv;
    }

}
