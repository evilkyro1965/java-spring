package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spittr.data.SpittleRepository;

/**
 * Created by Administrator on 10/6/15.
 */

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView spittles(
            @RequestParam(value="max", defaultValue = "1000000") long max,
            @RequestParam(value="count", defaultValue = "20") int count
    ){
        ModelAndView mv = new ModelAndView();
        mv.addObject("spittleList",spittleRepository.findSpittles(max,count));
        mv.setViewName("spittleView");
        return mv;
    }

}
