package com.wiley.beginningspring.ch3;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 10/5/15.
 */
@Controller
public class HelloReaderController {

    @RequestMapping(value = "/hello")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Hello Reader!");
        mv.setViewName("helloReader");
        return mv;
    }

}
